<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Student Page</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div class="col-lg-12">
			<h1>Student Management System Homepage</h1>
			<div id="content">
				<h2>Student Table</h2>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-search"></i>
						</div>
						<input type="text" id="searchByValue" class="form-control"
							placeholder="Search by Name, Core, Address - example Name:Tuan or Core:12130155" />
					</div>
				</div>
				<div class="table-responsive" id="tb">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="sort" onclick="sort('id')">Id</th>
								<th class="sort" onclick="sort('name')">Name</th>
								<th class="sort" onclick="sort('core')">Core</th>
								<th class="sort" onclick="sort('address')">Address</th>
								<th class="sort" onclick="sort('score')">Average Score</th>
								<th class="sort" onclick="sort('birthday')">Birth Day</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody id="tbody">
						</tbody>
					</table>
					<div id="paging"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/ui-bootstrap-tpls.js"></script>
	<script src="resources/js/my-jquery.js"></script>
	<script src="resources/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#dateOfBirth').datepicker({
				format : "yyyy-mm-dd",
			}).val()
		});
	</script>
</body>
</html>