package chap10;

import java.time.*;
import java.time.format.*;

public class DateFormatterEx1 {
	public static void main(String [] args) {
		ZonedDateTime zdateTime = ZonedDateTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",
				"''yy년 MMM dd일 E요일",
				"yyyy-MM-dd HH:mm:ss.SSS Z VV"
		};
		
		for(String p : patternArr) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter));
			System.out.println(ldt.format(formatter));
			
		}
		
	}

}
