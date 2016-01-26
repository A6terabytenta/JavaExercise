package map.hashtable;

import java.util.Hashtable;

public class Database {
	public static Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
	static {
		hashtable.put(1, "A");
		hashtable.put(2, "B");
		hashtable.put(3, "C");
	}
}
