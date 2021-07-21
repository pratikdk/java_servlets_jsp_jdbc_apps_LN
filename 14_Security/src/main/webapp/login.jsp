<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Login form</h1>
<form action="j_security_check" method="post">
	Username: <input name="j_username"/><br/>
	Password: <input name="j_password"/><br/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>