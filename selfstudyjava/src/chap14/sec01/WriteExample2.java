package chap14.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

//write(byte[] b) �׽�Ʈ
//ABC
public class WriteExample2 {
	public static void main(String [] args) throws Exception{

		OutputStream os = new FileOutputStream("c:/Temp/test2.db");

		byte [] array = { 65, 0x42, 0103 };
		os.write(array);		
		
		
		
//		os.flush();
		//��¹��ۿ� ���� ��� ����Ʈ ���
		//�� ���������� flush()�� ��� �����ϰ� �����Ѵ�.
		os.close();
		
		
		
	}

}
