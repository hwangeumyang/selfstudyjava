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
		//��¹��ۿ� ���� ��� ����Ʈ ���
		//�� ���������� flush()�� ��� �����ϰ� �����Ѵ�.
		os.close();
		
		
		
	}

}
