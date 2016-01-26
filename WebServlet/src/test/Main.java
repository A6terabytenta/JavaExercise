package test;

import java.util.List;

import model.Student;
import model.StudentDao;

public class Main {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.search("Tuan");
		System.out.println(students);
		System.out.println("dome");
	}
}
