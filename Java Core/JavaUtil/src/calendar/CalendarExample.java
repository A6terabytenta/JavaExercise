package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarExample {
	public static void main(String[] args) {
		System.out.println("Date: " + Calendar.DATE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(Locale.US);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("dayOfMonth: " + dayOfMonth);
		System.out.println("dayOfWeek: " + dayOfWeek);
		System.out.println("weekOfYear: " + weekOfYear);
		System.out.println("weekOfMonth: " + weekOfMonth);
		System.out.println("hour: " + hour);
		System.out.println("hourOfDay: " + hourOfDay);
		System.out.println("minute: " + minute);
		System.out.println("second: " + second);
		System.out.println("millisecond: " + millisecond);

		// Date: 5
		// 2016 Jan 28 11:28:16
		// year: 2016
		// month: 0
		// dayOfMonth: 28
		// dayOfWeek: 5
		// weekOfYear: 5
		// weekOfMonth: 5
		// hour: 11
		// hourOfDay: 11
		// minute: 28
		// second: 16
		// millisecond: 887

	}
}
