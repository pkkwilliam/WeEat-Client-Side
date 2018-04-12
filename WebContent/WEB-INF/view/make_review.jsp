<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>WeEat.com</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<center>
	<h1>Make A Review</h1>
	<form method="POST" action="make_review">
		Rating<br/><input type="number" name="rating"/><br/><br/>
		Detail<br/><textarea rows="5" cols="50" name="detail"></textarea><br/><br/>
		<input type="submit" class="btn btn-primary">
	</form>
</center>
<br/>

</body>
<spring:url value="/resources/success.js" var="successJS" />
<script src="${successJS}"></script>
<script>window.onload = getStatusUpdate();</script>
<%@ include file ="footer.jsp" %>
</html>