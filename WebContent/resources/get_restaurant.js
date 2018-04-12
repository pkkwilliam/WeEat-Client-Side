/*
 * JavaScript Get Restaurant
 * Create by KaKei Pun(William)
 * Oct 28, 2017
 */


var list = document.getElementById("list");
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
	document.getElementById("location").innerHTML = "Your Location is "+latitude+" "+longtitude;
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
	var memmory = '<div class="row">';
		for(i = 0; i < data.length; i++){
			var htmlString = '<div class="col-lg-6 portfolio-item" id='+data[i].restaurant_id+' onClick="get_id(this.id)">';
			htmlString += '<div class="card h-100">';
			if(data[i].restaurant_image_link == null)		
			htmlString += '<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>';
			else{
				// Should be this since it can take restaurant ID
				//var link = 'http://karmaincorporated.com/imageRecognitionUpload/'+data[i].restaurant_id+'/'+data[i].restaurant_image_link;
				var link = 'http://karmaincorporated.com/imageRecognitionUpload/'+data[i].restaurant_image_link;
				htmlString += '<img style="height:350;" src="'+link+'"/>';
			}
			htmlString += '<div class="card-body" style="height:160px">';
			htmlString += '<h4 class="card-title">';
			htmlString += '<a>'+data[i].restaurant_name+'</a>';
			htmlString += '</h4>';
			htmlString += '<p class="card-text">'+data[i].restaurant_detail_description+'</p>';
			htmlString += '<p class="card-text">'+data[i].restaurant_address+' '+data[i].restaurant_city+' '+data[i].restaurant_state+' '+data[i].restaurant_zip+' Tel:'+data[i].restaurant_tel+'</p>';
			htmlString += '</div></div></div>';
			memmory += htmlString;
		}
		memmory += '</row>';
		list.innerHTML = memmory;
	}
function get_id(id_number){
	document.getElementById("status").innerHTML = id_number;
	localStorage.setItem("restaurant_id", id_number);
	window.location = "item";
}
