package com.demo.myapp.autowirebyname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");

		Customer customer = (Customer) context.getBean("customer");

		System.out.println("Full address of Customer: " + customer.getAddress());
	}
}
