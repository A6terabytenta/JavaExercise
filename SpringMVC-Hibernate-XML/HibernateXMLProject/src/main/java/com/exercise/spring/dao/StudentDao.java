package com.exercise.spring.dao;

import java.util.List;

import com.exercise.spring.model.Student;

public interface StudentDao {
	public boolean saveStudent(Student student);
	
	public boolean updateStudent(Student student);

	public void deleteStudent(int studentId);

	public List<Student> getListStudent();

	public Student getStudentById(int studentId);

	public List<Student> search(String element, String value);
}
