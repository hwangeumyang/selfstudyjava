package chap10;

import java.util.*;
public class CalendarEx6 {

	public static void main(String [] args) {
		
		Scanner s = new Scanner(System.in);
		
		String[] input;
		int year;
		int month;
		try {
			input = s.nextLine().split(" ");
			year = Integer.parseInt(input[0]);
			month = Integer.parseInt(input[1]);
		} catch(Exception e) {
			System.out.println("usage: 2015 9");
			return;
		}
		
		int START_DAY_OF_WEEK = 0;
		int END_DAY  = 0;
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		sDay.set(year, month-1,1);;
		eDay.set(year, month, 1);
		
		//9.1~9.30
		eDay.add(Calendar.DATE, -1);
		
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println(year + "��" + month + "��");
		
		System.out.println(" SU MO TU WE TH FR SA");
		for(int i=1; i< START_DAY_OF_WEEK; ++i) System.out.print("   ");
		for(int i=1; i<= END_DAY; ++i) {
			System.out.print(((i<10) ? "  " : " ") + i);
			if((i+START_DAY_OF_WEEK)%7==1)System.out.println();
		}
		//-1�ϴ´�� �׳� 1�� �������� ��Ҵ�. START_DAY_OF_WEEK�� 1~7�̶� �̷��� �� ��. �ʿ������� ���� ó������ �����ص� 1�� �ȴ�.
		
	}
}
