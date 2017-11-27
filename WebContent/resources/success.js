/**
 * 
 */
var orders = document.getElementById("orders");
function getStatusUpdate(){
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	displayStatus(this.responseText);
    	}
    };
    xmlHttp.open( "GET", 
        		"statusUpdate",
        				true ); // false for synchronous request
    xmlHttp.send();	
}
function displayStatus(status){
	var json = JSON.parse(status);
	var i;
	for(i= 0; i < json.length; i++){
	    var textStatus = getStatus(json[i].status);
	    var completedPercentage = json[i].status * 20;
	    var htmlString = '<div style="margin: 30px">';
	    htmlString += '<div style="font-weight: 600">Order Reference# '+json[i].order_id+'</div>';
	    htmlString += '<div>'+json[i].order_date+'</div>';
	    htmlString += '<div>$'+json[i].total_amount+'</div>';
	    htmlString += '<div class="progress">';
	    htmlString += '<div class="progress-bar progress-bar-striped active" role="progressbar"aria-valuenow= "5" aria-valuemin="0" aria-valuemax="5" style="width:'+completedPercentage+'%">'+textStatus+'</div>';
	    htmlString += '</div></div>';
	    orders.insertAdjacentHTML("beforeend",htmlString);
	}

	/* receive multipule order
	 * status is a int between 0 - 5
	 * 0 = false 1 = order made 2 = restaurant received order
	 * 3 = restaurant prepareing 4 = delivering 5 = complete
	 */
}
function getStatus(status){
	var statueLabel = "Error";
	switch(status){
	case 1: statusLabel = "Order Received"; break;
	case 2: statueLabel = "Restaurant Reveived Your Order";break;
	case 3: statusLabel = "Your Food is Being Prepare";break;
	case 4: statusLabel = "The Food is on It's Way";break;
	case 5: statusLabel = "Order Complete, Please Engjoy Your food.";break;
	}
return statusLabel;
}