package chap03.sec01.exam01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String [] args) throws Exception{

		OutputStream os = new FileOutputStream("c:/Temp/test.db");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);		
		os.write(b);
		Thread.sleep(2000);
		os.write(c);
		
		
//		os.flush();
		//출력버퍼에 남은 모든 바이트 출력
		//현 예제에서는 flush()가 없어도 동일하게 동작한다.
		os.close();
		
		
		
	}

}
