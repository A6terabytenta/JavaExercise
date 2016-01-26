public class StringBuilderExample {
	public static String append(String text, String s) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.append(s);
		return stringBuilder.toString();
	}

	public static String insert(String text, String s) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.insert(0, s);
		return stringBuilder.toString();
	}

	public static String replace(String text, String s) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.replace(0, 5, s);
		return stringBuilder.toString();
	}

	public static String reverse(String text) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}

	public static String subString(String text, int beginIndex) {
		StringBuilder stringBuilder = new StringBuilder(text);
		return stringBuilder.substring(beginIndex).toString();
	}
	public static String delete(String text, int startIndex, int endIndex) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.delete(startIndex, endIndex);
		return stringBuilder.toString();
	}

	public static String deleteChartAt(String text, int index) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.deleteCharAt(index);
		return stringBuilder.toString();
	}

	public static char chartAt(String text, int index) {
		StringBuilder stringBuilder = new StringBuilder(text);
		return stringBuilder.charAt(index);
	}
	public static void main(String[] args) {
		String text = " Hello ";
		String s = "Nguyen Tuan Anh";
		System.out.println("Append s to text: " + append(text, s));
		System.out.println("Insert s to text: " + insert(text, s));
		System.out.println("Replace s to text: " + replace(text, s));
		System.out.println("Reverse text: " + reverse(text));
		System.out.println("SubString: " + subString(text, 3));
		System.out.println("Delete text with start index 1 and end index 3: " + delete(text, 1, 3));
		System.out.println("Delete charactor at index 2: " + deleteChartAt(text, 2));
		System.out.println("Chart at index 2: " + chartAt(text, 2));
	}
}
