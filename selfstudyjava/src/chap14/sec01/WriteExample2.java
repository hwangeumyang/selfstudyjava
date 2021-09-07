package chap14.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

//write(byte[] b) 테스트
//ABC
public class WriteExample2 {
	public static void main(String [] args) throws Exception{

		OutputStream os = new FileOutputStream("c:/Temp/test2.db");

		byte [] array = { 65, 0x42, 0103 };
		os.write(array);		
		
		
		
//		os.flush();
		//출력버퍼에 남은 모든 바이트 출력
		//현 예제에서는 flush()가 없어도 동일하게 동작한다.
		os.close();
		
		
		
	}

}
