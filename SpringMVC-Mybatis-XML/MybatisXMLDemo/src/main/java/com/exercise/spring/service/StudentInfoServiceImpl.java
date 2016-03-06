package com.exercise.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.mapper.StudentInfoMapper;
import com.exercise.spring.model.StudentInfo;

@Service("studentInfoService")
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService{
	
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public void insertStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoMapper.insertStudentInfo(studentInfo);
	}

	@Override
	public void updateStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoMapper.updateStudentInfo(studentInfo);
	}

	@Override
	public void deleteStudentInfo(int studentId) {
		// TODO Auto-generated method stub
		studentInfoMapper.deleteStudentInfo(studentId);
	}

}
