package com.exercise.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "student", catalog = "exercise")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private int studentId;

	@Column(name = "student_name", nullable = false, length = 100)
	private String studentName;

	@Column(name = "student_core", nullable = false, length = 50)
	private String studentCore;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	private StudentInfo studentInfo;

	public Student() {
		super();
	}

	public Student(String studentName, String studentCore,
			StudentInfo studentInfo) {
		super();
		this.studentName = studentName;
		this.studentCore = studentCore;
		this.studentInfo = studentInfo;
	}

	public Student(int studentId, String studentName, String studentCore,
			StudentInfo studentInfo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCore = studentCore;
		this.studentInfo = studentInfo;
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
