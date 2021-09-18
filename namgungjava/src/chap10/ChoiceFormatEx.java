package chap10;

import java.text.*;

public class ChoiceFormatEx {
	
	public static void main(String [] args) {
		double [] limits = {60, 70, 80, 90};
		String[] grades = { "D", "C", "B", "A"};
		int [] scores = {100, 95, 91, 90, 88, 70, 52, 60, -20};
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		for(int score : scores) {
			System.out.println(score + " : " + form.format(score));
		}
		
		System.out.println("========================");
		
		String pat = "60#D|70#C|80<B|90#A";
		form = new ChoiceFormat(pat);
		
		for(int score : scores) {
			System.out.println(score + " : " + form.format(score));
		}
		
	}

	
}
