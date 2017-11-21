<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>

<spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" var="jqueryJS" />
<script src="${jqueryJS}"></script>
<spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" var="bootStrapJS" />
<script src="${bootStrapJS}"></script>
<spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" var="bootStrapCSS" />
<link href="${bootStrapCSS}" rel="stylesheet"/>
</head>
<body>
<spring:url value="/resources/img/wheat.png" var="logo"/>
    <form method = "GET">
    <ul>
    	   <li><img style="width:50px; height: 50px;" src="${logo}"/></li>
       <li> <a href="welcome">Restaurant</a> </li>
       <li> <a href="success">Order Status</a> </li>
       <li> <a href="go_shopping_cart">Cart</a> </li>
       <li> <a href="clearSession">Log Out</a> </li>
       <li> <span id="username">${username}</span></li>
    </ul>

    </form>
    <form id="checkLogin" method ="GET" action="checkLogin"></form>
    
</body>
<spring:url value="/resources/header.js" var="headerJS" />
<script src="${headerJS}"></script>
</html>