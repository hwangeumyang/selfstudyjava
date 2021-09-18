package chap10;

import java.text.*;
public class DecimalFormatEx2 {
	public static void main(String [] a) {
		
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#,###E0");
		
		String src = "1,234,567.89";
		try {
			Number n = df.parse(src);
			System.out.println(src);
			
			double d = n.doubleValue();
			System.out.print(d + " ->");
			
			System.out.println(df2.format(n));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
