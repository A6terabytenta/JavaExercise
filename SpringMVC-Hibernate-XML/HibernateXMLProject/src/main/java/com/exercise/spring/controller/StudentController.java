package com.exercise.spring.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.spring.model.Student;
import com.exercise.spring.model.StudentInfo;
import com.exercise.spring.service.StudentService;

@Controller
public class StudentController {
	public static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	ModelAndView modelAndView = new ModelAndView();

	public static int begin = 0;
	public static int end = 9;
	public static int currentPage = 1;
	public static int length = 0;

	@RequestMapping(value = "studentManagement")
	public ModelAndView studentManagement() {
		modelAndView.setViewName("studentManagement");

		List<Student> studentList = studentService.getListStudent();
		modelAndView.addObject("studentList", studentList);

		modelAndView.addObject("begin", begin);
		modelAndView.addObject("end", end);

		if (studentList.size() % 10 == 0) {
			length = studentList.size() / 10;
		} else {
			length = studentList.size() / 10 + 1;
		}
		modelAndView.addObject("length", length);

		modelAndView.addObject("currentPage", currentPage);
		return modelAndView;
	}

	@RequestMapping(value = "insert")
	public ModelAndView insert() {
		return new ModelAndView("insert", "command", new Student());
	}

	@RequestMapping(value = "update")
	public ModelAndView update(@RequestParam("studentId") int studentId) {
		Student student = studentService.getStudentById(studentId);
		return new ModelAndView("update", "Student", student);
	}

	@RequestMapping(value = "paging")
	public ModelAndView paging(@RequestParam("page") int newPage) {
		begin = 10 * (newPage - 1);
		end = begin + 9;

		currentPage = newPage;

		modelAndView.addObject("title", "Load");
		modelAndView.addObject("type", "info");
		modelAndView.addObject("content", " success page " + newPage);

		return studentManagement();
	}

	@RequestMapping(value = "/getStudentById/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

	@RequestMapping(value = "deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("studentId") int studentId) {

		studentService.deleteStudent(studentId);

		Student student = studentService.getStudentById(studentId);

		modelAndView.addObject("title", "Delete");

		if (student != null) {
			modelAndView.addObject("type", "error");
			modelAndView.addObject("content", "Delete failed student");
		} else {
			modelAndView.addObject("type", "info");
			modelAndView.addObject("content", "Delete success student");
		}

		return studentManagement();
	}

	@RequestMapping(value = "insertStudent")
	public ModelAndView insertStudent(
			@ModelAttribute("Student") Student student, BindingResult result,
			ModelMap model) {
		Student st = new Student();
		st.setStudentName(student.getStudentName());
		st.setStudentCore(student.getStudentCore());

		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setAddress(student.getStudentInfo().getAddress());
		studentInfo.setAverageScore(student.getStudentInfo().getAverageScore());
		studentInfo.setDateOfBirth(student.getStudentInfo().getDateOfBirth());
		studentInfo.setStudentId(student.getStudentId());
		studentInfo.setStudent(st);

		st.setStudentInfo(studentInfo);

		System.out.println(st);
		boolean check = studentService.saveStudent(st);
		// modelAndView.addObject("title", "Insert");
		// if (check) {
		// modelAndView.addObject("type", "info");
		// modelAndView.addObject("content", "Insert success student");
		// } else {
		// modelAndView.addObject("type", "error");
		// modelAndView.addObject("content", "Insert failed student");
		// }
		return new ModelAndView("insert", "command", new Student());
	}

	@RequestMapping(value = "updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("Student") Student student, BindingResult result,
			ModelMap model) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update");

		student.getStudentInfo().setStudentId(student.getStudentId());
		boolean check = studentService.updateStudent(student);
		modelAndView.addObject("title", "Update");
		if (check) {
			modelAndView.addObject("type", "info");
			modelAndView.addObject("content", "Update success student");
		} else {
			modelAndView.addObject("type", "error");
			modelAndView.addObject("content", "Update failed student");
		}
		modelAndView.addObject("Student",
				studentService.getStudentById(student.getStudentId()));
		return modelAndView;
	}

	@RequestMapping(value = "/search/{element},{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> search(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("element") String element,
			@PathVariable("value") String value) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(element);
		System.out.println(value);
		switch (element.toLowerCase()) {
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
