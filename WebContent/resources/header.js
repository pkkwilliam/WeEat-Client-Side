/*
 * JavaScript Get Restaurant
 * Create by KaKei Pun(William)
 * Nov 2, 2017
 */
var username = document.getElementById('username').innerHTML;
if(username == "")
	document.getElementById('checkLogin').submit();

function clearSession(){
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert(this.responseText);
    	}
    };
    xmlHttp.open( "GET", 
        		"clearSession",
        				true ); // false for synchronous request
    xmlHttp.send();	
}
function checkLogin(){
	window.location = "welcome";
	
}
function go_shopping_cart(){
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", 
        		"go_shopping_cart",
        				true ); // false for synchronous request
    xmlHttp.send();	
}