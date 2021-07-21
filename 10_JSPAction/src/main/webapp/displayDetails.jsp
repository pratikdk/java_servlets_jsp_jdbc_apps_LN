<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<!-- Create a product instance from the request and set instance properties, associate instance with the id -->
	<jsp:useBean id="product" class="com.udemy.course.JSPActions.Product">
		<jsp:setProperty name="product" property="name" />
		<jsp:setProperty name="product" property="price" />
	</jsp:useBean>
	<h1>Product Details</h1>
	Product Name: <jsp:getProperty property="name" name="product"/><br/>
	Product Price: <jsp:getProperty property="price" name="product"/><br/>
</body>
</html>