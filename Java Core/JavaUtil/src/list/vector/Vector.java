package list.vector;

import java.util.ArrayList;
import java.util.Iterator;

public class Vector implements ListInterface {
	java.util.Vector<String> list = Database.vector;

	@Override
	public java.util.Vector<String> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public boolean contains(String object) {
		// TODO Auto-generated method stub
		return list.contains(object);
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		Iterator<String> iterator = list.iterator();
		return iterator;
	}

	@Override
	public String[] toArray() {
		// TODO Auto-generated method stub
		return list.toArray(new String[list.size()]);
	}

	@Override
	public boolean add(String object) {
		// TODO Auto-generated method stub
		return list.add(object);
	}

	@Override
	public boolean remove(String object) {
		// TODO Auto-generated method stub
		return list.remove(object);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

	@Override
	public String set(int index, String object) {
		// TODO Auto-generated method stub
		list.set(index, object);
		return list.get(index);
	}

	@Override
	public int lastIndexOf(String object) {
		// TODO Auto-generated method stub
		return list.lastIndexOf(object);
	}

	public static void main(String[] args) {
		Vector vector = new Vector();
		System.out.println(vector.list);

		System.out.println("Size: " + vector.size());

		System.out.println("Is Emplty: " + vector.isEmpty());

		System.out.println("Contains: " + vector.contains("A"));

		System.out.println("Iterator: " + vector.iterator());

		System.out.println("To Array: " + vector.toArray());

		System.out.println("Add D: " + vector.add("D"));
		System.out.println("Add A: " + vector.add("A"));

		System.out.println(vector.getList());

		System.out.println("Remove A: " + vector.remove("A"));

		System.out.println(vector.getList());

		System.out.println("set 1 E: " + vector.set(1, "E"));

		System.out.println(vector.getList());

		System.out.println("Clone: " + vector.getList().clone());

		System.out.println("Capacity: " + vector.getList().capacity());

		System.out.println("Element At 2: " + vector.getList().elementAt(2));

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("E");
		System.out.println("RetainAll: "
				+ vector.getList().retainAll(arrayList));
		System.out.println(vector.getList());

		// [A, B, C]
		// Size: 3
		// Is Emplty: false
		// Contains: true
		// Iterator: java.util.Vector$Itr@1b701da1
		// To Array: [Ljava.lang.String;@726f3b58
		// Add D: true
		// Add A: true
		// [A, B, C, D, A]
		// Remove A: true
		// [B, C, D, A]
		// set 1 E: E
		// [B, E, D, A]
		// Clone: [B, E, D, A]
		// Capacity: 10
		// Element At 2: D
		// RetainAll: true
		// [E, A]
	}
}
