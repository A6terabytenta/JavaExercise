package model;

import java.util.List;

public interface StudentInterface {
	public void saveStudent(Student student);

	public void deleteStudent(Student student);

	public Student getStudent(int id);
	
	public List<Student> getListStudent();
	
	public List<Student> getListStudent(int first, int maxValue);
	
	public List<Student> search(String name);
}
