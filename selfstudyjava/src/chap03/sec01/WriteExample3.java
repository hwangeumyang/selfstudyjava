package chap03.sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

//write(byte[] b, int off, int len) �׽�Ʈ
//20, 30, 40
public class WriteExample3 {
	public static void main(String [] args) throws Exception{

		OutputStream os = new FileOutputStream("c:/Temp/test3.db");

		byte [] array = { 10, 20, 30, 40, 50};
		os.write(array, 1, 3);		
		
//		os.flush();
		//��¹��ۿ� ���� ��� ����Ʈ ���
		//�� ���������� flush()�� ��� �����ϰ� �����Ѵ�.
		os.close();
		
	}

}
