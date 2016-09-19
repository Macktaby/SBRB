<%@page import="com.models.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Owners</title>
<style>
body {
	background-color: lightblue;
	font-family: "Lato", sans-serif;
}
</style>
</head>

<body>

	<table border="1">
		<tr>
			<th>Project Owner ID</th>
			<th>Project Owner Name</th>
		</tr>
		<c:forEach items="${it}" var="iter">
			<tr>
				<td>${iter.projectOwnerID}</td>
				<td>${iter.name}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>