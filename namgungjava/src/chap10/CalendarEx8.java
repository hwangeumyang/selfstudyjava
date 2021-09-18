package chap10;

public class CalendarEx8 {
	public static void main(String [] args) {
		String date1 = "201508";
		String date2 = "201405";
		
		int month1 = Integer.parseInt(date1.substring(0,4)) * 12 + Integer.parseInt(date1.substring(4,6));
		int month2 = Integer.parseInt(date2.substring(0,4)) * 12 + Integer.parseInt(date2.substring(4));
		
		System.out.printf("date1 - date2 : %d \n" , (int)(month1-month2));
		
	}
}
