package viewController;

import static Values.Strings.ORDERS_SQLTABLE;
import static Values.Strings.sessionCart;
import static Values.Strings.sessionUsername;
import static Values.Strings.user_Username;
import static Values.Strings.user_cart_SQLTABLE;
import static Values.Strings.cart_json;
import static Values.Strings.getOrderAttribute;
import static Values.Strings.getCartAttribute;
import static databases.ComplicatedQuery.variableNumberInsertQuery;
import static databases.ComplicatedQuery.updateQuery;
import static databases.DatabaseConnection.insert;
import static databases.DatabaseConnection.query;
import static databases.DatabaseConnection.deleteAndUpdateQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

import classes.ShoppingCart;


@Controller
// This is usaully store as JSON, it can store as object to save much convertion 
@SessionAttributes({sessionCart,sessionUsername})
public class ShoppingCartController {

	// This function run when shopping_cart.jsp first load
	@RequestMapping(value = "get_cart", method = RequestMethod.GET)
	@ResponseBody
	public String getCart(ModelMap model) throws SQLException {
		String sessionCartJson = null;
		String username = String.valueOf(model.get(sessionUsername));
		String checkCartQuery = "SELECT "+cart_json+" FROM "+user_cart_SQLTABLE+" WHERE "+user_Username+" = "+username;
		ResultSet resultSet = query(checkCartQuery);
		while(resultSet.next()) {
				sessionCartJson = resultSet.getString(cart_json);
		}
		return sessionCartJson;
	}
	// Update cart
	@RequestMapping(value = "updateCart", method = RequestMethod.POST)
	@ResponseBody
	public String updateCart(
			@RequestParam int item_id,
			@RequestParam int item_quantity,
			ModelMap model) {
		String username = String.valueOf(model.get(sessionUsername));
		String cartJson = getJsonCartByUserName(username);
		cartJson = updateCartQuantity(cartJson, item_id, item_quantity);
		if(updateJsonItemToDatabase(cartJson, username))
			return cartJson;
		else
			return "";
	}
	
	// Delete Item in Cart
	@RequestMapping(value = "delete_item", method = RequestMethod.POST)
	@ResponseBody
	public String deleteItem(@RequestParam int item_id, ModelMap model) {
		String username = String.valueOf(model.get(sessionUsername));
		String cartJson = getJsonCartByUserName(username);
		cartJson = deleteItem(cartJson, item_id);
		if(updateJsonItemToDatabase(cartJson, username))
			return cartJson;
		else 
			return "";
	}
	@RequestMapping(value = "/add_item_to_shoppingcart", method = RequestMethod.POST)
	@ResponseBody
	// functions.ShoppingCartFunctions.addItemToCart
	public String addItem(
			@RequestParam int item_id, 
			@RequestParam String item_name,
			@RequestParam String item_price,
			@RequestParam String item_image_link,
			@RequestParam int restaurant_id,
			@RequestParam int item_quantity,
			ModelMap model) throws SQLException {
		

		String username = String.valueOf(model.get(sessionUsername));
		String sessionCartJson = null;
		sessionCartJson = getJsonCartByUserName(username);
		
		//System.out.println("Session Cart: "+sessionCartJson);
		// Update
		if(sessionCartJson != null) {
			//System.out.println("Update");
			String updatedCartItem = updateCartJson(sessionCartJson, item_id, item_name,item_price,item_image_link,restaurant_id,item_quantity);
			if(updateJsonItemToDatabase(updatedCartItem,username))
				return item_quantity + "x " +item_name +" added to cart";
			else
				return "Fail to update item into cart.";	
		// Create new cart	
		} else{
			String returnJson = updateCartJson(sessionCartJson, item_id, item_name, item_price, item_image_link,restaurant_id,item_quantity);
			String[] value = {String.valueOf(model.get(sessionUsername)),returnJson};
			String query = variableNumberInsertQuery(getCartAttribute(),value, user_cart_SQLTABLE);
			//System.out.println(query);
			boolean result = insert(query);
			if(result)
			    return item_quantity + "x " +item_name +" added to cart";
			else
				return "Fail to update item into cart.";
		}
	}

	@RequestMapping(value = "place_order", method = RequestMethod.GET)
	public String placeOrder(ModelMap model) {
		
		String username = String.valueOf(model.get(sessionUsername));
		String orderJson = getJsonCartByUserName(username);
		if(orderJson != null && orderJson != "") {
			if(placeOrder(orderJson, username)) {
				String deleteCartQuery = "DELETE FROM cart WHERE username = '"+username+"'";
				deleteAndUpdateQuery(deleteCartQuery);
				return "success";
			}else
				return "shopping_cart";		
		}
		else 
			return "shopping_cart";
	}
	
	// Methods
	private static boolean updateJsonItemToDatabase(String updatedCartItem, String username) {
		String query = updateQuery(user_cart_SQLTABLE, cart_json, updatedCartItem, user_Username, username);
		if(insert(query))
			return true;
		else 
			return false;
	}
	private static String getJsonCartByUserName(String username) {
		String query = "SELECT "+cart_json+" FROM "+user_cart_SQLTABLE+" WHERE "+user_Username+" = "+username;
		ResultSet resultSet = query(query);
		String result = null;
		try {
			while(resultSet.next())
				result = resultSet.getString(cart_json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private static String updateCartJson (String json, int item_id, String item_name, String item_price, String item_image_link , int restaurant_id, int item_quantity) {
		// Add item if session json is empty
		if(json == null || json.isEmpty() || json.equals("null")){
			ShoppingCart cart = new ShoppingCart(item_id, item_name, item_price, item_image_link, restaurant_id, item_quantity);
			StringBuilder stringBuilderJson = new StringBuilder("[");
			String item = new Gson().toJson(cart);
			System.out.println(item);
			stringBuilderJson.append(item);
			stringBuilderJson.append("]");
			String returnJson = stringBuilderJson.toString();
			return returnJson;
		}else{ //add item if session json has something
			ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
			ShoppingCart sessionItems[] = new Gson().fromJson(json,ShoppingCart[].class);
			boolean localCheck = false;
			for(ShoppingCart item: sessionItems) {
				if(item.get_item_id() == item_id) {
					item.set_item_quantity(item.get_item_quantity()+item_quantity);
					list.add(item);
					// check if there is same item in the cart, if yes, update quantity only
					localCheck = true;
				}else
					list.add(item);
			}
			if(localCheck == false) 
				list.add(new ShoppingCart(item_id, item_name, item_price, item_image_link,restaurant_id ,item_quantity));
			
			String returnJson = new Gson().toJson(list);
			return returnJson;
		}
	}
	private static String updateCartQuantity(String json, int item_id, int item_quantity) {
		ShoppingCart cart[] = new Gson().fromJson(json, ShoppingCart[].class);
		ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
		for(ShoppingCart item: cart) {
			if(item.get_item_id() == item_id) {
				if(item_quantity > 0) {
					item.set_item_quantity(item_quantity);
					list.add(item);
				}
					
			}else {
				list.add(item);
			}
		}
		return new Gson().toJson(list);
	}
	private static String deleteItem(String json, int item_id) {
		ShoppingCart cart[] = new Gson().fromJson(json, ShoppingCart[].class);
		ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
		for(ShoppingCart item: cart) {
			if(item.get_item_id() != item_id) {
			    list.add(item);
			}
		}
		return new Gson().toJson(list);
	}
	private static boolean placeOrder(String json, String username) {
		ShoppingCart cart[] = new Gson().fromJson(json, ShoppingCart[].class);
		double amountTotal = 0;
		int restaurantId = 0;
		for(ShoppingCart item: cart) {
			amountTotal += Double.valueOf(item.get_item_price())*item.get_item_quantity();
			restaurantId = item.get_restaurant_id();
		}
		System.out.println(amountTotal);
		// last parameter: 1 = status, the other is date of order
		System.out.println(new java.util.Date().toString());
		String values[] = {json,username,String.valueOf(restaurantId),String.valueOf(amountTotal),new java.util.Date().toString(),"1"}; 
		String query = variableNumberInsertQuery(getOrderAttribute(),values,ORDERS_SQLTABLE);
	    return insert(query);    
	}
}
