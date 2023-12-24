<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>SignUp</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/singup.css">
</head>
<body>
	<section class="h-100 h-custom" style="background-color: #8fc4b7;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration
								Info</h3>

							<form class="px-md-2">

								<div class="form-outline mb-4" F>
									<label class="form-label" for="administrator">Administrator</label>
									<select name="administrator" class="form-control"
										id="administrator">
										<option value="Admin">Admin</option>
										<option value="User">User</option>
									</select>
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="username">User Name</label> <input
										type="text" id="username" class="form-control" name="username"
										placeholder="Username" required="required" />
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="email">Email</label> <input
										type="email" id="email" class="form-control" name="email"
										placeholder="Email Address" />
								</div>


								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline datepicker">
											<label for="contact" class="form-label">Contact</label> <input
												type="tel" class="form-control" id="contact" name="contact"
												placeholder="123-45-678" required="required" />
										</div>

									</div>

								</div>

								<div class="mb-4">

									<select name="gender" class="select" id="gender">
										<option value="Female" selected>Female</option>
										<option value="Male">Male</option>
										<option value="Other">Other</option>
									</select>

								</div>

								<div class="row mb-4 pb-2 pb-md-0 mb-md-5">
									<div class="col-md-6">

										<div class="form-outline">
											<label class="form-label" for="password">Password</label> <input
												type="password" id="password" class="form-control"
												name="password" placeholder="Password" required="required" />

										</div>

									</div>
								</div>
								<button type="submit" class="btn btn-success btn-lg mb-1"
									onclick="signup()">Submit</button>
							</form>
							<div class="text-center">
								Already have an account? <a
									href="<%=request.getContextPath()%>/">Login here</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/signup.js"></script>
</body>
</html>