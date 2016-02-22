import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>(10);

		ArrayList<String> arrayList2 = null;
		arrayList.addAll(1, arrayList2);
	}
}
