package com.exercise.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.dao.StudentInfoDao;
import com.exercise.spring.model.StudentInfo;

@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {
	
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Override
	public void saveOrUpdateStudentInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoDao.saveOrUpdateStudentInfo(studentInfo);
	}

	@Override
	public void deleteStudentInfo(int studentInfoId) {
		// TODO Auto-generated method stub
		studentInfoDao.deleteStudentInfo(studentInfoId);
	}

	@Override
	public List<StudentInfo> getListStudentInfo() {
		// TODO Auto-generated method stub
		return studentInfoDao.getListStudentInfo();
	}

	@Override
	public StudentInfo getStudentInfoById(int studentInfoId) {
		// TODO Auto-generated method stub
		return studentInfoDao.getStudentInfoById(studentInfoId);
	}

}
