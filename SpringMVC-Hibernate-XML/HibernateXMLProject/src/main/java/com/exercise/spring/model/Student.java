package com.exercise.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Student implements Serializable {
	private int studentId;

	private String studentName;

	private String studentCore;
	
	private StudentInfo studentInfo;

	public Student() {
		super();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCore() {
		return studentCore;
	}

	public void setStudentCore(String studentCore) {
		this.studentCore = studentCore;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", studentCore=" + studentCore
				+ ", studentInfo=" + studentInfo + "]";
	}

}
