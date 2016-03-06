package com.exercise.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.spring.model.Status;
import com.exercise.spring.model.Student;
import com.exercise.spring.model.StudentInfo;
import com.exercise.spring.service.StudentInfoService;
import com.exercise.spring.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentInfoService studentInfoService;
	
	@RequestMapping(value = URL.GETLISTSTUDENT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getListSutdent(
			HttpServletRequest request, HttpServletResponse response) {
		return studentService.getListStudent();
	}
	
	@RequestMapping(value = URL.GETSTUDENTBYID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student getStudentById(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("studentId") int studentId) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return studentService.getStudentById(studentId);
	}
	
	@RequestMapping(value = URL.DELETESTUDENT, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status deleteStudent(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("studentId") int studentId) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Status status = new Status();
		if (studentService.getStudentById(studentId) != null) {
			studentInfoService.deleteStudentInfo(studentId);
			studentService.deleteStudent(studentId);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Delete Student");
		} else {
			status.setErrorCore(Status.FAIL);
			status.setStatus(Status.STATUSFAIL);
			status.setErrorMessage("Delete Student");
		}

		return status;
	}
	
	@RequestMapping(value = URL.INSERTSTUDENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status insertStudent(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Student student)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(student);
		
		Status status = new Status();
		
		status.setErrorCore(Status.SUCCESSFUL);
		status.setStatus(Status.STATUSSUCCESSFUL);
		status.setErrorMessage("Insert Student");
		
		Student st = new Student();
		st.setStudentName(student.getStudentName());
		st.setStudentCore(student.getStudentCore());
		
		studentService.insertStudent(st);
		
		Student temp = studentService.selectLastStudent();
		
		System.out.println(temp.getStudentId());
		
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setAddress(student.getStudentInfo().getAddress());
		studentInfo.setAverageScore(student.getStudentInfo().getAverageScore());
		studentInfo.setDateOfBirth(student.getStudentInfo().getDateOfBirth());
		studentInfo.setStudentId(temp.getStudentId());
		
		studentInfoService.insertStudentInfo(studentInfo);
		
		return status;
	}
	
	
	@RequestMapping(value = URL.UPDATESTUDENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status updateStudent(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Student student)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Status status = new Status();
		
		if(studentService.getStudentById(student.getStudentId()) != null) {
			
			Student st = new Student();
			st.setStudentName(student.getStudentName());
			st.setStudentCore(student.getStudentCore());
			st.setStudentId(student.getStudentId());
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setAddress(student.getStudentInfo().getAddress());
			studentInfo.setAverageScore(student.getStudentInfo().getAverageScore());
			studentInfo.setDateOfBirth(student.getStudentInfo().getDateOfBirth());
			studentInfo.setStudentId(student.getStudentInfo().getStudentId());
			
			studentService.updateStudent(student);
			
			studentInfoService.updateStudentInfo(studentInfo);
			
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Update Student");
		} else {
			status.setErrorCore(Status.FAIL);
			status.setStatus(Status.STATUSFAIL);
			status.setErrorMessage("Update Student");
		}
		
		return status;
	}
	@RequestMapping(value = URL.SEARCH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> search(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("element") String element, @PathVariable("value") String value)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(element);
		System.out.println(value);
		switch(element.toLowerCase()){
		case "name":
			element = "student_name";
			break;
		case "core":
			element = "student_core";
			break;
		case "address":
			element = "address";
			break;
		case "average score":
			element = "average_score";
			break;
		case "birth day":
			element = "date_of_birth";
			break;
		}
		
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("element", element);
		map.put("value", value);
		
		return studentService.search(map);
	}
}
