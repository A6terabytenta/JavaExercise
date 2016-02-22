package properties;

import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		Properties properties = new Properties();

		properties.setProperty("1", "A");
		properties.setProperty("2", "B");
		properties.setProperty("3", "C");

		System.out.println(properties.entrySet());

		System.out.println("Is Emplty: " + properties.isEmpty());

		System.out.println("Clone: " + properties.clone());

		System.out.println("Contains Object A: " + properties.contains("A"));

		System.out.println("Contains Key 1: " + properties.containsKey("1"));

		System.out
				.println("Contains Value A: " + properties.containsValue("A"));

		System.out.println("Key Set: " + properties.keySet());

		System.out.println("Remove object 1: " + properties.remove("1"));

		System.out.println("Entry Set: " + properties.entrySet());

		System.out.println("Get property at index 2: "
				+ properties.getProperty("2"));

		// [3=C, 2=B, 1=A]
		// Is Emplty: false
		// Clone: {3=C, 2=B, 1=A}
		// Contains Object A: true
		// Contains Key 1: true
		// Contains Value A: true
		// Key Set: [3, 2, 1]
		// Remove object 1: A
		// Entry Set: [3=C, 2=B]
		// Get property at index 2: B
	}
}
