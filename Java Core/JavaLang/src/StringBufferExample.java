/**
 * @author TA
 *
 */
public class StringBufferExample {

	public static String append(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.append(s);
		return stringBuffer.toString();
	}

	public static String insert(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.insert(0, s);
		return stringBuffer.toString();
	}

	public static String replace(String text, String s) {
		StringBuffer stringBuffer = new StringBuffer(text);
		stringBuffer.replace(0, 5, s);
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

	public static void main(String[] args) {
		String text = " Hello ";
		String s = "Nguyen Tuan Anh";
		System.out.println("Append s to text: " + append(text, s));
		System.out.println("Insert s to text: " + insert(text, s));
		System.out.println("Capacity: " + capacity(text));
		System.out.println("SubString: " + subString(text, 1, 6));
	}
}
