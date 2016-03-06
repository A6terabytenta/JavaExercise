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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.spring.model.Status;
import com.exercise.spring.model.User;
import com.exercise.spring.service.UserService;

@Controller
public class UserController {
	public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = URL.GETLISTUSER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getListUser(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return userService.getListUser();
	}

	@RequestMapping(value = URL.GETUSERBYID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("userId") int userId)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return userService.getUserById(userId);
	}

	@RequestMapping(value = URL.DELETEUSER, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status deleteUser(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("userId") int userId)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Status status = new Status();
		if (userService.getUserById(userId) != null) {
			userService.deleteUser(userId);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Delete User");
		} else {
			status.setErrorCore(Status.FAIL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Delete User");
		}

		return status;
	}

	@RequestMapping(value = URL.SAVEORUPDATEUSER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status saveOrUpdateUser(HttpServletRequest request,
			HttpServletResponse response, @RequestBody User user)
			throws ParseException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Status status = new Status();
		if (userService.getUserById(user.getUserId()) != null) {
			userService.saveOrUpdateUser(user);
			logger.info("Update User: " + user);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Update User");
		} else {
			userService.saveOrUpdateUser(user);
			logger.info("Insert User: " + user);
			status.setErrorCore(Status.SUCCESSFUL);
			status.setStatus(Status.STATUSSUCCESSFUL);
			status.setErrorMessage("Insert User");
		}

		return status;
	}

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
		
		boolean check = userService.checkUser(user);
		System.out.println(check);
		if (check == true) {
			model.remove("error");
			return "studentManagement";
		} else {
			model.addAttribute("error", "error");
			return "home";
		}
	}

}
