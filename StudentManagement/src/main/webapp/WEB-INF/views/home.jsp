<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

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





<style type="text/css">
.require {
	color: #666;
}

label small {
	color: #999;
	font-weight: normal;
}
</style>
</head>
<body>


	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<br>

	<div class="container">
		<div class="row">

			<div class="col-md-8 col-md-offset-2">

				<h1>Create post</h1>

				<form action="" method="POST">

					<!--     		    <div class="form-group has-error"> -->
					<!--     		        <label for="slug">Posted By<span class="require">*</span>  -->
					<!--     		        <small>(This field use in url path.)</small></label> -->
					<!--     		        <input type="text" class="form-control" name="postedby" id="postedby" /> -->
					<!--     		        <span class="help-block">Field not entered!</span> -->
					<!--     		    </div> -->

					<div class="form-group">
						<label for="title">Title <span class="require">*</span></label> <input
							type="text" class="form-control" name="title" id="title" />
					</div>

					<div class="form-group">
						<label for="description">Description <span
							class="require">*</span></label>
						<textarea rows="5" class="form-control" name="description"
							id="description"></textarea>
					</div>

					<div class="form-group">
						<p>
							<span class="require">*</span> - required fields
						</p>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary" onclick="home()">
							Create</button>
						<button class="btn btn-default" type="reset">Cancel</button>
					</div>

				</form>
			</div>
		</div>

	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/home.js"></script>
</body>
</html>