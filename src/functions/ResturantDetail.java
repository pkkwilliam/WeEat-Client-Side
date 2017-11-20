package functions;

import classes.Restaurant;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import databases.DatabaseConnection;
import databases.ComplicatedQuery;
import com.google.gson.Gson;
import static Values.Strings.resturant_detail_SQLTable;
import static Values.Strings.detail_restaurant_id;
import static Values.Strings.detail_detail_description;
import static Values.Strings.resturant_image_link;
import static Values.Strings.detail_restaurant_name;
import static Values.Strings.detail_short_description;
import static Values.Strings.detail_restaurant_address;
import static Values.Strings.detail_restaurant_city;
import static Values.Strings.detail_restaurant_state;
import static Values.Strings.detail_restaurant_zip;
import static Values.Strings.detail_restaurant_tel;
import static Values.Strings.detail_restaurant_cuisine;

public class ResturantDetail {
	
public static String getDetails(ArrayList<Integer> resturantsID) throws SQLException {
	Gson gson = new Gson();
	String json = "";
	
	String query = ComplicatedQuery.listingQuery(
			resturantsID, "*", resturant_detail_SQLTable, detail_restaurant_id);
	
	// convert to string for query, limit method in database
	ResultSet result = DatabaseConnection.query(query.toString());
		/* 
		    This can be more efficient by using gson.TypeAdapter
		    Or other methods that do not create an restaurant object then
		    conert to gson object
		*/
		
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		while(result.next()) {
			list.add(new Restaurant(
					result.getInt(detail_restaurant_id),
					result.getString(detail_detail_description),
					result.getString(resturant_image_link),
					result.getString(detail_restaurant_name),
					result.getString(detail_short_description),
					result.getString(detail_restaurant_address),
					result.getString(detail_restaurant_city),
					result.getString(detail_restaurant_state),
					result.getString(detail_restaurant_zip),
					result.getString(detail_restaurant_tel),
					result.getString(detail_restaurant_cuisine)
					));
		}
		json += gson.toJson(list);
	
	return json;
}
public static void updateDetail() {
	String query = "UPDATE restaurant_review SET review_rating = '3.1' WHERE review_id = 1";
}
}
