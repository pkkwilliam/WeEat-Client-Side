<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<h1> Your Order Status</h1>

<div id = "orders"></div>

<br/>

</body>
<spring:url value="/resources/success.js" var="successJS" />
<script src="${successJS}"></script>
<script>window.onload = getStatusUpdate();</script>
<%@ include file ="footer.jsp" %>
</html>