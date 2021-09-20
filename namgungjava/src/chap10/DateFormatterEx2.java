package chap10;

import java.time.*;
import java.time.format.*;

public class DateFormatterEx2 {
	public static void main(String [] args ) {
		LocalDate newYear = LocalDate.parse("2016-01-01", DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println(LocalDate.parse("2001-01-01"));
		System.out.println(LocalTime.parse("23:59:59"));
		System.out.println(LocalDateTime.parse("2001-01-01T23:59:59"));
		
		DateTimeFormatter pat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(LocalDateTime.parse("2015-12-31 23:59:59", pat));
	}

}
