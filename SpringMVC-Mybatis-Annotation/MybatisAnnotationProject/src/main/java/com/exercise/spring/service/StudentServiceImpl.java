package com.exercise.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.mappers.StudentMapper;
import com.exercise.spring.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		return studentMapper.getListStudent();
	}

}
