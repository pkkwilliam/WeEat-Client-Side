package functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import classes.Restaurant;
import databases.DatabaseConnection;
import databases.ComplicatedQuery;
import static Values.Strings.restaurant_geolocation_SQLTable;
import static Values.Strings.resturant_detail_SQLTable;
import static Values.Strings.resturant_image_link;
import static Values.Strings.geolocation_latitude;
import static Values.Strings.geolocation_longtitude;
import static Values.Strings.detail_detail_description;
import static Values.Strings.detail_restaurant_address;
import static Values.Strings.detail_restaurant_city;
import static Values.Strings.detail_restaurant_cuisine;
import static Values.Strings.detail_restaurant_id;
import static Values.Strings.detail_restaurant_name;
import static Values.Strings.detail_restaurant_state;
import static Values.Strings.detail_restaurant_tel;
import static Values.Strings.detail_restaurant_zip;
import static Values.Strings.detail_short_description;

public class ResturantNearBy {
	
public static String getList(String latitude, String longtitude) {

	String query = ComplicatedQuery.geolocationWithinQuery(
			detail_restaurant_id, restaurant_geolocation_SQLTable, 
			latitude, longtitude);
	
	// Get List of Resutrant Within Area
	ResultSet result = DatabaseConnection.query(query);
	ArrayList<Integer> list = new ArrayList<Integer>();
	try {
		while(result.next()) {
			list.add(result.getInt(detail_restaurant_id));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return getDetails(list);
}

public static String getDetails(ArrayList<Integer> resturantsID){
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
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json += gson.toJson(list);
	
	return json;
}
}	
