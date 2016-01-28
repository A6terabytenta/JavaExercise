package map.enummap;

import java.util.EnumMap;

public class Enum {
	public enum STATE {
		NEW, PAUSE, RESUME, END
	}

	public static void main(String[] args) {
		EnumMap<STATE, String> enumMap = new EnumMap<STATE, String>(STATE.class);

		enumMap.put(STATE.NEW, "New game!");
		enumMap.put(STATE.PAUSE, "Pause game!");
		enumMap.put(STATE.RESUME, "Resume game!");
		enumMap.put(STATE.END, "End game!");

		System.out.println(enumMap);
		System.out.println("Size: " + enumMap.size());
		System.out.println("Is Empty: " + enumMap.isEmpty());
		System.out
				.println("Get index STATE.PAUSE: " + enumMap.get(STATE.PAUSE));
		System.out.println("Contains key: STATE.NEW: "
				+ enumMap.containsKey(STATE.NEW));
		System.out.println("Contains valye: End game!: "
				+ enumMap.containsValue("End game!"));

		EnumMap<STATE, String> enumMap1 = new EnumMap<STATE, String>(enumMap);
		System.out.println("EnumMap1: " + enumMap1);
		
		
//		Is Empty: false
//		Get index STATE.PAUSE: Pause game!
//		Contains key: STATE.NEW: true
//		Contains valye: End game!: true
//		EnumMap1: {NEW=New game!, PAUSE=Pause game!, RESUME=Resume game!, END=End game!}
	}
}
