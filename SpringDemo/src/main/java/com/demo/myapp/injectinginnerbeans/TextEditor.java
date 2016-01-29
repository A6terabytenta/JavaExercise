package com.demo.myapp.injectinginnerbeans;

public class TextEditor {
	private HelloWorld helloWorld;

	// a method to return helloWorld
	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	// a setter method to inject the dependence
	public void setHelloWorld(HelloWorld helloWorld) {
		System.out.println("setHelloWorld method.");
		this.helloWorld = helloWorld;
	}

	public void helloWorld() {
		helloWorld.message();
	}
}
