package com.demo.myapp.autowirebyconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	
	Developer developer = (Developer) applicationContext.getBean("developer");
	
	System.out.println("Developer: " + developer.getLanguage());
}
}
