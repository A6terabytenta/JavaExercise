package map.hashmap;

import java.util.HashMap;

public class Database {
	public static HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	static {
		hashmap.put(1, "A");
		hashmap.put(2, "B");
		hashmap.put(3, "C");
	}
}
