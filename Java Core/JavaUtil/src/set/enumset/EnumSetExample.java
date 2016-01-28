package set.enumset;

import java.util.EnumSet;

public class EnumSetExample {
	public enum Numbers {

		ONE, TWO, THREE, FOUR, FIVE
	};

	static EnumSet<Numbers> set;

	public static void main(String[] args) {

		Numbers[] list = { Numbers.ONE, Numbers.THREE, Numbers.FOUR,
				Numbers.FIVE };

		main4(list);

		// Set:[ONE, TWO, THREE]

	}

	public static void main2(Numbers[] fakeargs) {

		set = EnumSet.of(Numbers.ONE, fakeargs);

		System.out.println("Set:" + set);

	}

	public static void main3(Numbers[] fakeargs) {

		set = EnumSet.of(Numbers.ONE, Numbers.THREE);

		System.out.println("Set:" + set);

	}

	public static void main4(Numbers[] fakeargs) {

		set = EnumSet.of(Numbers.ONE, Numbers.THREE, Numbers.TWO);

		System.out.println("Set:" + set);

	}
}
