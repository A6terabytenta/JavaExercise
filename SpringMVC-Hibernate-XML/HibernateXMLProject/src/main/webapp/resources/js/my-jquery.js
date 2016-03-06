var host = 'http://localhost:8081/spring/';
var currentPage = 1;
var maxSize = 10;
var numberPage = 1;
var begin = 0;
var end = 10;
var listSearch = null;

function loadPage(value, length) {
	currentPage = (value + 1);
	begin = value * maxSize;
	end = begin + maxSize;
	if (end > length) {
		end = length;
	}
	search(begin, end, currentPage, listSearch);
}
/* Load page 1 */
function first() {
	currentPage = 1;
	begin = 0;
	end = 5;
	search(begin, end, currentPage, listSearch);
}

function previous() {
	currentPage = currentPage - 1;
	if (currentPage < 1) {
		currentPage = 1;
	}
	begin = 0;
	end = begin + maxSize;
	search(begin, end, currentPage, listSearch);
}

function next(numberPage, length) {
	currentPage = currentPage + 1;
	if (currentPage == numberPage) {
		begin = ((numberPage - 1) * maxSize);
		currentPage = numberPage;
		end = length;
		console.log(begin + " " + end);
	} else {
		begin = begin + maxSize;
		end = begin + maxSize;
	}
	search(begin, end, currentPage, listSearch);
	
}

/* Load last page */
function last(numberPage, length) {
	currentPage = numberPage;
	begin = (numberPage - 1) * maxSize;
	end = length;
	search(begin, end, currentPage, listSearch);
}

function notification(type, title, content) {
	$("#notification").html("");
	switch (type) {
	case "error":
		$("#notification").append(
				"<p><span>Error: " + title + " - </span>" + content + "</p>");
		$("#notification").css("background", "rgba(242,178,175, 0.4)");
		$("#notification>p>span").css("color", "#f49f9a");
		$("#notification>p").css("color", "#f2ada9");
		break;
	case "info":
		$("#notification").append(
				"<p><span>Info: " + title + " - </span>" + content + "</p>");
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

var searchByValue = document.getElementById("searchByValue");
searchByValue.addEventListener("keypress", function(event) {
	if (event.keyCode == 13) {
		var value = searchByValue.value;
		if (value == "") {
			console.log("");
			window.location = host + "studentManagement";
		} else {
			var results = value.split(":");
			$
					.ajax({
						type : 'GET',
						url : host + "search/" + results[0] + "," + results[1],
						success : function(response) {
							console.log(response);
							if (response.length > 0) {
								blSearch = true;
								listSearch = response;
								end = response.length;
								if (response.length > maxSize) {
									end = maxSize;
								}
								search(0, end, 1, listSearch);
							} else {
								notification("info", "Search",
										"not searchable values");
							}
						}
					});
		}
	}
});

function search(begin, end, currentPage, response) {
	/* Create table */
	var results = "";
	for (var i = begin; i < end; i++) {
		results += "<tr>" + "<td>" + response[i].studentId + "</td>" + "<td>"
				+ response[i].studentName + "</td>" + "<td>"
				+ response[i].studentCore + "</td>" + "<td>"
				+ response[i].studentInfo.address + "</td>" + "<td>"
				+ response[i].studentInfo.averageScore + "</td>" + "<td>"
				+ new Date(response[i].studentInfo.dateOfBirth).getFullYear() + "-"
				+ (new Date(response[i].studentInfo.dateOfBirth).getMonth() + 1) + "-"
				+ new Date(response[i].studentInfo.dateOfBirth).getDate() + "</td>"
				+ "<td><a href='deleteStudent?studentId="+response[i].studentId+"' class='event fa fa-remove' title='remove'></a>"
				+ "<a href='update?studentId="+response[i].studentId+"' class='event fa fa-edit' title='edit'></a>"
				+ "</td>" + "</tr>"
		document.getElementById("tbody").innerHTML = results;
	}
	;

	/* Create paging */
	if (response.length % maxSize == 0) {
		numberPage = response.length / maxSize;
	} else {
		numberPage = (response.length / maxSize) + 1;
	}
	numberPage = parseInt(numberPage);
		
	var paging = "<div id='first' class='btn-paging btn btn-default btn-paging-first' onclick='first()'>first</div>"
			+ "<div id='previous' class='btn-paging btn btn-default btn-paging-content' onclick='previous()'>previous</div>";

	for (var i = 1; i <= numberPage; i++) {
		if (i == currentPage) {
			paging += "<div class='current btn-paging btn btn-default btn-paging-content' onclick='loadPage("
					+ (i - 1) + "," + response.length + ")'>" + i + "</div>";
		} else {
			paging += "<div class='btn-paging btn btn-default btn-paging-content' onclick='loadPage("
					+ (i - 1) + "," + response.length + ")'>" + i + "</div>";
		}
	}
	paging += "<div id='next' class='btn-paging btn btn-default btn-paging-content' onclick='next("
			+ numberPage
			+ ","
			+ response.length
			+ ")'>next</div>"
			+ "<div id='last' class='btn-paging btn btn-default btn-paging-last' onclick='last("
			+ numberPage + "," + response.length + ")'>last</div>";
	document.getElementById("paging").innerHTML = paging;

	if (currentPage == 1) {
		document.getElementById("first").style.background = "#eaeaea";
		document.getElementById("first").style.cursor = "not-allowed";
		document.getElementById("first").style.color = "#000";
		document.getElementById("previous").style.background = "#eaeaea";
		document.getElementById("previous").style.cursor = "not-allowed";
		document.getElementById("previous").style.color = "#000";
	}
	if (currentPage == numberPage) {
		document.getElementById("last").style.background = "#eaeaea";
		document.getElementById("last").style.cursor = "not-allowed";
		document.getElementById("last").style.color = "#000";
		document.getElementById("next").style.background = "#eaeaea";
		document.getElementById("next").style.cursor = "not-allowed";
		document.getElementById("next").style.color = "#000";
	}
	$('#dateOfBirth').datepicker({
		format : "yyyy-mm-dd",
	})
}