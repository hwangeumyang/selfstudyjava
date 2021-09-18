package chap10;

import java.util.*;
import java.text.*;

//cla->date->formatting
//parse의 용법



public class DateFormatEx3 {
	public static void main(String [] args) {
		//Ex2의 내용
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005,  9, 3);
		Date date = cal.getTime();
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		
		
		
		
		DateFormat df =  new SimpleDateFormat("yyyy년 M월 d일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015년 11월 23일");
			System.out.println(df2.format(d));
			
		}catch(Exception e) {}
		
	}

}
