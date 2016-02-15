var myApp = angular.module('myApp', [ 'ui.bootstrap' ]);

var host = 'http://localhost:8081/spring/';
var itemsPerPage = 5;
var currentPage = 2;
var maxSize = 5;
var bigTotalItems = 200;
var bigCurrentPage = 1;

myApp.controller('studentController', function($scope, $http) {
	var check = true;
	var studentName = document.getElementById("studentName");
	var studentCore = document.getElementById("studentCore");
	var address = document.getElementById("address");
	var averageScore = document.getElementById("averageScore");
	var dateOfBirth = document.getElementById("dateOfBirth");
	
	init($scope, $http);
	function init($scope, $http){
		$http({
			method : 'GET',
			url : host + 'rest/getListStudent'
		}).success(function(response) {
			$scope.listStudent = response;
			$scope.totalItems = response.length;

			$scope.itemsPerPage = itemsPerPage;
			if(response.length <= maxSize){
				$scope.currentPage = currentPage;
			} else {
				$scope.currentPage = response.length / maxSize;
			}
			$scope.maxSize = maxSize;
			$scope.bigTotalItems = bigTotalItems;
			$scope.bigCurrentPage = bigCurrentPage;

			$scope.pageCount = function() {
				return Math.ceil($scope.totalItems / $scope.itemsPerPage);
			};

			$scope.$watch('currentPage + itemsPerPage', function() {
				var begin = (($scope.currentPage - 1) * $scope.itemsPerPage);
				var end = begin + $scope.itemsPerPage;
				$scope.filteredListStudent = $scope.listStudent.slice(begin, end);
			});
		});
	}
	function setdefaultBackground() {
		studentName.style.background = "none";
		studentCore.style.background = "#none";
		address.style.background = "#none";
		averageScore.style.background = "#none";
		dateOfBirth.style.background = "#none";
	}
	
	function checkValidate(){
		check = true;
		if(studentName.value == "" || studentName.value == null) {
			check = false;
			studentName.style.background = "#ffe1e1";
		} else {
			studentName.style.background = "none";
		}
		if(studentCore.value == "" || studentCore.value == null) {
			check = false;
			studentCore.style.background = "#ffe1e1";
		} else {
			studentCore.style.background = "none";
		}
		if(address.value == "" || address.value == null) {
			check = false;
			address.style.background = "#ffe1e1";
		} else {
			address.style.background = "none";
		}
		if(averageScore.value == "" || averageScore.value == null) {
			check = false;
			averageScore.style.background = "#ffe1e1";
		} else {
			averageScore.style.background = "none";
		}
		if(dateOfBirth.value == "" || dateOfBirth.value == null) {
			check = false;
			dateOfBirth.style.background = "#ffe1e1";
		} else {
			dateOfBirth.style.background = "none";
		}
	}
	$scope.insert = function() {
		var choose = window.confirm("Do you want to continue?");
		if(choose == true){
			checkValidate();
			if(check){
				var student = {
					studentName : studentName.value,
					studentCore : studentCore.value,
					studentInfo : {
						address: address.value,
						averageScore: averageScore.value,
						dateOfBirth: dateOfBirth.value,
					}
				}
				$http({
					method : 'POST',
					url : host + 'rest/saveOrUpdateStudent',
					data: JSON.stringify(student)
				}).success(function(response){
					init($scope, $http);
				});
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	$scope.update = function(studentId, infoId) {
		var choose = window.confirm("Do you want to continue?");
		if(choose == true){
			checkValidate();
			if(check){
				var student = {
						studentId: studentId,
						studentName : studentName.value,
						studentCore : studentCore.value,
						studentInfo : {
							infoId: infoId,
							address: address.value,
							averageScore: averageScore.value,
							dateOfBirth: dateOfBirth.value,
						}
					}
				$http({
					method : 'POST',
					url : host + 'rest/saveOrUpdateStudent',
					data: JSON.stringify(student)
				}).success(function(response){
					init($scope, $http);
				});
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}
	$scope.remove = function(studentId) {
		var choose = window.confirm("Do you want to continue?");
		if(choose == true){
			$http({
				method : 'DELETE',
				url : host + 'rest/deleteStudent/'+ studentId
			}).success(function(response){
				if(response.errorCore == "True"){
					init($scope, $http);
				} else {
					return false;
				}
			})
			return true;
		}else{
			return false;
		}
	}
	$scope.edit = function(studentId) {
		var choose = window.confirm("Do you want to continue?");
		if(choose == true){
			$http({
				method : 'GET',
				url : host + 'rest/getStudentById/'+ studentId
			}).success(function(response){
				$scope.st = response;
				studentName.value = response.studentName;
				studentCore.value = response.studentCore;
				address.value = response.studentInfo.address;
				averageScore.value = response.studentInfo.averageScore;
				dateOfBirth.value = response.studentInfo.dateOfBirth;
			});
			return true;
		}else{
			return false;
		}
	}
});
