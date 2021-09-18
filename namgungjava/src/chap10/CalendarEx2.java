package chap10;

import java.util.*;
public class CalendarEx2 {
	public static void main(String [] args) {
		//day of week
		final String [] DOW = {null, "��", "��", "ȭ", "��", "��", "��", "��" };
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//month�� 0����
		//date1.set(2015, Calendar.AUGUST, 15); �� ����
		date1.set(2015, 7, 15);
		System.out.println("date1�� " + toString(date1) + DOW[date1.get(Calendar.DAY_OF_WEEK)] + "����");
		System.out.println("date2�� " + toString(date2) + DOW[date2.get(Calendar.DAY_OF_WEEK)] + "����");
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("�� ��(date1)���� ����(date2)���� " + difference + "�ʰ� �������ϴ�.");
		difference = difference/ (60*60*24);
		System.out.println(difference + "�� �������ϴ�");
		
		
	}
	
	public static String toString(Calendar date) {
		String output=null;

		output = date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH)+1) + "�� " +  date.get(Calendar.DATE) + "�� ";
		return output;		
	}

}
