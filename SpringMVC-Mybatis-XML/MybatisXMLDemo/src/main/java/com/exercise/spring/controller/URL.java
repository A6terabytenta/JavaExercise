package com.exercise.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.spring.model.User;

@Controller
public class URL {
	
	public static final String GETLISTUSER = "/getListUser";
	public static final String GETUSERBYID = "/getUserById/{userId}";
	public static final String DELETEUSER = "/deleteUser/{userId}";
	public static final String SAVEORUPDATEUSER = "/saveOrUpdateUser";
	public static final String CHECKUSER = "/checkUser";
	
	public static final String GETLISTSTUDENT = "/getListStudent";
	public static final String GETSTUDENTBYID = "/getStudentById/{studentId}";
	public static final String SEARCH = "/search/{element},{value}";
	public static final String DELETESTUDENT = "/deleteStudent/{studentId}";
	public static final String INSERTSTUDENT = "/insertStudent";
	public static final String UPDATESTUDENT = "/updateStudent";
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(HttpSession session, Locale locale, Model model) {
		return "student";
	}
	
	@RequestMapping(value = "/studentManagement", method = RequestMethod.GET)
	public String studentManagement(HttpSession session, Locale locale, Model model) {
		if(!model.containsAttribute("User")) {
			model.addAttribute("User", new User());
		}
		return "home";
	}
}
