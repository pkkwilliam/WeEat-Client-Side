package classes;

public class Item {
	
	private int item_id;
	private String item_name;
	private String item_price;
	private String item_image_link;
	private String item_description;
	private int restaurant_id;
	
public Item(int item_id, String item_name, String item_price, 
		String item_image_link, String item_description, int restaurant_id) {
	this.item_id = item_id;
	this.item_name = item_name;
	this.item_price = item_price;
	this.item_image_link = item_image_link;
	this.item_description = item_description;
	this.restaurant_id = restaurant_id;
}
}
