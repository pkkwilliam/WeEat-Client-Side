<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<div style="margin: 50px">
<h3>Your Shopping Cart</h3>
	<span id="list"></span>
	<div>Total: <span id = "total"></span></div>

	<form action = "place_order" method = "GET">
		<button type="submit" class="btn btn-primary btn-md">Place Order</button>
	</form>
</div>
</body>
<spring:url value="/resources/shopping_cart.js" var="shopping_cartJS" />
<script src="${shopping_cartJS}"></script>
<script>window.onload = getCartItem()</script>
</html>