package chap10;

import java.time.*;
import java.time.temporal.*;

public class NewTimeEx1 {
	public static void main(String [] args) {
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		
		LocalDate birthDate = LocalDate.of(1992, 2, 20);
		LocalTime birthTime = LocalTime.of(3, 22);
		
		System.out.println("today = " + today);
		System.out.println("now = " + now);
		System.out.println("birthDate = " + birthDate);
		System.out.println("birthTime = " + birthTime);
		
		System.out.println(birthDate.withYear(2000));
		System.out.println(birthDate.plusDays(1));
		System.out.println(birthDate.plus(1, ChronoUnit.DAYS));
		
		System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS));
		System.out.println(birthTime);
		
		System.out.println(ChronoField.HOUR_OF_DAY.range());
		
				
		
		
		
	}
	
}
