package com.demo.myapp.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		StudentDAO studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");

		Student student = studentDAO.findByStudentId(1);

		System.out.println(student);
	}
}
