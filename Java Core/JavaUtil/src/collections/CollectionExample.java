package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionExample {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Nguyen Tuan Anh");
		Student s2 = new Student(2, "Vo Tan Loc");

		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);

		System.out.println(list);

		Collections.sort(list);

		System.out.println(list);

		// [1: Nguyen Tuan Anh, 2: Vo Tan Loc]
		// [2: Vo Tan Loc, 1: Nguyen Tuan Anh]
	}
}
