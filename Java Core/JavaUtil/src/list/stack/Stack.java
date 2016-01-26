package list.stack;

import java.util.Iterator;

public class Stack implements ListInterface {
	java.util.Stack<String> list = Database.stack;

	public Stack() {
		super();
	}

	@Override
	public java.util.Stack<String> getList() {
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
		Stack stack = new Stack();
		System.out.println(stack.list);

		System.out.println("Size: " + stack.size());

		System.out.println("Is Emplty: " + stack.isEmpty());

		System.out.println("Contains: " + stack.contains("A"));

		System.out.println("Iterator: " + stack.iterator());

		System.out.println("To Array: " + stack.toArray());

		System.out.println("Add D: " + stack.add("D"));
		System.out.println("Add A: " + stack.add("A"));

		System.out.println(stack.getList());

		System.out.println("Remove A: " + stack.remove("A"));

		System.out.println(stack.getList());

		System.out.println("set 1 E: " + stack.set(1, "E"));

		System.out.println(stack.getList());

		System.out.println("Stack: " + stack.getList());

		System.out.println("Push:" + stack.getList().push("D"));
		System.out.println("Stack: " + stack.getList());

		System.out.println("Pop: " + stack.getList().pop());
		System.out.println("Stack: " + stack.getList());

		System.out.println("Peek: " + stack.getList().peek());
		System.out.println("Stack: " + stack.getList());
	}
}
