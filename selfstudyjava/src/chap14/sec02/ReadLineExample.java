package chap14.sec02;

import java.io.*;
public class ReadLineExample {
	public static void main(String [] args) throws Exception{
		Reader reader = new FileReader(
				ReadLineExample.class.getResource("language.txt").getPath()
				);
		BufferedReader br = new BufferedReader(reader);
		
		String data;
		while( (data = br.readLine()) != null) System.out.println(data);
		
		br.close();
		
	}
	
	

}
