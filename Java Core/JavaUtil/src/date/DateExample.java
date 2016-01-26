package date;

import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date date = new Date();

		System.out.println("Date: " + date.getDate());
		System.out.println("Hours: " + date.getHours());
		System.out.println("Month: " + date.getMonth());
		System.out.println("Monutes: " + date.getMinutes());
		
	}
}
