<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html style="margin-top:80px">
<head>
  <title>WeEat.com </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
      <a class="navbar-brand" href="welcome">
    	    <img src="http://lendmycard.com/CS691/image/small_logo.png" alt="logo" style="width:30px;">
  	  </a>
        <a class="navbar-brand" href="welcome">WeEat</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="welcome">Restaurant
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="success">Order Status</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="go_shopping_cart">Cart</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="clearSession">Logout</a>
            </li>
            <li class="nav-item"><span class="nav-link">${username}</span></li>
          </ul>
        </div>
      </div>
    </nav>



<form id="checkLogin" method ="GET" action="checkLogin">
    
</form>
    
</body>
<spring:url value="/resources/header.js" var="headerJS" />

<script src="${headerJS}"></script>
</html>