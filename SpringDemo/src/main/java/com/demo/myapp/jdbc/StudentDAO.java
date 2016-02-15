package com.demo.myapp.jdbc;

public interface StudentDAO {

	public void insert(Student student);

	public Student findByStudentId(int studentId);
}
