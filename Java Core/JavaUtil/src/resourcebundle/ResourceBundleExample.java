package resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {
	public static void main(String[] args) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageBundle", Locale.US);
		System.out.println("Message in: " + Locale.US + ":" + resourceBundle.getString("name"));

		Locale.setDefault(new Locale("in", "ID"));
		resourceBundle = ResourceBundle.getBundle("DemoRB");
		System.out.println("Message in: " + Locale.US + ":" + resourceBundle.getString("name"));
	}
}
