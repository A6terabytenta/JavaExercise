package com.exercise.spring.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.exercise.spring.service.StudentService;

@Controller
public class StudentController {
	public static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	/**
	 * @author TA
	 * @param request
	 * @param response
	 * @return List<Student>
	 * @throws ParseException
	 */
	@RequestMapping(value = URL.GETLISTSTUDENT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getListStudent(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return studentService.getListStudent();
	}
	
	/**
	 * @author TA
	 * @param request
	 * @param response
	 * @param studentId
	 * @return Student
	 * @throws ParseException
	 */
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
	
	/**
	 * @author TA
	 * @param request
	 * @param response
	 * @param studentId
	 * @return Status
	 * @throws ParseException
	 */
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
			studentService.deleteStudent(studentId);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Delete Student");
		} else {
			status.setErrorCore(Status.FAIL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Delete Student");
		}

		return status;
	}

	/**
	 * @author TA
	 * @param request
	 * @param response
	 * @param student
	 * @return Status
	 * @throws ParseException
	 */
	@RequestMapping(value = URL.SAVEORUPDATESTUDENT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status saveOrUpdateStudent(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Student student)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Student st = new Student();
		st.setStudentName(student.getStudentName());
		st.setStudentCore(student.getStudentCore());
		
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setAddress(student.getStudentInfo().getAddress());
		studentInfo.setAverageScore(student.getStudentInfo().getAverageScore());
		studentInfo.setDateOfBirth(student.getStudentInfo().getDateOfBirth());
		studentInfo.setStudent(st);		
		
		Status status = new Status();
		if (studentService.getStudentById(student.getStudentId()) != null) {
			studentInfo.setInfoId(student.getStudentInfo().getInfoId());
			st.setStudentInfo(studentInfo);
			st.setStudentId(student.getStudentId());
			studentService.saveOrUpdateStudent(st);
			logger.info("Update User: " + st);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Update User");
		} else {
			st.setStudentInfo(studentInfo);
			studentService.saveOrUpdateStudent(st);
			logger.info("Insert User: " + st);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Insert User");
		}

		return status;
	}
	
	/**
	 * @author TA
	 * @param request
	 * @param response
	 * @param element
	 * @param value
	 * @return List<Student>
	 * @throws ParseException
	 */
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
			element = "studentInfo.address";
			break;
		case "average score":
			element = "studentInfo.average_score";
			break;
		case "birth day":
			element = "studentInfo.date_of_birth";
			break;
		}
		return studentService.search(element, value);
	}
	
}

