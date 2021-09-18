package chap10;

import java.util.*;
public class CalendarEx2 {
	public static void main(String [] args) {
		//day of week
		final String [] DOW = {null, "일", "월", "화", "수", "목", "금", "토" };
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//month는 0부터
		//date1.set(2015, Calendar.AUGUST, 15); 도 가능
		date1.set(2015, 7, 15);
		System.out.println("date1은 " + toString(date1) + DOW[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
		System.out.println("date2은 " + toString(date2) + DOW[date2.get(Calendar.DAY_OF_WEEK)] + "요일");
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
		difference = difference/ (60*60*24);
		System.out.println(difference + "일 지났습니다");
		
		
	}
	
	public static String toString(Calendar date) {
		String output=null;

		output = date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH)+1) + "월 " +  date.get(Calendar.DATE) + "일 ";
		return output;		
	}

}
