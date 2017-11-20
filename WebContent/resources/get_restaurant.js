/*
 * JavaScript Get Restaurant
 * Create by KaKei Pun(William)
 * Oct 28, 2017
 */


var result = document.getElementById("result");
function getGeolocation(){
	var request = new XMLHttpRequest();
	var url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyBKlsmgBuELo1u3G33dHkI_DNNPZ2i4_p8";
	request.open('POST',url);
	request.onload = function(){
		parseJSON(request.responseText);
	};
	request.send();
}
function parseJSON(json){
	json = JSON.parse(json);
	var latitude = json.location.lat;
	var longtitude = json.location.lng;
	getRestaurant(latitude,longtitude);
	
}
function getRestaurant(latitude, longtitude){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            renderHTML(this.responseText);
    	}
    };
    xmlHttp.open( "POST", 
        		"getRestaurantHandle?latitude="+latitude+"&longtitude="+longtitude, 
        				true ); // false for synchronous request
    xmlHttp.send();	
}
function renderHTML(data){
	data = JSON.parse(data);
	var i;
	for(i = 0; i < data.length; i++){
		var htmlString = "<div id="+data[i].restaurant_id+" onClick='get_id(this.id)'>";
		htmlString += "<li>"+ data[i].restaurant_image_link +"</li>";
		htmlString += "<li>"+ data[i].restaurant_name +"</li>";
		htmlString += "<li>"+ data[i].restaurant_short_description+"</li>";
		htmlString += "<li>"+ data[i].restaurant_address+"</li>";
		htmlString += "<li>"+ data[i].restaurant_city+"</li>";
		htmlString += "<li>"+ data[i].restaurant_state+"</li>";
		htmlString += "<li>"+ data[i].restaurant_zip+"</li>";
	    htmlString += "</div>";
		list.insertAdjacentHTML("beforeend",htmlString);
	}
}
function get_id(id_number){
	document.getElementById("status").innerHTML = id_number;
	localStorage.setItem("restaurant_id", id_number);
	window.location = "item";
}
