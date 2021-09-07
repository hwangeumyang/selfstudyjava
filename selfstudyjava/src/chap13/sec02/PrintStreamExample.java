package chap13.sec02;

import java.io.*;

public class PrintStreamExample {
	public static void main(String [] args) throws Exception{
		String fp = "c:/temp/printstream.txt";//not pointer it's path!
		long start, end;
		
		for(int i=0; i<10; ++i) {
			byte [][] string = {  "[������ ���� ��Ʈ��]".getBytes(), "��ġ".getBytes(), "�����Ͱ� ����ϴ� ��ó��".getBytes(), "�����͸� ����մϴ�.".getBytes() };
			
			start = System.nanoTime();
			FileOutputStream fos = new FileOutputStream(fp);
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
			PrintStream ps = new PrintStream(fos);
			
			ps.println("[������ ���� ��Ʈ��]");
			ps.print("��ġ");
			ps.println("�����Ͱ� ����ϴ� ��ó��");
			ps.println("�����͸� ����մϴ�.");
			
			ps.flush();
			ps.close();
			
//			bos.write(string[0]);
//			bos.write(string[1]);
//			bos.write(string[2]);
//			bos.write(string[3]);
//			
//			bos.flush();
//			bos.close();
			
			end = System.nanoTime();
			
			System.out.println(end - start);
		}
		
		FileReader fr = new FileReader(fp);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
		
		
		
	}

}
