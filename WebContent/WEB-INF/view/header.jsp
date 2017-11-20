<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
</head>
<body>

    <form method = "GET">
        <input type="submit" value="Restaurants" formaction="welcome"/>
        <input type="submit" value="Order Status" formaction="success"/>
        <input type="submit" value="Cart" formaction="go_shopping_cart"/>
        <input type="submit" value="Log Out" formaction="clearSession"/>
        <span id="username">${username}</span>
    </form>
    <form id="checkLogin" method ="GET" action="checkLogin"></form>
    
</body>
<spring:url value="/resources/header.js" var="headerJS" />
<script src="${headerJS}"></script>
</html>