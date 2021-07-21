<%@page import="app.CPA.frontend.model.AccountHolder"%>
<%@page import="app.CPA.frontend.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Marketplace</h1>
<div class="user-account-container">
	<%
	String username = (String) session.getAttribute("userUsername");
	if (username == null) { %>
	<button><a href="frontend_views/user/userAccess.jsp">User Portal</a></button>
	<button><a href="frontend_views/supplier/supplierAccess.jsp">Supplier Portal</a></button>
	<button><a href="frontend_views/user/employeeAccess.jsp">Employee Portal</a></button>
	<%} else { %>
	<a href="somerandomPage"><%= username %></a>
	<button><a href="logOut">Log-out</a></button>
	<button><a href="frontend_views/supplier/supplierAccess.jsp">Supplier Portal</a></button>
	<button><a href="frontend_views/user/employeeAccess.jsp">Employee Portal</a></button>
	<%} %>
</div>
</body>
</html>