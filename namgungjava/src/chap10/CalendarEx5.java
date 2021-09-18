package chap10;

import java.util.*;

public class CalendarEx5 {
	public static void main(String []args) {
		Calendar c = Calendar.getInstance();
		
		c.set(2015, 0, 31);
		System.out.println(toString(c));
		c.roll(Calendar.MONTH,  1);
		System.out.println(toString(c));
		
		
		c.set(2015, 0, 31);
		System.out.println(toString(c));
		c.add(Calendar.MONTH,  1);
		System.out.println(toString(c));
		
		
	}
	public static String toString(Calendar c) {
		return MyHelper.toString(c);
	}
}
