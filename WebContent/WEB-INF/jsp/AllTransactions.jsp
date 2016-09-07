<%@page import="com.models.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.services.UserServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserServices userServices = new UserServices();
		ArrayList<Transaction> transactions = userServices.getTransactions();
	%>

	<table>
		<tr>
			<th>Package</th>
			<th>Action</th>
			<th>Start Date</th>
		</tr>
		<%
			for (Transaction transaction : transactions) {
		%>
		<tr>
			<td><%=transaction.getPackageName()%></td>
			<td><%=transaction.getAction()%></td>
			<td><%=transaction.getStartDate()%></td>
		</tr>

		<%
			}
		%>

	</table>

</body>
</html>