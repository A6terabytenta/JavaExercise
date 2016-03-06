package com.exercise.spring.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Student implements Serializable {
	private int id;
	private String studentCore;
	private String studentName;
	private String className;
	private String address;
	private String phoneNumber;
	private Date dateOfBirth;

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentCore() {
		return studentCore;
	}

	public void setStudentCore(String studentCore) {
		this.studentCore = studentCore;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentCore=" + studentCore
				+ ", studentName=" + studentName + ", className=" + className
				+ ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
