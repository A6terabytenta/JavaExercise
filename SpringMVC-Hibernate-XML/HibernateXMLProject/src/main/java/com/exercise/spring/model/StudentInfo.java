package com.exercise.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentInfo implements Serializable {

	private int infoId;

	private String address;

	private double averageScore;

	private Date dateOfBirth;

	private int studentId;

	@JsonIgnore
	private Student student;

	public StudentInfo() {
		super();
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "StudentInfo [infoId=" + infoId + ", address=" + address
				+ ", averageScore=" + averageScore + ", dateOfBirth="
				+ dateOfBirth + ", studentId=" + studentId + "]";
	}

}
