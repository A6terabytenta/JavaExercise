package com.exercise.spring.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@JsonIgnoreProperties()
public class Student implements Serializable {
	private int studentId;
	private String studentCore;
	private String studentName;
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

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentCore="
				+ studentCore + ", studentName=" + studentName
				+ ", studentInfo=" + studentInfo + "]";
	}

}
