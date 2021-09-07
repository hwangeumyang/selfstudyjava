package chap14.sec01;

import java.io.Reader;
import java.io.FileReader;

public class ReadExample4 {
	
	public static void main(String [] args) throws Exception {
		
		Reader reader = new FileReader("c:/temp/test7.txt");
		int c = 0;
		while(true) {
			char data = (char)reader.read();
			if(data == -1) break;
//			System.out.println((int)data);
			System.out.println(data);
			
			if(c++>6)break;
			
		}
		
		reader.close();
		
		
		
	}

}
