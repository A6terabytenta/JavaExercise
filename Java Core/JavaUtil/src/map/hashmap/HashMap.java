package map.hashmap;

import java.util.Map;
import java.util.Set;

public class HashMap implements MapInterface {
	java.util.HashMap<Integer, String> map = Database.hashmap;

	public HashMap() {
		super();
	}

	@Override
	public java.util.HashMap<Integer, String> getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}

	@Override
	public boolean containsKey(int k) {
		// TODO Auto-generated method stub
		return map.containsKey(k);
	}

	@Override
	public boolean containsValue(String value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	@Override
	public Set<Map<Integer, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		return map.equals(map);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	@Override
	public Set<Integer> keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@Override
	public String put(int key, String value) {
		// TODO Auto-generated method stub
		return map.put(key, value);
	}

	@Override
	public void putAll(Map<Integer, String> m) {
		// TODO Auto-generated method stub
		map.putAll(m);
	}

	@Override
	public String remove(int k) {
		// TODO Auto-generated method stub
		return map.remove(k);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();

		System.out.println(map.getMap());

		System.out.println("keySet: " + map.keySet());

		java.util.HashMap<Integer, String> hm = new java.util.HashMap<Integer, String>();
		hm.put(5, "C");
		map.putAll(hm);
		System.out.println("putAll:" + map.getMap());

		System.out.println("Size: " + map.size());

		System.out.println("Remove value: " + map.remove(1));

		System.out.println("Is Empty: " + map.isEmpty());

		System.out.println("Constains value D: " + map.containsValue("D"));

		System.out.println("Constains value A: " + map.containsValue("A"));

		System.out.println("Constains key 5: " + map.containsKey(5));

		// {1=A, 2=B, 3=C}
		// keySet: [1, 2, 3]
		// putAll:{1=A, 2=B, 3=C, 5=C}
		// Size: 4
		// Remove value: A
		// Is Empty: false
		// Constains value D: false
		// Constains value A: false
		// Constains key 5: true
	}
}
