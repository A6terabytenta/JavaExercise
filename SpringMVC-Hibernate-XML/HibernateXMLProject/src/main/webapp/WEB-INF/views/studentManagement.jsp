<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
	function notification(type, title, content) {
		$("#notification").html("");
		switch (type) {
		case "error":
			$("#notification").append(
					"<p><span>Error: " + title + " - </span>" + content
							+ "</p>");
			$("#notification").css("background", "rgba(242,178,175, 0.4)");
			$("#notification>p>span").css("color", "#f49f9a");
			$("#notification>p").css("color", "#f2ada9");
			break;
		case "info":
			$("#notification")
					.append(
							"<p><span>Info: " + title + " - </span>" + content
									+ "</p>");
			$("#notification").css("background", "rgba(103,171,73, 0.4)");
			$("#notification>p>span").css("color", "#55893e");
			$("#notification>p").css("color", "#7cba61");
			break;
		}
		$("#notification").show("slice");
		setTimeout(function() {
			$("#notification").hide("slice");
		}, 5000);
	}
</script>

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
							placeholder="Search by Name, Core, Address - Example Name:Tuan or Core:12130155 - Press enter to search" />
					</div>
				</div>
				<div class="table-responsive" id="tb">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="sort">Id</th>
								<th class="sort">Name</th>
								<th class="sort">Core</th>
								<th class="sort">Address</th>
								<th class="sort">Average Score</th>
								<th class="sort">Birth Day</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<form:form action="" method="POST">
							</form:form>
							<c:if test="${not empty studentList}">
								<c:forEach var="student" items="${studentList}" begin="${begin}"
									end="${end}">
									<tr>
										<td>${student.studentId}</td>
										<td>${student.studentName}</td>
										<td>${student.studentCore}</td>
										<td>${student.studentInfo.address}</td>
										<td>${student.studentInfo.averageScore}</td>
										<td><fmt:formatDate
												value="${student.studentInfo.dateOfBirth}"
												pattern="yyyy-MM-dd" /></td>
										<td><a
											href="<c:url value="deleteStudent?studentId=${student.studentId}"/>"
											class="event fa fa-remove" title="remove"></a> <a
											href="<c:url value="update?studentId=${student.studentId}"/>"
											class="event fa fa-edit" title="edit"></a>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<div class="paging" id="paging">
						<c:choose>
							<c:when test="${ currentPage == 1 }">
								<a id="first"
									class="disabled-btn btn-paging btn btn-default btn-paging-first">first</a>
								<a id="previous"
									class="disabled-btn btn-paging btn btn-default btn-paging-content">previous</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value="paging?page=${1}"/>" id="first"
									class="btn-paging btn btn-default btn-paging-first">first</a>
								<a href="<c:url value="paging?page=${currentPage - 1}"/>"
									id="previous"
									class="btn-paging btn btn-default btn-paging-content">previous</a>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="1" end="${length}">
							<c:choose>
								<c:when test="${ i == currentPage }">
									<a href="<c:url value="paging?page=${i}"/>"
										class="current btn-paging btn btn-default btn-paging-content">${i}</a>
								</c:when>
								<c:otherwise>
									<a href="<c:url value="paging?page=${i}"/>"
										class="btn-paging btn btn-default btn-paging-content">${i}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${ currentPage == length }">
								<a id="next"
									class="disabled-btn btn-paging btn btn-default btn-paging-content">next</a>
								<a id="last"
									class="disabled-btn btn-paging btn btn-default btn-paging-last">last</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value="paging?page=${currentPage + 1}"/>"
									id="next" class="btn-paging btn btn-default btn-paging-content">next</a>
								<a href="<c:url value="paging?page=${length}"/>" id="last"
									class="btn-paging btn btn-default btn-paging-last">last</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<script src="resources/js/my-jquery.js"></script>
		<div id="notification"></div>
		<script type="text/javascript">
			notification("${type}", "${title}", "${content}");
		</script>
	</div>
</body>
</html>