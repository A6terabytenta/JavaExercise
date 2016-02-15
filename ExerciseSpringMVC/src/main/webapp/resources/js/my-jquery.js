var host = 'http://localhost:8081/spring/';
var currentPage = 1;
var maxSize = 5;
var numberPage = 1;
var begin = 0;
var end = 5;
var stId = 0;
var infoId = 0;
var click = 0;
var listSearch = null;
var listStudent = null;
var blSearch = false;

function loadPage(value, length) {
    currentPage = (value + 1);
    begin = value * maxSize;
    end = begin + maxSize;
    if (end > length) {
        end = length;
    }
    init(begin, end, currentPage, listStudent);
}

function first() {
    currentPage = 1;
    begin = 0;
    end = 5;
    init(begin, end, currentPage, listStudent);
}

function previous() {
    currentPage = currentPage - 1;
    if(currentPage < 1) {
    	currentPage = 1;
    }
    begin = 0;
    end = begin + maxSize;
    init(begin, end, currentPage, listStudent);
}

function next(numberPage, length) {
    if (currentPage == numberPage) {
        begin = ((numberPage - 1) * maxSize);
        currentPage = numberPage;
        end = length;
        console.log(begin + " " + end);
    } else {
    	currentPage = currentPage + 1;
        begin = begin + maxSize;
        end = begin + maxSize;
    }
    if(blSearch) {
    	search(begin, end, currentPage, listSearch);
    } else {
    	init(begin, end, currentPage, listStudent);
    }
}

function last(numberPage, length) {
    currentPage = numberPage;
    begin = (numberPage - 1) * maxSize;
    end = length;
    init(begin, end, currentPage, listStudent);
}

init(begin, end, currentPage, listStudent);

function checkValidate() {
    check = true;
    if (studentName.value == "" || studentName.value == null) {
        check = false;
        studentName.style.background = "#ffe1e1";
    } else {
        studentName.style.background = "none";
    }
    if (studentCore.value == "" || studentCore.value == null) {
        check = false;
        studentCore.style.background = "#ffe1e1";
    } else {
        studentCore.style.background = "none";
    }
    if (address.value == "" || address.value == null) {
        check = false;
        address.style.background = "#ffe1e1";
    } else {
        address.style.background = "none";
    }
    if (averageScore.value == "" || averageScore.value == null) {
        check = false;
        averageScore.style.background = "#ffe1e1";
    } else {
        averageScore.style.background = "none";
    }
    if (dateOfBirth.value == "" || dateOfBirth.value == null) {
        check = false;
        dateOfBirth.style.background = "#ffe1e1";
    } else {
        dateOfBirth.style.background = "none";
    }
}

function setdefaultBackground() {
    studentName.style.background = "none";
    studentCore.style.background = "#none";
    address.style.background = "#none";
    averageScore.style.background = "#none";
    dateOfBirth.style.background = "#none";
}

function edit(studentId) {
    var studentName = document.getElementById("studentName");
    var studentCore = document.getElementById("studentCore");
    var address = document.getElementById("address");
    var averageScore = document.getElementById("averageScore");
    var dateOfBirth = document.getElementById("dateOfBirth");
    $.ajax({
        type: 'GET',
        url: host + 'rest/getStudentById/' + studentId,
        success: function(response) {
            stId = response.studentId;
            infoId = response.studentInfo.infoId;
            studentName.value = response.studentName;
            studentCore.value = response.studentCore;
            address.value = response.studentInfo.address;
            averageScore.value = response.studentInfo.averageScore;
            dateOfBirth.value = response.studentInfo.dateOfBirth;
        }
    });
}

function removeStudent(studentId) {
    var choose = confirm("Do you want to continue?");
    if (choose == true) {
        $.ajax({
            type: 'DELETE',
            url: host + 'rest/deleteStudent/' + studentId,
            success: function(response) {
                if (response.errorCore == "True") {
                	listSearch = null;
                	listStudent = null;
                	blSearch = false;
                	init(0, maxSize, 1, null);
                	first();
                } else {
                    return false;
                }
            }
        });
        return true;
    } else {
        return false;
    }
}

function insertStudent() {
    var choose = window.confirm("Do you want to continue?");
    if (choose == true) {
        var studentName = document.getElementById("studentName");
        var studentCore = document.getElementById("studentCore");
        var address = document.getElementById("address");
        var averageScore = document.getElementById("averageScore");
        var dateOfBirth = document.getElementById("dateOfBirth");
        checkValidate();
        if (check) {
            var student = {
                studentName: studentName.value,
                studentCore: studentCore.value,
                studentInfo: {
                    address: address.value,
                    averageScore: averageScore.value,
                    dateOfBirth: dateOfBirth.value,
                }
            }
            $.ajax({
                method: 'POST',
                url: host + 'rest/saveOrUpdateStudent',
                data: JSON.stringify(student),
                contentType: 'application/json',
                dataType: 'json',
            }).success(function(response) {
            	listSearch = null;
            	listStudent = null;
            	blSearch = false;
            	init(0, maxSize, 1, null);
            	last(numberPage, length);
            });
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

function updateStudent() {
    var choose = window.confirm("Do you want to continue?" + stId + infoId);
    if (choose == true) {
        var studentName = document.getElementById("studentName");
        var studentCore = document.getElementById("studentCore");
        var address = document.getElementById("address");
        var averageScore = document.getElementById("averageScore");
        var dateOfBirth = document.getElementById("dateOfBirth");
        checkValidate();
        if (check) {
            var student = {
                studentId: stId,
                studentCore: studentCore.value,
                studentInfo: {
                    infoId: infoId,
                    address: address.value,
                    averageScore: averageScore.value,
                    dateOfBirth: dateOfBirth.value,
                }
            }
            $.ajax({
                method: 'POST',
                url: host + 'rest/saveOrUpdateStudent',
                data: JSON.stringify(student),
                contentType: 'application/json',
                dataType: 'json',
            }).success(function(response) {
            	blSearch = false;
            	listStudent = null;
            	listSearch = null;
            	init(0, maxSize, 1, null);
            });
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}
var searchByValue = document.getElementById("searchByValue");
searchByValue.addEventListener("keypress", function(event) {
    if (event.keyCode == 13) {
        var value = searchByValue.value;
        if(value == "") {
        	first();
        } else {
        	var results = value.split(":");
            $.ajax({
                type: 'GET',
                url: host + "rest/search/" + results[0] + "," + results[1],
                success: function(response) {
                	blSearch = true;
                	listSearch = response;
                    end = response.length;
                    if (response.length > maxSize) {
                        end = maxSize;
                    }
                    search(0, end, 1, listSearch);
                }
            });
        }
    }
});
function search(begin, end, currentPage, response) {
	/* Create table */
    var results = "<tr>" + "<td>#</td>" + "<td><input type='text' class='form-control' id='studentName' /></td>" + "<td><input type='text' class='form-control' id='studentCore' /></td>" + "<td><input type='text' class='form-control' id='address' /></td>" + "<td><input type='text' class='form-control' id='averageScore' /></td>" + "<td><input type='text' class='form-control' id='dateOfBirth' /></td>" + "<td><a class='event fa fa-save' onclick='insertStudent()' title='insert'></a> <a class='event fa fa-refresh' onclick='updateStudent()' title='update'></a></td>" + "</tr>";
    for (var i = begin; i < end; i++) {
        results += "<tr>" + "<td>" + response[i].studentId + "</td>" + "<td>" + response[i].studentName + "</td>" + "<td>" + response[i].studentCore + "</td>" + "<td>" + response[i].studentInfo.address + "</td>" + "<td>" + response[i].studentInfo.averageScore + "</td>" + "<td>" + response[i].studentInfo.dateOfBirth + "</td>" + "<td><a class='event fa fa-remove' onclick='removeStudent(" + response[i].studentId + ")' " + "title='remove'></a> <a class='event fa fa-edit'" + " onclick='edit(" + response[i].studentId + ")' title='edit'></a></td>" + "</tr>"
        document.getElementById("tbody").innerHTML = results;
    };

    /* Create paging */
    if (response.length % maxSize == 0) {
        numberPage = response.length / maxSize;
    } else {
        numberPage = (response.length / maxSize) + 1;
    }
    numberPage = parseInt(numberPage);

    var paging = "<div id='first' class='btn-paging btn btn-default btn-paging-first' onclick='first()'>first</div>" + "<div id='previous' class='btn-paging btn btn-default btn-paging-content' onclick='previous()'>previous</div>";
    
    for (var i = 1; i <= numberPage; i++) {
        if (i == currentPage) {
            paging += "<div class='current btn-paging btn btn-default btn-paging-content' onclick='loadPage(" + (i - 1) + "," + response.length + ")'>" + i + "</div>";
        } else {
            paging += "<div class='btn-paging btn btn-default btn-paging-content' onclick='loadPage(" + (i - 1) + "," + response.length + ")'>" + i + "</div>";
        }
    }
    paging += "<div id='next' class='btn-paging btn btn-default btn-paging-content' onclick='next(" + numberPage + "," + response.length + ")'>next</div>" + "<div id='last' class='btn-paging btn btn-default btn-paging-last' onclick='last(" + numberPage + "," + response.length + ")'>last</div>";
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
}

function sort(value) {
	if(blSearch) {
		listStudent = listSearch;
	}
	var array = [];
	for(entry in listStudent) {
		array.push(listStudent[entry]);
	}
	switch(value) {
		case "id":
			click++;
        	array.sort(function(a,b){return a.studentId - b.studentId});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
		case "name":
			click++;
        	array.sort(function(a,b){return a.studentName - b.studentName});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
		case "core":
			click++;
        	array.sort(function(a,b){return a.studentCore - b.studentCore});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
		case "address":
			click++;
        	array.sort(function(a,b){return a.studentInfo.address - b.studentInfo.address});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
		case "score":
			click++;
        	array.sort(function(a,b){return a.studentInfo.averageScore - b.studentInfo.averageScore});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
		case "birthday":
			click++;
        	array.sort(function(a,b){return a.studentInfo.dateOfBirth - b.studentInfo.dateOfBirth});
        	if(click % 2 == 1) {
        		array.reverse();
        	}
        	break;
	}
	end = array.length;
	if(array.length > maxSize) {
		end = maxSize;
	}
	init(0, end, 1, array);
}

function init(begin, end, currentPage, listSt) {
    $
        .ajax({
            type: 'GET',
            url: host + 'rest/getListStudent',
            success: function(response) {
            	if(listSt != null) {
            		response = listSt;
            	}
            	listStudent = response;
                /* Create table */
                var results = "<tr>" + "<td>#</td>" + "<td><input type='text' class='form-control' id='studentName' /></td>" + "<td><input type='text' class='form-control' id='studentCore' /></td>" + "<td><input type='text' class='form-control' id='address' /></td>" + "<td><input type='text' class='form-control' id='averageScore' /></td>" + "<td><input type='text' class='form-control' id='dateOfBirth' /></td>" + "<td><a class='event fa fa-save' onclick='insertStudent()' title='insert'></a> <a class='event fa fa-refresh' onclick='updateStudent()' title='update'></a></td>" + "</tr>";
                for (var i = begin; i < end; i++) {
                    results += "<tr>" + "<td>" + response[i].studentId + "</td>" + "<td>" + response[i].studentName + "</td>" + "<td>" + response[i].studentCore + "</td>" + "<td>" + response[i].studentInfo.address + "</td>" + "<td>" + response[i].studentInfo.averageScore + "</td>" + "<td>" + response[i].studentInfo.dateOfBirth + "</td>" + "<td><a class='event fa fa-remove' onclick='removeStudent(" + response[i].studentId + ")' " + "title='remove'></a> <a class='event fa fa-edit'" + " onclick='edit(" + response[i].studentId + ")' title='edit'></a></td>" + "</tr>"
                    document.getElementById("tbody").innerHTML = results;
                };

                /* Create paging */
                if (response.length % maxSize == 0) {
                    numberPage = response.length / maxSize;
                } else {
                    numberPage = (response.length / maxSize) + 1;
                }
                numberPage = parseInt(numberPage);

                var paging = "<div id='first' class='btn-paging btn btn-default btn-paging-first' onclick='first()'>first</div>" + "<div id='previous' class='btn-paging btn btn-default btn-paging-content' onclick='previous()'>previous</div>";
                
                for (var i = 1; i <= numberPage; i++) {
                    if (i == currentPage) {
                        paging += "<div class='current btn-paging btn btn-default btn-paging-content' onclick='loadPage(" + (i - 1) + "," + response.length + ")'>" + i + "</div>";
                    } else {
                        paging += "<div class='btn-paging btn btn-default btn-paging-content' onclick='loadPage(" + (i - 1) + "," + response.length + ")'>" + i + "</div>";
                    }
                }
                paging += "<div id='next' class='btn-paging btn btn-default btn-paging-content' onclick='next(" + numberPage + "," + response.length + ")'>next</div>" + "<div id='last' class='btn-paging btn btn-default btn-paging-last' onclick='last(" + numberPage + "," + response.length + ")'>last</div>";
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

            }
        });
}