package dataaccessobject;

public class StudentDemo {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		
		System.out.println(studentDao.getAllStudents());
		
		Student st1 = new Student("Vo Tan Loc", 0);
		
		studentDao.updateStudent(st1);
		
		System.out.println(studentDao.getStudent(0));
	}
}