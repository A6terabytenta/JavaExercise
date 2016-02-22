<%@page import="org.dom4j.xpath.GetPathTest"%>
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
		int currentPage = 1;
			int numberItem = 3;
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int firstPosition = (currentPage * numberItem) - numberItem;
			StudentDao studentDao = new StudentDao();
			int length = 0;
			List<Student> list = null;
			if(request.getAttribute("listStudent") == null){
				list = studentDao.getListStudent(firstPosition, numberItem);
				length = studentDao.getListStudent().size();
			} else {
				list = (List<Student>)request.getAttribute("listStudent");
				length = list.size();
			}
			int count = firstPosition;
			int numberPage = 1;
			if (length % numberItem == 0) {
				numberPage = length / numberItem;
			} else {
				numberPage = (length / numberItem) + 1;
			}
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Search Student</h2>
				<form action="Search" method="post" class="form-inline">
					<input type="text" class="form-control" name="search" id="search"
						placeholder="Search by name" /> <input type="submit" id="submit"
						class="btn btn-default" value="Search" />
				</form>
				<h2>List Student</h2>
				<table class="table table-reponsive table-hover">
					<thead>
						<th>Id</th>
						<th>Name</th>
						<th>Class Name</th>
						<th>Status</th>
						<th>Action</th>
					</thead>
					<tbody>
						<%
							for (Student student : list) {
							count++;
						%>
						<tr>
							<td><%=count%></td>
							<td><%=student.getName()%></td>
							<td><%=student.getClassName()%></td>
							<td><%=student.getStatus()%></td>
							<td><a href="DeleteStudent?id=<%=student.getId()%>"><button
										type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button></a> <a href="UpdateStudent?id=<%=student.getId()%>"><button
										type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</button></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
					<tfoot>
						<th>Id</th>
						<th>Name</th>
						<th>Class Name</th>
						<th>Status</th>
						<th>Action</th>
					</tfoot>
				</table>
				<div class="col-md-12">
					<a href="index.jsp?currentPage=<%=1%>"><div>
							<span class="glyphicon glyphicon-step-backward item"></span>
						</div></a>
					<%
						if (currentPage == 1) {
					%>
					<div>
						<span class="glyphicon glyphicon-chevron-left item"></span>
					</div>
					<%
						} else {
					%>
					<a href="index.jsp?currentPage=<%=(currentPage - 1)%>"><div>
							<span class="glyphicon glyphicon-chevron-left item"></span>
						</div></a>
					<%
						}
					%>
					<%
						for (int i = 1; i <= numberPage; i++) {
						if (i == currentPage) {
					%>
					<a href="index.jsp?currentPage=<%=i%>"><div
							class="item itemActive"><%=i%></div></a>
					<%
						} else {
					%>
					<a href="index.jsp?currentPage=<%=i%>"><div class="item"><%=i%></div></a>
					<%
						}

						}

						if (currentPage == numberPage) {
					%>
					<div>
						<span class="glyphicon glyphicon-chevron-right item"></span>
					</div>
					<%
						} else {
					%>
					<a href="index.jsp?currentPage=<%=currentPage + 1%>"><div>
							<span class="glyphicon glyphicon-chevron-right item"></span>
						</div></a>
					<%
						}
					%>


					<a href="index.jsp?currentPage=<%=numberPage%>"><div>
							<span class="glyphicon glyphicon-step-forward item"></span>
						</div></a>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="col-md-6">
					<h3>Add Student</h3>
				<form action="AddStudent" method="post">
					<table class="table">
						<tr>
							<td class="tittle">Name:</td>
							<td><input type="text" class="form-control" id="name"
								name="name" value="" required maxlength="100" /></td>
						</tr>
						<tr>
							<td>Class Name:</td>
							<td><input type="text" class="form-control" id="className"
								name="className" value="" required maxlength="100" /></td>
						</tr>
						<tr>
							<td>Status:</td>
							<td><input type="text" class="form-control" id="status"
								name="status" value="" required maxlength="100" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="btn btn-default"
								value="Submit" id="btnSubmit"> <input type="reset"
								class="btn btn-default" value="Reset"></td>
						</tr>
					</table>
				</form>
				</div>
			</div>
	</div>
	<script type="text/javascript">
		document.getElementById("btnSubmit").on('submit', function() {
			return false;
		});
	</script>
</body>
</html>