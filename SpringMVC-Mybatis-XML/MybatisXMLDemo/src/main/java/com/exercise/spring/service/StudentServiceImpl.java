package com.exercise.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.mapper.StudentMapper;
import com.exercise.spring.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;

	public List<Student> getListStudent() {
		return studentMapper.getListStudent();
	}

	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insertStudent(student);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateStudent(student);
	}

	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		studentMapper.deleteStudent(studentId);
	}

	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return studentMapper.getStudentById(studentId);
	}
	
	public List<Student> search(Map<String, String> map) {
		return studentMapper.search(map);
		
	}

	@Override
	public Student selectLastStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectLastStudent();
	}
}
