package map.hashmap;

import java.util.HashMap;

public class ConstructorExample {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		for (int i = 0; i < 10; i++) {
			hashMap.put(i, String.valueOf(i));
		}

		HashMap<Integer, String> hashMap1 = new HashMap<Integer, String>(
				hashMap);

		System.out.println("HashTable1: " + hashMap1);

		// HashTable1: {0=0, 1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9}
	}
}
