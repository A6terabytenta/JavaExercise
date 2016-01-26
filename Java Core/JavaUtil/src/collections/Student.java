package collections;

public class Student implements Comparable<Student> {
	private int mssv;
	private String name;

	public Student(int mssv, String name) {
		super();
		this.mssv = mssv;
		this.name = name;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return mssv + ": " + name;
	}

	@Override
	public int compareTo(Student student) {
		// TODO Auto-generated method stub
		if (this.mssv < student.mssv) {
			return 1;
		} else {
			return -1;
		}
	}

}
