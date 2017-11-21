<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<h1> Your Order Status</h1>
<h3 id="orderNumber"></h3>
<div id = progressBar></div>
<br/>

</body>
<spring:url value="/resources/success.js" var="successJS" />
<script src="${successJS}"></script>
<script>window.onload = getStatusUpdate();</script>

</html>