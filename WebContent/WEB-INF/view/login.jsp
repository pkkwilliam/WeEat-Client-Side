<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>WeEat Login</title>
   </head>
   
   <body>

		
	<form action = "/Project2/loginHandler" method="POST">
	Username: <input type = "text" name="username"/><br>
	Password: <input type = "password" name="password"/><br>
	<input type="submit" value="Login"/>
	<button formaction="/Project2/registerView">Register</button>
	
	<h1>${result}</h1>
	</form>
   </body>
</html>