package com.demo.myapp.jdbc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private int id;
	private String name;
	private String className;
	private String status;

	public Student(int id, String name, String className, String status) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.status = status;
	}

	public Student(String name, String className, String status) {
		this.name = name;
		this.className = className;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", className="
				+ className + ", status=" + status + "]";
	}

}
