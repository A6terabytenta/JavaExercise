package map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LHMap {
	public static void main(String[] args) {
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

		linkedHashMap.put(1, "A");
		linkedHashMap.put(2, "B");
		linkedHashMap.put(3, "C");

		for (int key : linkedHashMap.keySet()) {
			System.out.println(key + ":" + linkedHashMap.get(key));
		}

		System.out.println("Size: " + linkedHashMap.size());

		System.out.println("Remove index 2: " + linkedHashMap.remove(2));

		System.out.println("Is Empty: " + linkedHashMap.isEmpty());

		System.out.println("Constains value D: " + linkedHashMap.containsValue("D"));

		System.out.println("Constains value A: " + linkedHashMap.containsValue("A"));

		System.out.println("Constains key 5: " + linkedHashMap.containsKey(5));
	}
}
