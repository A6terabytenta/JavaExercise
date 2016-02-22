package com.demo.myapp.autowirebytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"Beans.xml");

		Person preson = (Person) applicationContext.getBean("person");

		System.out.println(preson.getAbility());
	}
}
