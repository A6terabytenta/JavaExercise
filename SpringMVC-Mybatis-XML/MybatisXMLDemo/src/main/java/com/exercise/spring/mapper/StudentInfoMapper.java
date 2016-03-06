package com.exercise.spring.mapper;

import com.exercise.spring.model.StudentInfo;

public interface StudentInfoMapper {
	
	public void insertStudentInfo(StudentInfo studentInfo);

	public void updateStudentInfo(StudentInfo studentInfo);

	public void deleteStudentInfo(int studentId);
}
