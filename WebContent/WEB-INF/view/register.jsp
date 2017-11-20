<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>WeEat Login</title>
   </head>
   
   <body>

		
	<form action = "/Project2/registerHandler" method="POST">
	Username: <input type = "text" name="username"/><br>
	Password: <input type = "password" name="password"/><br>
	First Name: <input type = "text" name="firstname"/><br>
	Last Name: <input type = "text" name="lastname"/><br>
	E-mail: <input type = "text" name="email1"/><br>
	E-mail Confirm: <input type = "text" name="email2"/><br>
	Phone: <input type = "text" name="tel"/><br>
	<input type="submit" value="Register"/>
	<button formaction="/Project2/login">Login</button>
	
	<h1>${result}</h1>
	</form>
   </body>
</html>