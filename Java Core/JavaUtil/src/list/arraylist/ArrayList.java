package list.arraylist;

import java.util.Iterator;
import java.util.List;

public class ArrayList implements ListInterface {
	public List<String> list = Database.arrayList;

	public ArrayList() {
	}

	@Override
	public List<String> getList() {
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
		ArrayList arrayList = new ArrayList();
		System.out.println(arrayList.list);

		System.out.println("Size: " + arrayList.size());

		System.out.println("Is Emplty: " + arrayList.isEmpty());

		System.out.println("Contains: " + arrayList.contains("A"));

		System.out.println("Iterator: " + arrayList.iterator());

		System.out.println("To Array: " + arrayList.toArray());

		System.out.println("Add D: " + arrayList.add("D"));

		System.out.println(arrayList.getList());

		System.out.println("Remove A: " + arrayList.remove("A"));

		System.out.println(arrayList.getList());

		System.out.println("set 1 E: " + arrayList.set(1, "E"));

		System.out.println(arrayList.getList());
	}

}
