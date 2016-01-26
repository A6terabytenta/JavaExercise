package map.hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTable implements MapInterface {
	Hashtable<Integer, String> hashtable = Database.hashtable;

	@Override
	public Hashtable<Integer, String> getMap() {
		// TODO Auto-generated method stub
		return hashtable;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		hashtable.clear();
	}

	@Override
	public boolean containsKey(int k) {
		// TODO Auto-generated method stub
		return hashtable.containsKey(k);
	}

	@Override
	public boolean containsValue(String value) {
		// TODO Auto-generated method stub
		return hashtable.containsValue(value);
	}

	@Override
	public Set<Map<Integer, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		return hashtable.equals(map);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return hashtable.isEmpty();
	}

	@Override
	public Set<Integer> keySet() {
		// TODO Auto-generated method stub
		return hashtable.keySet();
	}

	@Override
	public String put(int key, String value) {
		// TODO Auto-generated method stub
		return hashtable.put(key, value);
	}

	@Override
	public void putAll(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		hashtable.putAll(map);
	}

	@Override
	public String remove(int k) {
		// TODO Auto-generated method stub
		return hashtable.remove(k);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return hashtable.size();
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();

		System.out.println("Hashtable: " + hashTable.getMap());

		System.out.println("PUT 3-D:" + hashTable.put(3, "D"));

		System.out.println("Hashtable: " + hashTable.getMap());

		System.out.println("Remove value: " + hashTable.remove(1));

		System.out.println("Is Empty: " + hashTable.isEmpty());

		System.out.println("Constains value D: " + hashTable.containsValue("D"));

		System.out.println("Constains value A: " + hashTable.containsValue("A"));

		System.out.println("Constains key 5: " + hashTable.containsKey(5));
	}

}
