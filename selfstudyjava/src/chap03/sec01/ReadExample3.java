package chap03.sec01;

import java.io.InputStream;
import java.io.FileInputStream;

public class ReadExample3 {
	
	public static void main(String [] args) throws Exception{
		
		InputStream is = new FileInputStream("c:/Temp/test3.db");
		
		int readByteNum;
		byte [] buffer = new byte[5];
		
		
		while(true) {
			readByteNum = is.read(buffer, 2, 3);
			if(readByteNum == -1) break;
			
			for(int i=0; i<buffer.length; ++i) System.out.println(buffer[i]);			
			
		}
		
		is.close();
		
		
		
		
		
	}

}
