package chap10;

import java.util.*;
import java.text.*;

//cla->date->formatting
//parse�� ���



public class DateFormatEx3 {
	public static void main(String [] args) {
		//Ex2�� ����
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005,  9, 3);
		Date date = cal.getTime();
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		
		
		
		
		DateFormat df =  new SimpleDateFormat("yyyy�� M�� d��");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015�� 11�� 23��");
			System.out.println(df2.format(d));
			
		}catch(Exception e) {}
		
	}

}
