package chap03.sec01;

import java.io.Reader;
import java.io.FileReader;

public class ReadExample5 {
	public static void main(String [] args) throws Exception {
		Reader reader = new FileReader("c:/temp/test8.txt");
		
//		char readCharNum;
		int readCharNum;
		char [] buffer = new char[100];
		
		while(true) {
//			readCharNum = (char)reader.read(buffer);
			readCharNum = reader.read(buffer);
			
			if(readCharNum == -1) break;
			
			for(int i=0; i<readCharNum; ++i) System.out.println(buffer[i]);
			
			
			
		}
		
		reader.close();
		
		
	}
}
