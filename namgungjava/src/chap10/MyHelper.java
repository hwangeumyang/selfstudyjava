package chap10;

import java.util.Calendar;

public class MyHelper {
	public static String toString(Calendar date) {
		String output=null;

		output = date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH)+1) + "�� " +  date.get(Calendar.DATE) + "�� ";
		return output;		
	}
}
