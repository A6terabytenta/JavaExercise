package com.demo.myapp.injectinginnerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	
	TextEditor textEditor = (TextEditor) applicationContext.getBean("textEditor");
	
	textEditor.helloWorld();
}
}
