package list.arraylist;

import java.util.ArrayList;

public class ConstructorExample {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i <= 11; i++) {
			arrayList.add(i);
		}
		System.out.println("arrayList: " + arrayList);

		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(arrayList);

		System.out.println("arrayList2: " + arrayList2);
	}
	// arrayList: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
	// arrayList2: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

}
