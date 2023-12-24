<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Details</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />

<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>


</head>
<body>

	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include><br>

	<div class="container">
		<div class="row">
			<table id="usersTable" class="table " style="width:100%">
				<thead>
					<tr>
						<th scope="col">Administrator</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Phone</th>
						<th scope="col">Gender</th>
						<%
 							if (session.getAttribute("userrole").equals("Admin")) { 
						%>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					<% 
  							} 
					%> 
					</tr>
				</thead>
			</table>
		</div>

		<!-- The Modal -->
		<div class="modal fade" id="userEdit">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title ">User Edit</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form id="myForm" style="max-width: 500px; margin: auto">


							<input type="hidden" id="srno"> <label
								for="administrator">Select Administrator</label><br> <select
								name="administrator" id="administrator">
								<option value="Admin">Admin</option>
								<option value="User">User</option>
							</select><br> <label for="username">Enter Your Name</label><br>
							<input type="text" id="username" name="username"
								placeholder="username"><br> <label for="email">Enter
								Your ID</label><br> <input type="email" id="email" name="email"
								placeholder="email id"><br> <label for="contact">Mobile
								No.</label><br> <input type="tel" id="contact" name="contact"
								placeholder="123-45-678"><br> <label for="gender">Select
								Gender</label><br> <select name="gender" id="gender">
								<option value="Female">Female</option>
								<option value="Male">Male</option>
								<option value="Other">Other</option>
							</select><br> <label for="password">Enter Your Password</label><br>
							<input type="password" id="password" name="password"
								placeholder="password"><br>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="updateStudent();">Save changes</button>
					</div>

				</div>
				</form>
			</div>

		</div>
	</div>
	</div>



	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/getdetails.js"></script>
</body>
</html>