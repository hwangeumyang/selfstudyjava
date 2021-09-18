package chap10;

import java.util.*;
import java.text.*;

public class DateFormatEx1 {
	public static void main(String [] args) {
		Date today = new Date();
		
//		SimpleDateFormat[] sdf = new SimpleDateFormat[9];
		List<SimpleDateFormat> sdf = new ArrayList<>();
		String [] formats = {"yyyy-MM-dd",
				"''yy년 MMM dd일 E요일",
				"yyyy-MM-dd HH:mm:ss.SSS",
				"yyyy-MM-dd hh:mm:ss a",
				"yy-MMMM-ddd, a h:m:s.SSS",
				"",
				"오늘은 올 해의 D번째 날입니다.",
				"오늘은 이 달의 d번째 날입니다",
				"오늘은 올 해의 w번째 주입니다.",
				"오늘은 이 달의 W번째 주입니다.",
				"오늘은 이 달의 F번째 E요일입니다."
				
		};
		
		for(int i=0; i<formats.length; ++i) {
//			sdf[i] = new SimpleDateFormat(formats[i]);
			sdf.add(new SimpleDateFormat(formats[i]));
		}
		
		for(SimpleDateFormat f : sdf) {
			System.out.println(f.format(today));
		}
		
	}
	

}
