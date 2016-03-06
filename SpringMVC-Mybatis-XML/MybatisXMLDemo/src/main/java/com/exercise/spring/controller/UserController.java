package com.exercise.spring.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exercise.spring.model.User;
import com.exercise.spring.service.UserService;

@Controller
public class UserController {
	
	public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/studentManagement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkLogin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("User") User user,
			ModelMap model) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		User u = userService.checkUser(user);
		if (u != null) {
			model.remove("error");
			return "studentManagement";
		} else {
			model.addAttribute("error", "error");
			return "home";
		}
	}

}
