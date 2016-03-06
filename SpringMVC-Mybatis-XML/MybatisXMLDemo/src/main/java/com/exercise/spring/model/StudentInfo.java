package com.exercise.spring.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class StudentInfo implements Serializable {
	private int infoId;
	private int studentId;
	private String address;
	private double averageScore;
	private Date dateOfBirth;
	
	public StudentInfo() {
		super();
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	@Override
	public String toString() {
		return "StudentInfo [infoId=" + infoId + ", studentId=" + studentId
				+ ", address=" + address + ", averageScore=" + averageScore
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
