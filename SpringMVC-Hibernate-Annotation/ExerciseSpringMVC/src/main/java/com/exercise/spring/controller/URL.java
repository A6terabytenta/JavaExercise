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
	public static final String GETLISTUSER = "/rest/getListUser";
	public static final String GETUSERBYID = "/rest/getUserById/{userId}";
	public static final String DELETEUSER = "/rest/deleteUser/{userId}";
	public static final String SAVEORUPDATEUSER = "/rest/saveOrUpdateUser";
	public static final String CHECKUSER = "/rest/checkUser";
	
	public static final String GETLISTSTUDENT = "/rest/getListStudent";
	public static final String GETSTUDENTBYID = "/rest/getStudentById/{studentId}";
	public static final String SEARCH = "/rest/search/{element},{value}";
	public static final String DELETESTUDENT = "/rest/deleteStudent/{studentId}";
	public static final String SAVEORUPDATESTUDENT = "/rest/saveOrUpdateStudent";
	
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
