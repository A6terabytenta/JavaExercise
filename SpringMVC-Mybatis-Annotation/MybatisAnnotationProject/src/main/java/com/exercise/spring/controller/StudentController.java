package com.exercise.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.spring.model.Student;
import com.exercise.spring.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@RequestMapping(value = "/getListStudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> getListSutdent(HttpServletRequest request, HttpServletResponse response) {
		return studentService.getListStudent();
	}
}
