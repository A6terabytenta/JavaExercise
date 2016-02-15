package com.demo.myapp.eventhandling;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext(
				"Beans.xml");

		configurableApplicationContext.start();

		HelloWorld helloWorld = (HelloWorld) configurableApplicationContext
				.getBean("helloWorld");

		helloWorld.getMessage();

		configurableApplicationContext.stop();
	}

}
