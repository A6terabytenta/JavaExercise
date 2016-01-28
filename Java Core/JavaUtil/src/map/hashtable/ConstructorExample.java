package map.hashtable;

import java.util.Hashtable;

public class ConstructorExample {
	public static void main(String[] args) {
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

		for (int i = 4; i < 10; i++) {
			hashtable.put(i, "A");
		}
		hashtable.put(0, "A");
		hashtable.put(1, "A");
		System.out.println("hashtable: " + hashtable);
		Hashtable<Integer, String> hashtable1 = new Hashtable<Integer, String>(
				hashtable);

		System.out.println("hashtable1: " + hashtable1);

		// hashtable: {9=A, 8=A, 7=A, 6=A, 5=A, 4=A, 1=A, 0=A}
		// hashtable1: {9=A, 8=A, 7=A, 6=A, 5=A, 4=A, 1=A, 0=A}
	}
}
