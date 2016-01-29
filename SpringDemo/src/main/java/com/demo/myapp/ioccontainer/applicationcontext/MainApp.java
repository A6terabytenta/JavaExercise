package com.demo.myapp.ioccontainer.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"E:/Tai Lieu/Project/SpringDemo/src/main/java/Beans.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
