<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css_global/main.css">
<title>Supplier Portal</title>
</head>
<body>
<body>
	<% 
	if (session.getAttribute("supplierUsername") != null) {
		// redirect to some supplier page using sendRedirect
		response.sendRedirect("supplierHome.jsp");
	}
	%>
	<h1>Supplier Sign-In/Sign-Up</h1>
	<div class="forms-container">
		<form method="post" action="${pageContext.request.contextPath}/supplierSignIn">
			<div class="form-box">
				<div class="form-title">Sign-In</div>
				<div class="form-fields-box">
					<div class="form-row">
						<span class="label-container">Username</span>
						<span class="input-container">
							<input type="text" name="username" required />
						</span>
					</div>
					<div class="form-row">
						<span class="label-container">Password</span>
						<span class="input-container">
							<input type="password" name="password" required />
						</span>
					</div>
					
				</div>
				<div class="actions">
					<div class="action-box">
						<span class="action-container">
							<input type="submit" value="Sign-In" required />
						</span>
					</div>
				</div>
			</div>
		</form>
		
		<form method="post" action="${pageContext.request.contextPath}/supplierSignUp">
			<div class="form-box">
				<div class="form-title">Sign-Up</div>
				<div class="form-fields-box">
					<div class="form-row">
						<span class="label-container">Username</span>
						<span class="input-container">
							<input type="text" name="username" required />
						</span>
					</div>
					<div class="form-row">
						<span class="label-container">Password</span>
						<span class="input-container">
							<input type="password" name="password" required />
						</span>
					</div>
					<div class="form-row">
						<span class="label-container">Re-Enter Password</span>
						<span class="input-container">
							<input type="password" name="password_repeat" required />
						</span>
					</div>
					
				</div>
				<div class="actions">
					<div class="action-box">
						<span class="action-container">
							<input type="submit" value="Sign-Up" required />
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

	<a href="javascript:history.back()">Go Back</a>

</body>
</html>