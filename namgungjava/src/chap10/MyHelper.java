package chap10;

import java.util.Calendar;

public class MyHelper {
	public static String toString(Calendar date) {
		String output=null;

		output = date.get(Calendar.YEAR) + "³â " + (date.get(Calendar.MONTH)+1) + "¿ù " +  date.get(Calendar.DATE) + "ÀÏ ";
		return output;		
	}
}
