package chap11.sec01;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PropertiesEx2 {
	public static void main(String [] args) throws Exception {
		Properties prop = new Properties();
		
//		String inputfile = args[0];
		String inputFile = "input.txt";
		
		try {
			
//			System.out.println(new File(inputFile).getAbsolutePath());
			prop.load(new FileInputStream(inputFile));
			
		} catch(IOException e) {
			System.out.println("������������ ã�� �� �����ϴ�");
			System.exit(0);
		}
		
		String name = new String(prop.getProperty("name").getBytes("8859_1"), StandardCharsets.UTF_8 );
//		new String
		
//		System.out.println(prop.getProperty("data").);
		String[] data = prop.getProperty("data").split("[,| ]+");
//		System.out.println(data.length);
//		for(String d : data) {
//			System.out.println(d);
//		}
		int max = 0, min = 0;
		int sum = 0;
		
//		max = min = Integer.parseInt(data[0]);
//		sum=max;
//		for(int i=1; i<data.length; ++i) {
//			int intValue = Integer.parseInt(data[i]);
//			
//			if(max < intValue) max=intValue ;
//			else if(min > intValue) min = intValue;
//			
//			sum+=intValue;
//		}
		max = min = Integer.parseInt(data[0]);
		for(int i=0; i<data.length; ++i) {
			int intValue = Integer.parseInt(data[i]);
			
			if(max < intValue) max=intValue ;
			else if(min > intValue) min = intValue;
			
			sum+=intValue;
		}
		
		System.out.println("�̸�: " + name);
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
		System.out.println("�հ�: " + sum);
		System.out.println("���: " + (sum*100.0/data.length)/100);
		
	}
}
