package com.exercise.spring.dao;

import java.util.List;

import com.exercise.spring.model.StudentInfo;

public interface StudentInfoDao {
	public void saveOrUpdateStudentInfo(StudentInfo studentInfo);

	public void deleteStudentInfo(int studentInfoId);

	public List<StudentInfo> getListStudentInfo();

	public StudentInfo getStudentInfoById(int studentInfoId);
}
