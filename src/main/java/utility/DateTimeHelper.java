package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {

	/**
	 * This method is used to get the current date and time based on
	 * @return
	 */
	public static String getCurrentDateTime()
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		Calendar cal=Calendar.getInstance();
		String time=""+sdf.format(cal.getTime());
		System.out.println(time);
		return time;
	}
	
	public static String getCurrentDate()
	{
		String currentDate=getCurrentDateTime().substring(0, 10);
		System.out.println(currentDate);
		return currentDate;
	}
	
	public static void main(String[] args) 
	{
		DateTimeHelper ref= new DateTimeHelper();
		ref.getCurrentDateTime();
		ref.getCurrentDate();
	}
}
