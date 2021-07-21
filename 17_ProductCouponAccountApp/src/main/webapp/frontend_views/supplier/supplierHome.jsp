<%@page import="app.CPA.frontend.model.Supplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String supplierUsername = (String) session.getAttribute("supplierUsername");
int supplierId = (int) session.getAttribute("supplierId");
%>
<h2>Supplier Id: <%= supplierId %>	Username: <%= supplierUsername %></h2>
<button><a href="${pageContext.request.contextPath}/logOut">Log-out</a></button>
<button><a href="${pageContext.request.contextPath}/index.jsp">Live-Marketplace</a></button>
<br/>
<br/>
<button><a href="createProduct.jsp">Create Product</a></button>
<button><a href="${pageContext.request.contextPath}/createCoupon">Create Coupon</a></button>
</body>
</html>