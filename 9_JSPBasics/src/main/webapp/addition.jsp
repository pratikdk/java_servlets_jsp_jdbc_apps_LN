<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of two numbers</title>
</head>
<body>
<%
int number1 = Integer.parseInt(request.getParameter("number1"));
int number2 = Integer.parseInt(request.getParameter("number2"));
 %>
Sum of <%= number1 %> and <%= number2 %> is <%= number1+number2 %>
</body>
</html>