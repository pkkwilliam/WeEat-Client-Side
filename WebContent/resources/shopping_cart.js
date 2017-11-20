/*
 * JavaScript Get Restaurant
 * Create by KaKei Pun(William)
 * Nov 2, 2017
 */
var list = document.getElementById("list");
var total = document.getElementById("total");

function getCartItem(){
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            renderHTML(this.responseText)
    	}
    };
    xmlHttp.open( "GET", 
        		"get_cart",
        				true ); // false for synchronous request
    xmlHttp.send();	
}

function updateCart(item_id, idNumber){
	var item_quantity = document.getElementById(idNumber).value;
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            renderHTML(this.responseText)
    	}
    };
    xmlHttp.open( "POST", 
        		"updateCart?item_id="+item_id+"&item_quantity="+item_quantity,
        				true ); // false for synchronous request
    xmlHttp.send();	
}
function deleteItem(item_id){
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            renderHTML(this.responseText)
    	}
    };
    xmlHttp.open( "POST", 
        		"delete_item?item_id="+item_id,
        				true ); // false for synchronous request
    xmlHttp.send();	
}
function renderHTML(data){
	list.innerHTML = "";
	data = JSON.parse(data);
	var totalAmount = 0;
	for(var i = 0; i < data.length; i++){
		var htmlString = "<div>";
		var idNumber = "number" + data[i].item_id;
		htmlString += "<p>"+ data[i].item_name +"</p>";
		htmlString += "<p>"+ data[i].item_price +"</p>";
		htmlString += "<p>"+ data[i].item_image_link +"</p>";
		// An input of number when changes make it will call function addItem
		htmlString += '<input id = '+idNumber+' type="number" value='+data[i].item_quantity+' onchange = "updateCart(\''+data[i].item_id+'\',\''+idNumber+'\')"/>';
		
		htmlString += '<button onClick = "updateCart(\''+data[i].item_id+'\',\''+idNumber+'\')">Add 1</button>';
		htmlString += '<button onClick = "deleteItem(\''+data[i].item_id+'\')">Delete</button>';
	    htmlString += "</div>";
	    totalAmount += (data[i].item_price * data[i].item_quantity);
		list.insertAdjacentHTML("beforeend",htmlString);
		
	}
	total.innerHTML = "$"+totalAmount;
}

