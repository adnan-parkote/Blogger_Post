<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Posts</title>


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

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<style type="text/css">
.container {
	margin-right: auto;
	margin-left: auto;
	padding-left: 15px;
	padding-right: 15px;
}

.image-block {
	margin-top: 24px;
	display: flex;
	flex-wrap: wrap;
}

.image-block-inner {
	-webkit-box-shadow: 0px 3px 10px 1px rgba(204, 204, 204 0, 1);
	-moz-box-shadow: 0px 3px 10px 1px rgba(204, 204, 204 0, 1);
	box-shadow: 0px 3px 10px 1px rgba(204, 204, 204, 1);
}

.image-block li>.image-block-inner {
	padding-bottom: 30px;
	background-color: #fff;
	height: 100%;
}

a {
	color: #111;
	text-decoration: none;
}

h2, h4 a {
	text-transform: uppercase;
}

a:hover {
	text-decoration: none;
}

.image-block li>.image-block-inner>a {
	display: block;
	overflow: hidden;
}

.image-block li>.image-block-inner>a img {
	border: 1px solid #e1e1df;
}

.image-block li>.image-block-inner:hover {
	background-color: #eee;
}

.hp-posts-cat {
	margin-bottom: 13px;
	margin-top: 35px;
	text-transform: uppercase;
	font-weight: 600;
	font-size: 1rem;
	letter-spacing: 0.1rem;
	display: inline-block;
}

.news {
	font-family: 'Oswald', sans-serif;
}

.news .image-block li>.image-block-inner h4, .hp-posts-cat, .news .image-block li>.image-block-inner p,
	.read-more {
	padding: 0 28px;
}

.read-more {
	display: block;
	text-decoration: underline;
	margin-top: 30px;
	font-weight: 600;
}

/* Media Queries */
@media ( min-width : 992px) {
	.col-md-5 {
		width: 41.66667%;
	}
}

@media ( min-width : 768px) {
	.image-block li.image-block1 {
		padding-left: 26px;
		padding-right: 14.5px;
	}
}

@media ( min-width : 1200px) {
	.image-block li>.image-block-inner>a {
		max-height: 245px;
	}
}

@media ( min-width : 992px) {
	.pl-lg-0, .px-lg-0 {
		padding-left: 0;
		padding-right: 0;
	}
	.ml-lg-0, .mx-lg-0 {
		margin-left: 0;
		margin-right: 0;
	}
}
</style>

</head>
<body>

	<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include><br>

	<button type="button" class="btn btn-secondary" data-toggle='modal'
		data-target='#newPost'>+ Add New Post</button>

	<div class="container">
		<div class="row">
			<table id="postsTable" class="table ">
				<thead>
					<tr>
						<th scope="col">Post Title</th>
						<th scope="col">Post Description</th>
						<th scope="col">Posted By</th>
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
		<div class="modal fade" id="newPost">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title ">New Post</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form id="myForm" style="max-width: 500px; margin: auto">


							<label for="title">Title:</label><br> <input type="text"
								id="title" name="title" placeholder="title"><br> <label
								for="description">Description:</label>
							<textarea rows="5" class="form-control" name="description"
								id="description"></textarea>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="newPostCreate();">Save changes</button>
					</div>

				</div>
				</form>
			</div>

		</div>
	</div>
	</div>


	<!-- The Modal -->
	<div class="modal fade" id="postEdit">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title ">Post Edit</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="myForm" style="max-width: 500px; margin: auto">


						<input type="hidden" id="srno"> <label for="titleedit">Your
							Title:</label><br> <input type="text" name="titleedit"
							id="titleedit" placeholder="title"><br> <label
							for="descriptionedit">Write Your Description:</label>
						<textarea rows="5" class="form-control" name="descriptionedit"
							id="descriptionedit"></textarea>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="updatePost();">Save changes</button>
				</div>

			</div>
			</form>
		</div>

	</div>
	</div>
	</div>


	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/js/posts.js"></script>
</body>
</html>