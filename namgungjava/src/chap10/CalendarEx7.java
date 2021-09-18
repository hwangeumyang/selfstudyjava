package chap10;

import java.util.*;
public class CalendarEx7 {

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
		
		sDay.set(year, month-1, 1);;
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));
		
		sDay.add(Calendar.DATE,  -sDay.get(Calendar.DAY_OF_WEEK)+1);
		eDay.add(Calendar.DATE, 7-eDay.get(Calendar.DAY_OF_WEEK));
		
		
		System.out.println(year + "년" + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		for(int i=1; sDay.before(eDay)||sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			System.out.print(((day<10) ? "  " : " ") + day);
			if(i++%7==0) System.out.println();
		}
		//-1하는대신 그냥 1을 나머지로 잡았다. START_DAY_OF_WEEK가 1~7이라 이렇게 된 것. 필연적으로 제일 처음부터 시작해도 1이 된다.
		
	}
}
