<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

</style>
<body>
<div id = "status"></div>
<span id = "list"></span>
</body>
<spring:url value="/resources/get_item.js" var="get_item" />
<script src="${get_item}"></script>
<script>window.onload = getItem()</script>
<%@ include file ="footer.jsp" %>
</html>