<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
	<c:out value="${10+9}" />
	<br />
	<c:set var="testScore" value="80" scope="session" />
	<c:out value="${testScore}" />
	<br />
	<c:if test="${testScore >= 80 }">
		<p>Your Score is Awesome</p>
		<c:out value="${testScore}" />
	</c:if>
	<br />
	<c:choose>
		<c:when test="${testScore >= 80 }">
			A Grade
		</c:when>
		<c:when test="${testScore >= 60 && testScore < 80 }">
			B Grade
		</c:when>
		<c:otherwise>
			C Grade
		</c:otherwise>
	</c:choose>
	<br />
	<c:remove var="testScore" />
	After removal of testScore the value is: <c:out value="${testScore }"/>
	<br />
	<c:forEach var="i" begin="1" end="3">
		<c:out value="${i }" />
	</c:forEach>
	<br />
	<% 
		List<String> studentNames = new ArrayList<>();
		studentNames.add("Student A");
		studentNames.add("Student B");
		studentNames.add("Studnet C");
		request.setAttribute("studentNames", studentNames);
	%>
	<c:forEach var="studentName" items="${studentNames }">
		<c:out value="${studentName }" />
	</c:forEach>
	<br />
	
	<c:set var="accountBalance" value="123.456" />
	
	<fmt:parseNumber var="i" type="number" value="${accountBalance }" />
	<p>Amount is:<c:out value="${i }" /></p>
	
	<c:set var="accountBalance" value="7777.4567" />
	<p>Formatted Number 1: <fmt:formatNumber value="${accountBalance }" type="currency" /></p>
	<p>Formatted Number 2: <fmt:formatNumber value="${accountBalance }" type="number" maxFractionDigits="2"/></p>
	<p>Formatted Number 3: <fmt:formatNumber value="${accountBalance }" type="number" maxIntegerDigits="3"/></p>
	<p>Formatted Number 4: <fmt:formatNumber value="${accountBalance }" type="percent"/></p>
	<p>Formatted Number 5: <fmt:formatNumber value="${accountBalance }" type="number" pattern="####.##$"/></p>
	<br />
	
	<c:set var="myDateString" value="12-07-2019" />
	<fmt:parseDate var="parsedDate" value="${myDateString }" pattern="dd-MM-yyyy"/>
	<p>Parsed Date: <c:out value="${parsedDate }" /></p>
</body>
</html>