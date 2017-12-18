<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<title>WeEat.com</title>


<%@ include file ="header.jsp" %>
</head>
<spring:url value="/resources/test.css" var="real" />
<script src="${real}"></script>
<style>

</style>
<body>
<div id = "location"></div>
<span id="status"></span>
<div class="container">
	<span id="list"></span>
</div>
</body>

<spring:url value="/resources/get_restaurant.js" var="get_restaurant" />
<script src="${get_restaurant}"></script>
<script>window.onload = getGeolocation()</script>
<%@ include file ="footer.jsp" %>
</html>