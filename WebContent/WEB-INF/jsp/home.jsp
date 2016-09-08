<%@ page import="com.models.ProjectOwner"%>
<%@ page import="com.services.UserServices"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />

<style>
body {
	background-color: lightblue;
	font-family: "Lato", sans-serif;
}
</style>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<script type="text/javascript">
	function checkSelect(selectID, formID, action) {
		var element = document.getElementById(selectID);
		var selectedValue = element.options[element.selectedIndex].value;

		if (selectedValue == 0)
			alert("Please select a Project Owner !!!");
		else {
			var form = document.getElementById(formID).action = action;
			form.submit();
		}
	}
</script>
</head>

<body>

	<br>
	<br>

	<div>
		<form action="AllTransactions" method="get">
			<input type="submit" value="Get All Transactions">
		</form>
	</div>

	<br>
________________________________________________________________________________
	<br><br>

	<div>
		<form id="filterTransactions" method="post"
			action="javascript:checkSelect('filterSelect','filterTransactions','FilterTransactions')">
			<label>Select Project Owner</label> <br>
			<select name="filterSelect" id="filterSelect">
				<option selected value="0">SELECT</option>
				<%
					for (ProjectOwner po : new UserServices().getProjectOwners()) {
				%>
				<option value="<%=po.getProjectOwnerID()%>">
					<%=po.getName()%>
				</option>
				<%
					}
				%>
			</select> <br>
			 <input type="submit" value="Filter Transactions">
		</form>
	</div>

	<br>
________________________________________________________________________________
	<br><br>

	<div>
		<form id="addTransaction" method="post"
			action="javascript:checkSelect('addTransSelect','addTransaction','AddTransaction')">
			<label>Select Project Owner</label> <br>
			<select name="addTransSelect" id="addTransSelect">
				<option selected value="0">SELECT</option>
				<%
					for (ProjectOwner po : new UserServices().getProjectOwners()) {
				%>
				<option value="<%=po.getProjectOwnerID()%>">
					<%=po.getName()%>
				</option>
				<%
					}
				%>
			</select><br> 
			<label>Package: </label> <br> <input name="package" type="text"> <br> 
			<label>Action: </label> <br> <input name="action" type="text"> <br> 
			<label>Date: </label> <br> <input name="date" type="text" id="datepicker"> <br> 
			<input type="submit" value="Add Transaction">
		</form>
	</div>

	<br>
________________________________________________________________________________
	<br><br>

	<div>
		<form action="AllProjectOwners" method="get">
			<input type="submit" value="Get All Project Owners">
		</form>
	</div>

	<br>
________________________________________________________________________________
	<br><br>

	<div>
		<form action="AddProjectOwner" method="POST">
			<label>Project Owner Name: </label> <br>		
			<input type="text" name="poName"> <br>
			<input type="submit" value="Add Project Owner">
		</form>
	</div>

</body>
</html>