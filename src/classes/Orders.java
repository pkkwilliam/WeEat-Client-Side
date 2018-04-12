package classes;

public class Orders {
private int order_id;
private String item_json;
private String username;
private int resturant_id;
private String total_amount;
private String order_date;
private int status;
private boolean reviewed;

public Orders (int order_id, String item_json, String username, int resturant_id, String total_amount, String order_date, int status, boolean reviewed) {
	this.order_id = order_id;
	this.item_json = item_json;
	this.username = username;
	this.resturant_id = resturant_id;
	this.total_amount = total_amount;
	this.order_date = order_date;
	this.status = status;
	this.reviewed = reviewed;
}
}
