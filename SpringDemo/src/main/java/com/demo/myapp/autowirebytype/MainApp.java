package com.demo.myapp.autowirebytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");

		Preson preson = (Preson) applicationContext.getBean("preson");

		System.out.println(preson.getAbility());
	}
}
