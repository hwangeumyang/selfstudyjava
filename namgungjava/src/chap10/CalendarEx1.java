package chap10;

import java.util.*;

public class CalendarEx1 {
	
	public static void main(String [] args) {
		Calendar today = Calendar.getInstance();
		
		System.out.println("올해 년도: " + today.get(Calendar.YEAR));
		System.out.println("월(0~11): " + today.get(Calendar.MONTH));
		System.out.println("이 해 몇째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇째 주: " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 달의 며칠: " + today.get(Calendar.DATE) );
		System.out.println("이 달의 며칠: " + today.get(Calendar.DAY_OF_MONTH) );
		System.out.println("이 해의 며칠 : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1: 일요일): "+ today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇째 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전 0, 오후 1 : " + today.get(Calendar.AM_PM));
		System.out.println("시간 0~11 : " + today.get(Calendar.HOUR));
		System.out.println("시간 0~23 : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 0~59  : " + today.get(Calendar.MINUTE));
		System.out.println("초 0~59: " + today.get(Calendar.SECOND));
		System.out.println("1/1000초 0~999: " + today.get(Calendar.MILLISECOND));
		//밀리 세컨드라 시간을 나눠서 시간을 표기
		System.out.println("TimeZone(-12~+12): " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE));
		
	}

}
