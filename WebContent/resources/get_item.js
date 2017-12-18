/*
 * JavaScript Get Restaurant
 * Create by KaKei Pun(William)
 * Oct 30, 2017
 */
var restaurant_id = localStorage.getItem("restaurant_id");
document.getElementById("status").innerHTML = restaurant_id;
var list = document.getElementById("list");

function getItem(){
	 var xmlHttp = new XMLHttpRequest();
	    xmlHttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	            renderHTML(this.responseText);
	    	}
	    };
	    xmlHttp.open( "POST", 
	        		"getItemHandler?restaurant_id=" + restaurant_id,
	        				true ); // false for synchronous request
	    xmlHttp.send();	
}
function renderHTML(data){
	data = JSON.parse(data);
	
	var i;
	for(i = 0; i < data.length; i++){
		var idNumber = "number" + data[i].item_id;
		var htmlString = "<div>";
		htmlString += "<p>"+ data[i].item_name +"</p>";
		htmlString += "<p>"+ data[i].item_price +"</p>";
		htmlString += "<p>"+ data[i].item_image_link+"</p>";
		htmlString += "<p>"+ data[i].item_description+"</p>";
		htmlString += "<input id="+ idNumber +" type='number' value='1'/>";
		htmlString += '<button onClick = "addItem(\''+data[i].item_id+'\',\''
		+data[i].item_name+'\',\''
		+data[i].item_price+'\',\''
		+data[i].item_image_link+'\',\''
		+data[i].restaurant_id+'\',\''
		+idNumber
		+'\')">ADD</button>';
		
	    htmlString += "</div>";
		list.insertAdjacentHTML("beforeend",htmlString);
	}
}
function addItem(item_id, item_name, item_price,item_image_link,restaurand_id,idNumber){
	// work of getting the quantity
	var item_quantity = document.getElementById(idNumber).value;
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert(this.responseText);
    	}
    };
    xmlHttp.open( "POST", 
        		"add_item_to_shoppingcart?item_id=" + item_id +
        		"&item_name="+ item_name+
        		"&item_price="+item_price+
        		"&item_image_link=" + item_image_link+
        		"&restaurant_id="+restaurand_id+
        		"&item_quantity="+item_quantity,
        				true ); // false for synchronous request
    xmlHttp.send();	
}
