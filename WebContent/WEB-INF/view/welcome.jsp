<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>WeEat.com</title>
<link rel="stylesheet" href="http://lendmycard.com/CS691/css/2-col-portfolio.css">
<link href="http://lendmycard.com/CS691/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<%@ include file ="header.jsp" %>
</head>

<style>

</style>
<body>
<div id = "location"></div>
<span id="status"></span>
<span id=list></span>
</body>
<spring:url value="/resources/get_restaurant.js" var="get_restaurant" />
<script src="${get_restaurant}"></script>
<script>window.onload = getGeolocation()</script>
</html>