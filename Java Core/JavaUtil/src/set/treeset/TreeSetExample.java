package set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();

		treeSet.add("A");
		treeSet.add("C");
		treeSet.add("B");

		System.out.println(treeSet.size());

		System.out.println("Clone: " + treeSet.clone());

		System.out.println("Ceiling A: " + treeSet.ceiling("A"));

		System.out.println("Iterator");
		Iterator<String> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println("");
		System.out.println("toArray");
		String[] element = treeSet.toArray(new String[treeSet.size()]);

		for (String s : element) {
			System.out.print(s + " ");
		}

		// 3
		// Clone: [A, B, C]
		// Ceiling A: A
		// Iterator
		// A B C
		// toArray
		// A B C
	}
}
