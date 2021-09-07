package chap14.sec02.verify;

import java.io.BufferedReader;
import java.io.FileReader;

public class AddLineNumberExample {
	public static void main(String [] args) throws Exception {
		String fp = "src/chap13/sec02/verify/AddLineNumberExample.java";
		
		FileReader reader = new FileReader(fp);
		BufferedReader br = new BufferedReader(reader);
		
		long s, e;
		s = System.nanoTime();
		
		
		StringBuilder outputline;
//		String output;
		String line;
		int linenum=1;
		
		while((line = br.readLine()) != null) {
			outputline = new StringBuilder(linenum++ + ": " +line);
//			output = linenum++ + ": " + line;
			System.out.println(outputline);
//			System.out.println(output);
		}
		e = System.nanoTime();
		
		
//		System.out.println(e - s);
		br.close();
	}

}
