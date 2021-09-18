package chap10;

import java.util.*;
public class CalendarEx4 {
	public static void main(String [] aRGS) {
		MyHelper h = null;
		Calendar d = Calendar.getInstance();
		d.set(2005, 7, 31);//2005.08.31
		
		System.out.println(h.toString(d));
		System.out.println("15 day after");
		d.add(Calendar.DATE, 15);
		System.out.println(h.toString(d));
		
		System.out.println("6 month ago");
		d.add(Calendar.MONTH, -6);
		System.out.println(h.toString(d));
		
		System.out.println("20일 후(roll)");
		d.roll(Calendar.DATE, 20);
		System.out.println(h.toString(d));
		
		System.out.println("31일 후 (add)");
		d.add(Calendar.DATE, 31);
		System.out.println(h.toString(d));
		
		
	}

}
