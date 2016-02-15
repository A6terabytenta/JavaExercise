package com.exercise.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "student_info", catalog = "exercise")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StudentInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id", unique = true, nullable = false)
	private int infoId;

	@Column(name = "address", nullable = false, length = 200)
	private String address;

	@Column(name = "average_score", nullable = false)
	private double averageScore;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	public StudentInfo() {
		super();
	}

	public StudentInfo(String address, double averageScore, Date dateOfBirth,
			Student student) {
		super();
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
		this.student = student;
	}

	public StudentInfo(int infoId, String address, double averageScore,
			Date dateOfBirth, Student student) {
		super();
		this.infoId = infoId;
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
		this.student = student;
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

	@Override
	public String toString() {
		return "StudentInfo [infoId=" + infoId + ", address=" + address
				+ ", averageScore=" + averageScore + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

}
