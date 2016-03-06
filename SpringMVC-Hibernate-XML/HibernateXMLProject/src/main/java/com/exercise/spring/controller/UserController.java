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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.spring.model.Student;
import com.exercise.spring.model.User;
import com.exercise.spring.service.StudentService;
import com.exercise.spring.service.UserService;

@Controller
public class UserController {
	public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView checkLogin(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("User") User user,
			ModelMap model) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		boolean check = userService.checkUser(user);

		ModelAndView modelAndView = new ModelAndView();

		if (check == true) {
			model.remove("error");
			modelAndView.setViewName("studentManagement");

			List<Student> studentList = studentService.getListStudent();
			modelAndView.addObject("studentList", studentList);

			modelAndView.addObject("begin", StudentController.begin);
			modelAndView.addObject("end", StudentController.end);

			if (studentList.size() % 10 == 0) {
				StudentController.length = studentList.size() / 10;
			} else {
				StudentController.length = studentList.size() / 10 + 1;
			}
			modelAndView.addObject("length", StudentController.length);

			modelAndView
					.addObject("currentPage", StudentController.currentPage);
		} else {
			model.addAttribute("error", "error");
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}

}
