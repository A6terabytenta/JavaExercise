package map.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) {
		Map map = new WeakHashMap();

		map.put(new String("Maine"), "Augusta");

	}
}
