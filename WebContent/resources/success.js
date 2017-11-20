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
	document.getElementById('status').innerHTML = "Your Status: "+status;
	/* receive multipule order
	 * status is a int between 0 - 5
	 * 0 = false 1 = order made 2 = restaurant received order
	 * 3 = restaurant prepareing 4 = delivering 5 = complete
	 */
}