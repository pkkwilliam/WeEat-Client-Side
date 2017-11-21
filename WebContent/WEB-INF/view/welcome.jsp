<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<%@ include file ="header.jsp" %>
</head>
<body>
<div id = "location"></div>
<span id="status"></span>
<span id=list></span>
</body>
<spring:url value="/resources/get_restaurant.js" var="get_restaurant" />
<script src="${get_restaurant}"></script>
<script>window.onload = getGeolocation()</script>
</html>