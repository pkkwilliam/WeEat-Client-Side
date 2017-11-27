<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>WeEat Login</title>
   </head>
   
   <body>

		
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body{
  background: #00589F;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00589F', endColorstr='#0073CF', GradientType=0);
  background: -webkit-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
  background: -moz-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
  background: -ms-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
  background: -o-linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
  background: linear-gradient(to bottom, #00589F 50%, #0073CF) !important;
  color: white;
}

div.well{
  height: 250px;
} 

.Absolute-Center {
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
}

.Absolute-Center.is-Responsive {
  width: 50%; 
  height: 75%;
  min-width: 200px;
  max-width: 400px;
  padding: 40px;
}

#logo-container{
  margin: auto;
  margin-bottom: 10px;
  width:200px;
  height:200px;
  
}</style>
 <div class="container">
  <div class="row">
    <div class="Absolute-Center is-Responsive">
     <div id="logo-container"><img style="width: 200px; height: 200px;" src="http://lendmycard.com/CS691/image/wheat.png"></div>
      <div class="col-sm-12 col-md-10 col-md-offset-1">
        <form action = "/Project2/registerHandler" method="POST">
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input class="form-control" type="text" name="username" placeholder="username"/>          
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input class="form-control" type="text" name="password" placeholder="password"/>     
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
            <input class="form-control" type="text" name="firstname" placeholder="First Name"/>     
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
            <input class="form-control" type="text" name="lastname" placeholder="Last Name"/>     
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input class="form-control" type="text" name="email1" placeholder="Email"/>     
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <input class="form-control" type="text" name="email2" placeholder="Email Confrim"/>     
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
            <input class="form-control" type="text" name="tel" placeholder="Phone Number"/>     
          </div>
           <center>
            <p>By clicking Login you are agreeing this is <span style="font-weight: 900">ONLY</span> for testing purposes</p>
           </center>
          <div class="form-group">
           <input type="submit" value="Register" class="btn btn-def btn-block"/>
	       <button formaction="/Project2/login" class="btn btn-def btn-block">Already has an account</button>
          </div>
        </form>        
      </div>  
    </div>    
  </div>
</div>
	
	<h1>${result}</h1>

   </body>
</html>