/**
 * @author TA
 *
 */
public class StringBufferExample {
	
	/**
	 * @author TA
	 * @param text
	 * @param s
	 * @return
	 */
	public static String append(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.append(s);
		return stringBuffer.toString();
	}
	
	/**
	 * @author TA
	 * @param text
	 * @param index
	 * @return
	 */
	public static int codePointAt(String text, int index) {
		StringBuffer stringBuffer = new StringBuffer(text);
		return stringBuffer.codePointAt(index);
	}
	
	/**
	 * @author TA
	 * @param text
	 * @param s
	 * @return
	 */
	public static String insert(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.insert(0, s);
		return stringBuffer.toString();
	}
	
	/**
	 * @author TA
	 * @param text
	 * @param s
	 * @return
	 */
	public static String replace(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.replace(0, 2, s);
		return stringBuffer.toString();
	}

	public static String reverse(String text) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.reverse();
		return stringBuffer.toString();
	}

	public static int capacity(String text) {
		StringBuffer stringBuffer = new StringBuffer(text);
		return stringBuffer.capacity();
	}

	public static String subString(String text, int start, int end) {
		StringBuffer stringBuffer = new StringBuffer(text);
		return stringBuffer.substring(start, end);
	}

	public static String delete(String text, int startIndex, int endIndex) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.delete(startIndex, endIndex);
		return stringBuffer.toString();
	}

	public static String deleteChartAt(String text, int index) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.deleteCharAt(index);
		return stringBuffer.toString();
	}

	public static char chartAt(String text, int index) {
		StringBuffer stringBuffer = new StringBuffer(text);
		return stringBuffer.charAt(index);
	}

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("TEST");

		String text = " Hello ";
		String s = "Nguyen Tuan Anh";

		System.out.println(buffer.toString());

		System.out.println("Append s to text: " + append(text, s));
		System.out.println("Insert s to text: " + insert(text, s));
		System.out.println("Replace s to text: " + replace(text, s));
		System.out.println("Reverse text: " + reverse(text));
		System.out.println("Capacity: " + capacity(text));
		System.out.println("SubString: " + subString(text, 1, 6));
		System.out.println("Delete text with start index 1 and end index 3: "
				+ delete(text, 1, 3));
		System.out.println("Delete charactor at index 2: "
				+ deleteChartAt(text, 2));
		System.out.println("Chart at index 2: " + chartAt(text, 2));
		System.out.println("Code point at index 2: " + codePointAt(text, 2));
	}
}
