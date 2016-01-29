package com.demo.myapp.injectingcollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	
	JavaCollection javaCollection = (JavaCollection) applicationContext.getBean("javaCollection");
	
	javaCollection.getList();
	javaCollection.getSet();
	javaCollection.getMap();
	javaCollection.getProperties();
}
}
