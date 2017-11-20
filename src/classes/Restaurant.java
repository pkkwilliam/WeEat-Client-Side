package classes;

public class Restaurant {
	private int restaurant_id;
	private String restaurant_detail_description;
	private String restaurant_image_link;
	private String restaurant_name;
	private String restaurant_short_description;
	private String restaurant_address;
	private String restaurant_city;
	private String restaurant_state;
	private String restaurant_zip;
	private String restaurant_tel;
	private String restaurant_cuisine;
	
public Restaurant(
		int resturant_id,
		String resturant_detail_description, String resturant_image_link,
		String resturant_name, String resturant_short_description,
		String resturant_address, String resturant_city, String resturant_state,
		String resturant_zip, String resturant_tel, String restaurant_cuisine
		){
	this.restaurant_id = resturant_id;
	this.restaurant_detail_description = resturant_detail_description;
	this.restaurant_image_link = resturant_image_link;
	this.restaurant_name = resturant_name;
	this.restaurant_short_description = resturant_short_description;
	this.restaurant_address = resturant_address;
	this.restaurant_city = resturant_city;
	this.restaurant_state = resturant_state;
	this.restaurant_zip = resturant_zip;
	this.restaurant_tel = resturant_tel;
	this.restaurant_cuisine = restaurant_cuisine;
	
}
}
