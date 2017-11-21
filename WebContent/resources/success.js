/**
 * 
 */
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
	var status = json[0].status;
	var statueLabel = "Error";
	switch(status){
	case 1: statusLabel = "Order Received"; break;
	case 2: statueLabel = "Restaurant Reveived Your Order";break;
	case 3: statusLabel = "Your Food is Being Prepare";break;
	case 4: statusLabel = "Your Food is Being Deliver";break;
	case 5: statusLabel = "Order Complete, Please Engjoy Your food.";break;
	}

	document.getElementById('progressBar').innerHTML = '<div class="progress-bar progress-bar-striped active" role="progressbar"aria-valuenow= "5" aria-valuemin="0" aria-valuemax="5" style="width:20%">'+statusLabel+'</div>';
	document.getElementById('orderNumber').innerHTML = "Order Reference# "+json[0].order_id;
	
	
	
	/* receive multipule order
	 * status is a int between 0 - 5
	 * 0 = false 1 = order made 2 = restaurant received order
	 * 3 = restaurant prepareing 4 = delivering 5 = complete
	 */
}