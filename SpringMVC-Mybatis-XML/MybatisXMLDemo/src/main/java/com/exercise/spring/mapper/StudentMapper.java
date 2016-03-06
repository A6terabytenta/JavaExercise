package com.exercise.spring.mapper;

import java.util.List;
import java.util.Map;

import com.exercise.spring.model.Student;

public interface StudentMapper {
	
	public List<Student> getListStudent();
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(int studentId);
	
	public Student getStudentById(int studentId);
	
	public Student selectLastStudent();
	
	public List<Student> search(Map<String, String> map);
}
