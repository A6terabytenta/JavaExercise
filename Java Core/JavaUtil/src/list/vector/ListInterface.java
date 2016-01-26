package list.vector;

import java.util.Iterator;
import java.util.Vector;

public interface ListInterface {

	public Vector<String> getList();

	public int size();

	public boolean isEmpty();

	public boolean contains(String object);

	public Iterator<String> iterator();

	public String[] toArray();

	public boolean add(String object);

	public boolean remove(String object);

	public void clear();

	public String get(int index);

	public String set(int index, String object);

	public int lastIndexOf(String object);
}
