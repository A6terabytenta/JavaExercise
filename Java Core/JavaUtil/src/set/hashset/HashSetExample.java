package set.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();

		hashSet.add("A");
		hashSet.add("C");
		hashSet.add("B");

		System.out.println(hashSet.size());

		System.out.println("Clone: " + hashSet.clone());

		System.out.println("Iterator");
		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println("");
		System.out.println("toArray");
		String[] element = hashSet.toArray(new String[hashSet.size()]);

		for (String s : element) {
			System.out.print(s + " ");
		}

		// 3
		// Clone: [A, B, C]
		// Iterator
		// A B C
		// toArray
		// A B C
	}
}
