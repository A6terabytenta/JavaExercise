package com.exercise.spring.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.exercise.spring.model.Student;

public interface StudentMapper {

	@Select("SELECT * FROM student")
	@Results(value = { @Result(property = "id", column = "ID"),
			@Result(property = "studentCore", column = "STUDENT_CORE"),
			@Result(property = "studentName", column = "STUDENT_NAME"),
			@Result(property = "className", column = "CLASS_NAME"),
			@Result(property = "address", column = "ADDRESS"),
			@Result(property = "phoneNumber", column = "PHONE_NUMBER"),
			@Result(property = "dayOfBirth", column = "DAY_OF_BIRTH") })
	public List<Student> getListStudent();
}
