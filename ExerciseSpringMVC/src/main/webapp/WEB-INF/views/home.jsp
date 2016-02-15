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

<title>Home Page</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="resources/js/angular.min.js"></script>
<script src="resources/js/ui-bootstrap-tpls.js"></script>

</head>
<body>
	<div id="container">
		<div id="form_login">
			<fieldset>
				<legend> Login to student management system homepage</legend>
				<form action="" method="post">
					<table class="table" id="table">
						<tr>
							<td class="title">User Name</td>
							<td><input class="form-control" type="text" id="username"
								name="username" required /></td>
						</tr>

						<tr>
							<td class="title">Password</td>
							<td><input class="form-control" type="text" id="password"
								name="password" required /></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit" id="btn" class="btn btn-primary">Login</button>
							</td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</div>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/angular.min.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>