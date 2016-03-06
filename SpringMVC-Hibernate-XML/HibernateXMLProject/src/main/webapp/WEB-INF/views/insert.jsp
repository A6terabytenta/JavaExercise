<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insert Student</title>
<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
			<h1>Insert Student</h1>
			<div id="content">
				<form:form action="../spring/insertStudent" method="POST">
					<form:input path="studentId" id="studentId" type="hidden" />
					<form:input path="studentInfo.infoId" id="infoId" type="hidden" />
					<div class="form-group">
						<form:label path="studentName">Student Name:</form:label>
						<form:input path="studentName" id="studentName"
							cssClass="form-control"
							pattern="([^0-9`!@#$%^&*()=+|{}[\]\'\x22:;?/>.<,])+"
							placeholder="Student Name  not contain special characters"
							required="required" maxlength="100" />
					</div>
					<div class="form-group">
						<form:label path="studentCore">Student Core:</form:label>
						<form:input path="studentCore" id="studentCore"
							cssClass="form-control" placeholder="Student Core"
							pattern="^[0-9]{8}$" required="required" maxlength="50" />
					</div>
					<div class="form-group">
						<form:label path="studentInfo.averageScore">Average Score:</form:label>
						<form:input path="studentInfo.averageScore" id="averageScore"
							step="0.1" type="number" cssClass="form-control"
							placeholder="Average Score" required="required" />
					</div>
					<div class="form-group">
						<form:label path="studentInfo.dateOfBirth">Date Of Birth:</form:label>
						<form:input path="studentInfo.dateOfBirth" cssClass="form-control"
							id='dateOfBirth' placeholder="Date Of Birth" required="required" />
					</div>
					<div class="form-group">
						<form:label path="studentInfo.address">Address:</form:label>
						<form:textarea path="studentInfo.address" id="address"
							cssClass="form-control"
							pattern="([^`!@#$%^&*()=+|{}[\]\'\x22:;?/>.<,])+"
							placeholder="Address not contain special characters"
							required="required" maxlength="200" />
					</div>
					<div class="modal-footer">
						<button type="submit" required class="btn btn-default">Submit</button>
						<a href="<c:url value="studentManagement"/>"
							class="btn btn-default" data-dismiss="modal">Close</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div id="notification"></div>
	<script type="text/javascript">
		notification("${type}", "${title}", "${content}");

		$('#dateOfBirth').datepicker({})
	</script>
</body>
</html>