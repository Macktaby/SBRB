<%@ page import="com.models.ProjectOwner"%>
<%@ page import="com.services.UserServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home</title>

<link href="/Macktaby/css/style.css" rel="stylesheet" type="text/css" />
<link href="/Macktaby/css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script type="text/javascript">
function check() {
	var element = document.getElementById('datetimepicker').value;
	alert(element);
}

	function checkSelect(selectID, formID, action) {
		var element = document.getElementById(selectID);
		var selectedValue = element.options[element.selectedIndex].value;

		if (selectedValue == 0)
			alert("Please select a Project Owner !!!");
		else {
			var form = document.getElementById(formID).action = action;
			form.submit;
		}
	}
</script>
</head>

<body>

	<br>

	<div class="table">

		<div>
			<div>
				<h2>Label</h2>
			</div>
			<div>
				<h2>Input</h2>
			</div>
			<div>
				<h2>Action</h2>
			</div>
		</div>

		<div>
			<div>
				<b>See all Transactions</b>
			</div>
			<div>-</div>
			<div>
				<form action="AllTransactions" method="get">
					<input type="submit" value="Get All Transactions">
				</form>
			</div>
		</div>

		<form id="filterTransactions" method="post"
			action="javascript:checkSelect('filterSelect','filterTransactions','FilterTransactions')">
			<div>
				<b>Filter Transactions by PO</b>
			</div>
			<div>
				<label>Select Project Owner</label> <br> <select
					name="filterSelect" id="filterSelect">
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
			</div>
			<div>
				<input type="submit" value="Filter Transactions">
			</div>
		</form>


		<form id="addTransaction" method="post"
			action="javascript:checkSelect('addTransSelect','addTransaction','AddTransaction')">
			<div>
				<b>Add Transaction</b>
			</div>
			<div>
				<div>
					<label>Select Project Owner</label> <br>
				</div>
				<div>
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
				</div>
				<div>
					<label>Package: </label> <br> <input name="package"
						type="text"> <br>
				</div>
				<div>
					<label>Action: </label> <br> <input name="action" type="text">
					<br>
				</div>
				<div>
					<label>Date: </label> <br> <input name="time" id="datetimepicker"
						type="text"> <br>
				</div>

			</div>
			<div>
				<input type="submit" value="Add Transaction">
			</div>
		</form>

		<div>
			<div>
				<b>See all Project Owners</b>
			</div>
			<div>-</div>
			<div>
				<form action="AllProjectOwners" method="get">
					<input type="submit" value="Get All Project Owners">
				</form>
			</div>
		</div>

		<form action="AddProjectOwner" method="POST">
			<div>
				<b>Add Project Owner</b>
			</div>
			<div>
				<label>Project Owner Name: </label> <br> <input type="text"
					name="poName"> <br>
			</div>
			<div>
				<input type="submit" value="Add Project Owner">
			</div>
		</form>

	</div>

</body>

<script src="/Macktaby/js/jquery.js"></script>
<script src="/Macktaby/js/jquery.datetimepicker.full.min.js"></script>

<script>
	jQuery('#datetimepicker').datetimepicker();
</script>

</html>