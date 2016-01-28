package list.vector;

import java.util.Vector;

public class ConstructorExample {
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();

		Vector<Integer> vector1 = new Vector<Integer>(10);

		Vector<Integer> vecto2 = new Vector<Integer>(10, 2);

		Vector<Integer> vecto3 = new Vector<Integer>(vector);

	}
}
