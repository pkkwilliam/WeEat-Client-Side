package functions;

import static databases.DatabaseConnection.query;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.Item;
import static Values.Strings.detail_restaurant_id;
import static Values.Strings.items_SQLTable;
import static Values.Strings.item_id;
import static Values.Strings.item_name;
import static Values.Strings.item_price;
import static Values.Strings.item_image_link;
import static Values.Strings.item_description;
import static Values.Strings.detail_restaurant_id;


public class FoodItems {
	public static String getItems(String returantID) throws SQLException {
		Gson gson = new Gson();
		String json = "";
		String getItemsQuery = 
				"SELECT " + "*" + " FROM " + items_SQLTable +
				" WHERE " + detail_restaurant_id + " = "+returantID;
		
		ResultSet result = query(getItemsQuery);
		ArrayList<Item> list = new ArrayList<Item>();
		while(result.next()) {
			list.add(new Item(
					result.getInt(item_id),
					result.getString(item_name),
					result.getString(item_price),
					result.getString(item_image_link),
					result.getString(item_description),
					result.getInt(detail_restaurant_id)
					));
		}
		json += gson.toJson(list);
	    return json;	
	}
}
