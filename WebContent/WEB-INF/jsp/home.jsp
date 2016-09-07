<%@page import="com.models.ProjectOwner"%>
<%@page import="com.services.UserServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<style>
body {
    background-color: lightblue;
	font-family: "Lato", sans-serif;
}
</style>

<body>

	<br><br>

	<div>
		<form action="AllTransactions" method="get">
			<input type="submit" value="Get All Transactions">
		</form>
	</div>

	<br><br>

	<div>
		<form action="FilterTransactions" method="post">
			<select>
				<option selected value="SELECT">SELECT</option>
				<%
					for (ProjectOwner po : new UserServices().getProjectOwners()) {
				%>
				<option value="<%=po.getProjectOwnerID()%>">
					<%=po.getName()%>
				</option>
				<%
					}
				%>
			</select> <input type="submit" value="Filter Transactions">
		</form>
	</div>

	<br><br>

	<div>
		<button onclick="">Add Transaction</button>
	</div>

	<br><br>

	<div>
		<button onclick="">Get All Project Owners</button>
	</div>

	<br><br>

	<div>
		<button onclick="">Add Project Owner</button>
	</div>

</body>
</html>