package classes;

public class ShoppingCart {

	private int item_id;
	private String item_name;
	private String item_price;
	private String item_image_link;
	private int restaurant_id;
	private int item_quantity;
	
public ShoppingCart(int item_id, String item_name, String item_price, String item_image_link, int restaurant_id, int item_quantity) {
	this.item_id = item_id;
	this.item_name = item_name;
	this.item_price = item_price;
	this.item_image_link = item_image_link;
	this.item_quantity = item_quantity;
	this.restaurant_id = restaurant_id;
	
}
public int get_item_id() {
	return item_id;
}
public int get_item_quantity() {
	return item_quantity;
}
public void set_item_quantity(int item_quantity) {
	this.item_quantity = item_quantity;
}
public void set_item_name(String item_name){
	this.item_name = item_name;
}
public void set_item_price(String item_price){
	this.item_price = item_price;
}
public String get_item_price() {
	return item_price;
}
public void set_image_link(String item_image_link){
	this.item_image_link = item_image_link;
}
public int get_restaurant_id() {
	return restaurant_id;
}
}
