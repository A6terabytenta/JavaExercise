package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		Date date = new Date();

		System.out.println("Date: " + date.getDate());
		System.out.println("Hours: " + date.getHours());
		System.out.println("Month: " + date.getMonth());
		System.out.println("Monutes: " + date.getMinutes());

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/M/yyyy");
		String date1 = sdf1.format(new Date());
		System.out.println(date1);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString2 = "31-08-1982 10:20:56";
		Date date2 = sdf2.parse(dateInString2);
		System.out.println(date2);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		Date date3 = new Date();
		System.out.println(dateFormat.format(date3));

		Calendar calendar = Calendar.getInstance();
		Date date4 = calendar.getTime();
		System.out.println(date4);

		// Date: 28
		// Hours: 11
		// Month: 0
		// Monutes: 27
		// 28/1/2016
		// Tue Aug 31 10:20:56 ICT 1982
		// 2016/01/28 11:27:51
		// Thu Jan 28 11:27:51 ICT 2016
	}
}
