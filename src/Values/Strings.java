package Values;

public class Strings {

//Domain
public static final String domainHTML = "weeatdotcom";

// Session
public static final String sessionUsername = "username";
public static final String sessionCart = "sessionCart";

// MySQL Tables
public static final String items_SQLTable = "items";
public static final String resturant_detail_SQLTable = "resturant_detail";
public static final String restaurant_geolocation_SQLTable = "resturant_geolocation";
public static final String restaurant_owner_detail_SQLTable = "resturant_owner_detail";
public static final String users_SQLTable = "users";
public static final String restaurant_review_SQLTable = "restaurant_review";
public static final String ORDERS_SQLTABLE = "orders";
public static final String user_cart_SQLTABLE = "cart";

// items
public static final String item_id = "item_id";
public static final String item_name = "item_name";
public static final String item_price = "item_price";
public static final String item_image_link = "item_image_link";
public static final String item_description = "item_description";

// resturant_detail
public static final String detail_restaurant_id = "resturant_id";
public static final String detail_restaurant_owner_id = "resturant_owner_id";
public static final String detail_detail_description = "detail_description";
public static final String resturant_image_link = "resturant_image_link";
public static final String detail_restaurant_name = "resturant_name";
public static final String detail_short_description = "short_description";
public static final String detail_restaurant_address = "restaurant_address";
public static final String detail_restaurant_city = "resturant_city";
public static final String detail_restaurant_state = "resturant_state";
public static final String detail_restaurant_zip = "resturant_zip";
public static final String detail_restaurant_tel = "resturant_tel";
public static final String detail_restaurant_cuisine = "cuisine";


// restaurant_owner_detail
public static final String owner_Username = "username";
public static final String owner_Password = "password";
public static final String owner_Firstname = "firstname";
public static final String owner_Lastname = "lastname";
public static final String owner_Email = "email";
public static final String owner_Tel = "tel";


// users
public static final String user_Username = "username";
public static final String user_Password = "password";
public static final String user_Firstname = "firstname";
public static final String user_Lastname = "lastname";
public static final String user_Email ="email";
public static final String user_Tel = "tel";
public static String[] getUserAttributes() {
	return new String[] {user_Username,user_Password,user_Firstname,user_Lastname,user_Email,user_Tel};
}

// Orders SQL Table
// This table can be imporve by sepearte it into a trigger where status != 5
public static final String order_id = "order_id";
public static final String order_item_json = "item_json";
public static final String order_total = "total_amount";
public static final String order_date = "order_date";
public static final String status = "status";
public static String[] getOrderAttribute() {
	return new String[] {order_item_json,user_Username,detail_restaurant_id,order_total,order_date,status};
}

// Cart SQL Table
public static final String cart_json = "cart_json";
public static String[] getCartAttribute() {
	return new String [] {user_Username, cart_json};
}

// restaurant_review
public static final String restaurant_review_id = "review_id";
public static final String restaurant_review_rating = "review_rating";

// Other Values

//resturant_geolocation
public static final String geolocation_longtitude = "longtitude";
public static final String geolocation_latitude = "latitude";
}
