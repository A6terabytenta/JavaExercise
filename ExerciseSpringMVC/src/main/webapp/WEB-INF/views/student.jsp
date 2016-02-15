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
	<div id="container" ng-app="myApp" ng-controller="studentController">
		<div class="col-lg-12">
			<h1>Student Management System Homepage</h1>
			<div id="content">
				<h2>Student Table</h2>
				<form>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-search"></i>
							</div>
							<input type="text" class="form-control"
								placeholder="Search by Name" ng-model="searchEmail">
						</div>
					</div>
				</form>
				<div class="table-responsive" id="tb">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Core</th>
								<th>Address</th>
								<th>Average Score</th>
								<th>Birth Day</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>#</td>
								<td><input type="text" class="form-control"
									id="studentName" value="{{st.studentName}}" /></td>
								<td><input type="text" class="form-control"
									id="studentCore" value="{{st.studentCore}}" /></td>
								<td><input type="text" class="form-control" id="address"
									value="{{st.studentInfo.address}}" /></td>
								<td><input type="text" class="form-control"
									id="averageScore" value="{{st.studentInfo.averageScore}}" /></td>
								<td><input type="text" class="form-control" id="dateOfBirth"
									value="{{st.studentInfo.dateOfBirth}}" /></td>
								<td><a class="event fa fa-save" ng-click="insert()"
									title="insert" type="submit"></a> <a
									class="event fa fa-refresh" ng-click="update(st.studentId, st.studentInfo.infoId)"
									title="update"></a></td>
							</tr>
							<tr ng-repeat="student in filteredListStudent">
								<td>{{student.studentId}}</td>
								<td>{{student.studentName}}</td>
								<td>{{student.studentCore}}</td>
								<td>{{student.studentInfo.address}}</td>
								<td>{{student.studentInfo.averageScore}}</td>
								<td>{{student.studentInfo.dateOfBirth}}</td>
								<td><a class="event fa fa-remove"
									ng-click="remove(student.studentId)" title="remove"></a> <a
									class="event fa fa-edit" ng-click="edit(student.studentId)"
									title="edit"></a></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Core</th>
								<th>Address</th>
								<th>Average Score</th>
								<th>Birth Day</th>
								<th>Action</th>
							</tr>
						</tfoot>
					</table>
					<pagination total-items="totalItems" ng-model="currentPage"
						items-per-page="itemsPerPage" max-size="maxSize"
						class="pagination" boundary-links="true" rotate="true"
						num-pages="numPages"> </pagination>
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
	<script src="resources/js/my-angular.js"></script>
	<script src="resources/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#dateOfBirth').datepicker({
				format: "yyyy-mm-dd",
			}).val()
		});
	</script>
</body>
</html>