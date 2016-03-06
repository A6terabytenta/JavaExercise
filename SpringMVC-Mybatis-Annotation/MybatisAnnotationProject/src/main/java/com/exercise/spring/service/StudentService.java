package com.exercise.spring.service;

import java.util.List;

import com.exercise.spring.model.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int studentId);

	public List<Student> getListStudent();
}
