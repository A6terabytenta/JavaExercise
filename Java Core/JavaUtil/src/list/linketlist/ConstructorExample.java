package list.linketlist;

import java.util.LinkedList;

public class ConstructorExample {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		LinkedList<Integer> linkedList2 = new LinkedList<Integer>(linkedList);
		System.out.println("linkedList2: " + linkedList2);

	}
	// linkedList2: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
}
