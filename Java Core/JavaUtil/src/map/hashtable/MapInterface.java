package map.hashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public interface MapInterface {
	public Hashtable<Integer, String> getMap();

	public void clear();

	public boolean containsKey(int k);

	public boolean containsValue(String value);

	public Set<Map<Integer, String>> entrySet();

	public boolean equals(Map<Integer, String> map);

	public int hashCode();

	public boolean isEmpty();

	public Set<Integer> keySet();

	public String put(int key, String value);

	public void putAll(Map<Integer, String> map);

	public String remove(int k);

	public int size();
}
