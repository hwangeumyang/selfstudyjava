package chap13.sec02;

import java.io.*;
public class DataInputOutputStreamExample {
	static DataOutputStream os;
	public static void main(String [] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/primitive.db");
		DataOutputStream dos = new DataOutputStream(fos);
		
		os = dos;
		
		write("ȫ�浿", 95.5, 1);
		write("���ڹ�", 90.3, 2);
		os.writeInt(2);
		os.writeInt(3);
		os.writeInt(0b00111111111100000000000000000000); //������ 0�� ������ 20bit�̴�,���� 1�� ���� 10�� / 0�� ���� 2�� 32��Ʈ 
		os.writeInt(0);
		os.flush();
		os.close();
		
		FileInputStream fis = new FileInputStream("C:/temp/primitive.db");
		DataInputStream dis = new DataInputStream(fis);
		
		for(int i=0; i<2; ++i) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.printf("%s, %.1f, %d\n", name, score, order);
		}
		
		System.out.println(dis.readInt());
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		dis.close();
		
	}
	static void write(String name, double d, int i) throws Exception {
		os.writeUTF(name);
		os.writeDouble(d);
		os.writeInt(i);
	}

}
