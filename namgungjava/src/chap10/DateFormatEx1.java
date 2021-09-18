package chap10;

import java.util.*;
import java.text.*;

public class DateFormatEx1 {
	public static void main(String [] args) {
		Date today = new Date();
		
//		SimpleDateFormat[] sdf = new SimpleDateFormat[9];
		List<SimpleDateFormat> sdf = new ArrayList<>();
		String [] formats = {"yyyy-MM-dd",
				"''yy�� MMM dd�� E����",
				"yyyy-MM-dd HH:mm:ss.SSS",
				"yyyy-MM-dd hh:mm:ss a",
				"yy-MMMM-ddd, a h:m:s.SSS",
				"",
				"������ �� ���� D��° ���Դϴ�.",
				"������ �� ���� d��° ���Դϴ�",
				"������ �� ���� w��° ���Դϴ�.",
				"������ �� ���� W��° ���Դϴ�.",
				"������ �� ���� F��° E�����Դϴ�."
				
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
