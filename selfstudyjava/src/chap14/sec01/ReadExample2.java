package chap14.sec01;

import java.io.InputStream;
import java.io.FileInputStream;

public class ReadExample2 {

	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("c:/Temp/test2.db");
		
		int readByteNum;
		byte[] buffer = new byte[100];
		
		while(true) {
			readByteNum = is.read(buffer);
			if(readByteNum == -1) break;
			for(int i=0; i<readByteNum; ++i) {
				System.out.println(buffer[i]);
			}
		}
		
		is.close();
		

	}

}
