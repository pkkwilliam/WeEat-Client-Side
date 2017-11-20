package viewController;

import static Values.Strings.sessionCart;
import static Values.Strings.sessionUsername;
import static Values.Strings.order_id;
import static Values.Strings.order_item_json;
import static Values.Strings.user_Username;
import static Values.Strings.detail_restaurant_id;
import static Values.Strings.order_total;
import static Values.Strings.order_date;
import static Values.Strings.status;
import static Values.Strings.ORDERS_SQLTABLE;
import classes.Orders;
import static databases.DatabaseConnection.query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

@Controller
@SessionAttributes({sessionCart,sessionUsername})
public class SuccessController {
    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String success(ModelMap model) {    
    	System.out.println("success page");
    	    return "success";
    }
    @RequestMapping(value = "statusUpdate", method = RequestMethod.GET)
    @ResponseBody
    public String statusUpdate(ModelMap model, SessionStatus session) {
     	String username = String.valueOf(model.get(sessionUsername));
     	ArrayList<Orders> result = getStatusUpdate(username);
    	    return new Gson().toJson(result);
    }
    
    // methods 

    private static ArrayList<Orders> getStatusUpdate(String username) {    // this need to impore by receiving multiple order
    	    String query = "SELECT * FROM "+ORDERS_SQLTABLE+" WHERE username = '"+username+"' AND status < 5";
    	    ResultSet result = query(query);
    	    ArrayList<Orders> orders = new ArrayList<Orders>();
    	    try {
				while(result.next()) {
						orders.add(new Orders(
								result.getInt(order_id),
								result.getString(order_item_json),
								result.getString(user_Username),
								result.getInt(detail_restaurant_id),
								result.getString(order_total),
								result.getString(order_date),
								result.getInt(status)
								));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	    return orders;
    }
    
}
