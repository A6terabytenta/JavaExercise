package com.exercise.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.dao.StudentDao;
import com.exercise.spring.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void saveOrUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.saveOrUpdateStudent(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(studentId);
	}

	@Override
	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		return studentDao.getListStudent();
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(studentId);
	}

	@Override
	public List<Student> search(String element, String value) {
		// TODO Auto-generated method stub
		return studentDao.search(element, value);
	}

}
