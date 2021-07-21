<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!Connection conn;
	PreparedStatement stmt;

	public void jspInit() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/web_test_db", "root", "1234");
			stmt = conn.prepareStatement("insert into account values(?, ?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void jspDestory() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	%>

	<%
 	int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
 	String firstName = request.getParameter("firstName");
 	String lastName = request.getParameter("lastName");
 	int balance = Integer.parseInt(request.getParameter("balance"));
 	
 	stmt.setInt(1, accountNumber);
 	stmt.setString(2, lastName);
 	stmt.setString(3, firstName);
 	stmt.setInt(4, balance);
 	
 	stmt.executeUpdate();
 	 %>

	<%@ include file="openAccount.html" %>

</body>
</html>