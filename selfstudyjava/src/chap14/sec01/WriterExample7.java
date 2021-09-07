package chap14.sec01;

import java.io.*;

public class WriterExample7 {

	public static void main(String[] args) {
		String str = "Hello";
		
		
		try {
			Writer writer = new FileWriter("c:/temp/test10.txt");
			
			writer.write(str);
			
			writer.flush();
			writer.close();
			
			
		} catch(IOException e) {
			
		}
		

	}

}
