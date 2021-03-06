package map.treemap;

import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		treeMap.put(1, "A");
		treeMap.put(2, "B");
		treeMap.put(3, "C");

		for (int key : treeMap.keySet()) {
			System.out.println(key + ":" + treeMap.get(key));
		}

		System.out.println("Size: " + treeMap.size());

		System.out.println("Remove index 2: " + treeMap.remove(2));

		System.out.println("Is Empty: " + treeMap.isEmpty());

		System.out.println("Constains value D: " + treeMap.containsValue("D"));

		System.out.println("Constains value A: " + treeMap.containsValue("A"));

		System.out.println("Constains key 5: " + treeMap.containsKey(5));

		System.out
				.println("Ceiling Entry, key = 1: " + treeMap.ceilingEntry(1));
		System.out
				.println("Ceiling Entry, key = 5: " + treeMap.ceilingEntry(5));
		System.out.println("Ceiling Key = 1: " + treeMap.ceilingKey(1));

		System.out.println("Descending Key Set: " + treeMap.descendingKeySet());

		System.out.println("Descending Map: " + treeMap.descendingMap());

		System.out.println("Floor Entry: " + treeMap.floorEntry(1));

		System.out.println("Floor Key: " + treeMap.floorKey(1));

		System.out.println("Head Map: " + treeMap.headMap(1));

		System.out.println("Lower Entry: " + treeMap.lowerEntry(1));

		// 1:A
		// 2:B
		// 3:C
		// Size: 3
		// Remove index 2: B
		// Is Empty: false
		// Constains value D: false
		// Constains value A: true
		// Constains key 5: false
		// Ceiling Entry, key = 1: 1=A
		// Ceiling Entry, key = 5: null
		// Ceiling Key = 1: 1
		// Descending Key Set: [3, 1]
		// Descending Map: {3=C, 1=A}
		// Floor Entry: 1=A
		// Floor Key: 1
		// Head Map: {}
		// Lower Entry: null
	}
}
