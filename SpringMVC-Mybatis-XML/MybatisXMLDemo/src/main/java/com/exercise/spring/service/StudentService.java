package com.exercise.spring.service;

import java.util.List;
import java.util.Map;

import com.exercise.spring.model.Student;

public interface StudentService {
	public List<Student> getListStudent();
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int studentId);
	
	public Student getStudentById(int studentId);
	
	public Student selectLastStudent();
	
	public List<Student> search(Map<String, String> map);
}
