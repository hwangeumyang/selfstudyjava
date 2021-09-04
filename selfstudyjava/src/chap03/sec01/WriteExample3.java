package chap03.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

//write(byte[] b, int off, int len) 테스트
//20, 30, 40
public class WriteExample3 {
	public static void main(String [] args) throws Exception{

		OutputStream os = new FileOutputStream("c:/Temp/test3.db");

		byte [] array = { 10, 20, 30, 40, 50};
		os.write(array, 1, 3);		
		
//		os.flush();
		//출력버퍼에 남은 모든 바이트 출력
		//현 예제에서는 flush()가 없어도 동일하게 동작한다.
		os.close();
		
	}

}
