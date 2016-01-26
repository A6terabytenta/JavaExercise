<%@page import="model.StudentDao"%>
<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String className = (String) request.getAttribute("className");
		String status = (String) request.getAttribute("status");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h3>Edit Student</h3>
				<form action="UpdateStudent?id=<%=id%>" method="post">
					<table class="table">
						<tr>
							<td class="tittle">Name:</td>
							<td><input type="text" class="form-control" id="name" required maxlength="100"
								name="name" value="<%=name%>" /></td>
						</tr>
						<tr>
							<td>Class Name:</td>
							<td><input type="text" class="form-control" id="className" required maxlength="100"
								name="className" value="<%=className%>" /></td>
						</tr>
						<tr>
							<td>Status:</td>
							<td><input type="text" class="form-control" id="status" required maxlength="100"
								name="status" value="<%=status%>" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="btn btn-default"
								value="Submit"> <input type="reset"
								class="btn btn-default" value="Reset"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>