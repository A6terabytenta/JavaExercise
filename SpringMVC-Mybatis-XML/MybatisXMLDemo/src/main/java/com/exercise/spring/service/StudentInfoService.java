package com.exercise.spring.service;

import com.exercise.spring.model.StudentInfo;

public interface StudentInfoService {

	public void insertStudentInfo(StudentInfo studentInfo);

	public void updateStudentInfo(StudentInfo studentInfo);

	public void deleteStudentInfo(int studentId);
}
