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
	document.getElementById("status").innerHTML = "Your location: "+latitude+" "+longtitude;
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
		htmlString += '<div class="panel panel-primary" style="margin: 20px;">';
		htmlString += '<div class="panel-heading">'+ data[i].restaurant_name +'</div>';
		htmlString += '<table><tr>';
		htmlString += '<td width="67"><img style="width: 60; height: 60;"          src="'+data[i].restaurant_image_link+'"/></td>';
		htmlString += '<td width="232"><span>'+data[i].restaurant_short_description+'</span></td>';
		htmlString += '</tr><tr style="font-size: 12px;">';
		htmlString += '<td colspan="2">'+data[i].restaurant_address+' '+data[i].restaurant_city+' '+data[i].restaurant_state+' '+data[i].restaurant_zip+' Tel:'+data[i].restaurant_tel+'</td>';
		htmlString += '</tr></table></div><br/>';
		list.insertAdjacentHTML("beforeend",htmlString);
	}
}
function get_id(id_number){
	document.getElementById("status").innerHTML = id_number;
	localStorage.setItem("restaurant_id", id_number);
	window.location = "item";
}
