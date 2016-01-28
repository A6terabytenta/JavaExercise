package set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkHashSetExample {
	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

		linkedHashSet.add("A");
		linkedHashSet.add("C");
		linkedHashSet.add("B");

		System.out.println(linkedHashSet.size());

		System.out.println("Clone: " + linkedHashSet.clone());

		System.out.println("Iterator");
		Iterator<String> iterator = linkedHashSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println("");
		System.out.println("toArray");
		String[] element = linkedHashSet.toArray(new String[linkedHashSet
				.size()]);

		for (String s : element) {
			System.out.print(s + " ");
		}
		
		// 3
		// Clone: [A, C, B]
		// Iterator
		// A C B
		// toArray
		// A C B
	}
}
