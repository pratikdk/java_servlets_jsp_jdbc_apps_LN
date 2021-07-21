<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="app.CPA.frontend.model.ProductTypes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css_global/main.css">
<title>Create Product</title>
</head>
<body>
	<%
	RequestDispatcher rd = request.getRequestDispatcher("/fetchProductTypes");
	try {
		rd.include(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	List<ProductTypes> fetchedProductTypes = (ArrayList<ProductTypes>) request.getAttribute("fetchedProductTypes");
	 %>
	<div class="forms-container">
		<form method="post" action="${pageContext.request.contextPath}/createProduct">
			<div class="form-box">
				<div class="form-title">Create Product</div>
				<div class="form-fields-box">
					<div class="form-row">
						<span class="label-container">Product Type</span>
						<span class="input-container">
							<select name="productType">
							<%
							for (ProductTypes productType: fetchedProductTypes) {
							%>
								<option value="<%= productType.getProductTypeId() %>"><%= productType.getProductType() %></option>
							<%
							}
							%>
							</select>
						</span>
					</div>
					
					<div class="form-row">
						<span class="label-container">Supplier Id</span>
						<span class="input-container">
							<input type="text" name="supplierId" value="<%= session.getAttribute("supplierId") %>" readonly>
						</span>
					</div>
					
					<div class="form-row">
						<span class="label-container">Product Name</span>
						<span class="input-container">
							<input type="text" name="productName" required />
						</span>
					</div>
					
					<div class="form-row">
						<span class="label-container">Product Price</span>
						<span class="input-container">
							<input type="text" name="productPrice" required />
						</span>
					</div>
					
				</div>
				<div class="actions">
					<div class="action-box">
						<span class="action-container">
							<input type="submit" value="Create" required />
						</span>
					</div>
				</div>
			</div>
		</form>
		<% 
		String statusString = (String) request.getAttribute("status");
		if (statusString != null) { 
		%>
			<div class="form-status"><%= statusString %></div>
		<% 
		}
		%>
	</div>
</body>
</html>