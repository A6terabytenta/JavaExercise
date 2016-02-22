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
/* Load page 1 */
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
    if(blSearch) {
    	search(begin, end, currentPage, listSearch);
    } else {
    	init(begin, end, currentPage, listStudent);
    }
}

/* Load last page*/
function last(numberPage, length) {
    currentPage = numberPage;
    begin = (numberPage - 1) * maxSize;
    end = length;
    init(begin, end, currentPage, listStudent);
}

init(begin, end, currentPage, listStudent);

/*Check a string contains special charactors*/
function checkUnicode(string) {
	string = string.toLowerCase();
	string = string.replace(/á|à|ạ|ả|ã|ắ|ằ|ẳ|ẵ|ặ|ấ|ầ|ẫ|ậ|ẩ/g,"a");
	string = string.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");
	string = string.replace(/ì|í|ị|ỉ|ĩ/g,"i");
	string = string.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o");
	string = string.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");
	string = string.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");
	string = string.replace(/đ/g,"d");
	string = string.replace(/,|;/g," ");
	console.log(string.trim());
	for(var index = 0; index < string.length; index++) {
		var char = string.charCodeAt(index);
		console.log(char);
		if(char < 97 || char > 122) {
			if(char != 32) {
				return false;
			}
		}
	}
	return true;
	
}

function checkValidateNumber(value) {
	if(isNaN(parseInt(value))) {
		return false;
	}
	return true;
}

function checkValidate() {
	setdefaultBackground();
    check = true;
    if (studentName.value == "" || studentName.value == null) {
        check = false;
        studentName.style.background = "#ffe1e1";
        notification("error", "Student Name", "is not null");
    } else if(studentName.value.length > 100) {
    	check = false;
        studentName.style.background = "#ffe1e1";
        notification("error", "Student Name", "1 -> 100 charactors");
    } else if(!checkUnicode(studentName.value)) {
    	check = false;
        studentName.style.background = "#ffe1e1";
        notification("error", "Student Name", "contains special charactors");
    } else {
    	 if (studentCore.value == "" || studentCore.value == null) {
    	        check = false;
    	        studentCore.style.background = "#ffe1e1";
    	        notification("error", "Student Core", "is not null");
    	 	} else if(studentCore.value.length > 50) {
    	    	check = false;
    	    	studentCore.style.background = "#ffe1e1";
    	        notification("error", "Student Core", "1 -> 50 charactors");
    	 	} else if (!checkValidateNumber(studentCore.value)) {
    	    	check = false;
    	    	studentCore.style.background = "#ffe1e1";
     	        notification("error", "Student Core", "is not a string");
    	    } else {
    	    	if (address.value == "" || address.value == null) {
        	        check = false;
        	        address.style.background = "#ffe1e1";
        	        notification("error", "Address", "is not null");
    	    	} else if(address.value.length > 200) {
    	        	check = false;
    	        	address.style.background = "#ffe1e1";
    	            notification("error", "Address", "1 -> 200 charactors");
    	    	} else if(!checkUnicode(address.value)) {
    	    	    check = false;
    	    	    address.style.background = "#ffe1e1";
    	    	    notification("error", "Address", "contains special charactors");
        	    } else {
        	    	if (averageScore.value == "" || averageScore.value == null) {
            	        check = false;
            	        averageScore.style.background = "#ffe1e1";
            	        notification("error", "Average Score", "is not null");
        	    	} else if (!checkValidateNumber(averageScore.value)) {
            	    	check = false;
             	        averageScore.style.background = "#ffe1e1";
             	        notification("error", "Average Score", "is not a string");
            	    } else {
            	    	 if (dateOfBirth.value == "" || dateOfBirth.value == null) {
                 	        check = false;
                 	        dateOfBirth.style.background = "#ffe1e1";
                 	        notification("error", "Birth", "is not null");
                 	    } else {
                 	    	setdefaultBackground();
                 	    }
            	    }
            	   
        	    }
        	    
    	    }    
    }
   
}
/*Set background for textbox*/
function setdefaultBackground() {
    studentName.style.background = "#fff";
    studentCore.style.background = "#fff";
    address.style.background = "#fff";
    averageScore.style.background = "#fff";
    dateOfBirth.style.background = "#fff";
}

/* Event for button edit */
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

/* Event for button remove */
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
                	notification("info", "Remove Student", "successful");
                } else {
                	notification("error", "Remove Student", "fail");
                }
            }
        });
        return true;
    } else {
        return false;
    }
}

/* Event for button install */
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
            	notification("info", "Install Student", "successful");
            });
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

/* Event for button update */
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
                studentName: studentName.value,
                studentCore: studentCore.value,
                studentInfo: {
                    infoId: infoId,
                    address: address.value,
                    averageScore: averageScore.value,
                    dateOfBirth: dateOfBirth.value,
                }
            }
            console.log(student);
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
            	notification("info", "Update Student", "successful");
            });
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

function notification(type, title, content) {
	$("#notification").html("");
	switch(type) {
	case "error":
		$("#notification").append("<p><span>Error: " + title + " - </span>" + content + "</p>");
		$("#notification").css("background","rgba(242,178,175, 0.4)");
		$("#notification>p>span").css("color","#f49f9a");
		$("#notification>p").css("color","#f2ada9");
		break;
	case "info":
		$("#notification").append("<p><span>Info: " + title + " - </span>" + content + "</p>");
		$("#notification").css("background","rgba(103,171,73, 0.4)");
		$("#notification>p>span").css("color","#55893e");
		$("#notification>p").css("color","#7cba61");
		break;
	}
	$("#notification").show("slice");
	setTimeout(function(){
		$("#notification").hide("slice");
	}, 5000);
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
                	if(response.length > 0) {
                		blSearch = true;
                    	listSearch = response;
                        end = response.length;
                        if (response.length > maxSize) {
                            end = maxSize;
                        }
                        search(0, end, 1, listSearch);
                	} else {
                		notification("info", "Search", "not searchable values");
                	}
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
    $('#dateOfBirth').datepicker({
		format : "yyyy-mm-dd",
	})
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
                $('#dateOfBirth').datepicker({
    				format : "yyyy-mm-dd",
    			})
            }
        });
}