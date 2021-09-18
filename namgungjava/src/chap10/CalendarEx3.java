package chap10;

import java.util.*;

public class CalendarEx3 {
	public static void main(String [] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_UNIT_NAME = {"�ð�", "��", "��"};
		
		Calendar c=null;
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(Calendar.HOUR_OF_DAY, 10);
		cal1.set(Calendar.MINUTE, 20);
		cal1.set(Calendar.SECOND, 30);
		
		cal2.set(Calendar.HOUR_OF_DAY, 20);
		cal2.set(Calendar.MINUTE, 30);
		cal2.set(Calendar.SECOND, 10);
		
		System.out.println("cal1 " + cal1.get(Calendar.HOUR_OF_DAY)+"�� " +cal1.get(c.MINUTE)+"�� " + cal1.get(c.SECOND) +"��");
		System.out.println("cal2 " + cal2.get(Calendar.HOUR_OF_DAY)+"�� " +cal2.get(c.MINUTE)+"�� " + cal2.get(c.SECOND) +"��");
		
		long gap = Math.abs(cal2.getTimeInMillis() - cal1.getTimeInMillis());
		gap /= 1000;
		System.out.println("�� �ð����̴�" + gap + "���Դϴ�");

		String tmp = "";
		for(int i=0; i<TIME_UNIT.length; ++i) {
			tmp += gap/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			gap %= TIME_UNIT[i];

		}
		
		System.out.println(tmp);
		
		
	}
}
