package chap14.sec02;

import java.io.*;

public class NonBufferVsBufferExample {
	public static void main(String [] args) throws Exception {
		String originalFilePath =  NonBufferVsBufferExample.class.getResource("amayui.jpg").getPath();
		String targetFilePath1 = "c:/temp/targetFile1.jpg";
		String targetFilePath2 = "c:/temp/targetFile2.jpg";
		String targetFilePath3 = "c:/temp/targetFile3.jpg";
		String targetFilePath4 = "c:/temp/targetFile4.jpg";
		
		
		//non buffer
		FileInputStream fis = new FileInputStream(originalFilePath);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
				
		//buffer
		FileInputStream fis2 = new FileInputStream(originalFilePath);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis2 = new BufferedInputStream(fis2);
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2);
		
		//non buffer input, buffer output
		FileInputStream fis3 = new FileInputStream(originalFilePath);
		FileOutputStream fos3 = new FileOutputStream(targetFilePath3);
		BufferedOutputStream bos3 = new BufferedOutputStream(fos3);
		
		//buffer input, non buffer output
		FileInputStream fis4 = new FileInputStream(originalFilePath);
		FileOutputStream fos4 = new FileOutputStream(targetFilePath4);
		BufferedInputStream bis4 = new BufferedInputStream(fis4);
		BufferedOutputStream bos4 = new BufferedOutputStream(fos4);
		
		long time;
		
		time = copy(fis, fos);
		System.out.println("only non buffer used: " + time);
		
		time = copy(bis2, bos2);
		System.out.println("only buffer used: " + time);
		
		time = copy(fis3, bos3);
		System.out.println("non buffer input, buffer output: " + time);
//		fos3.write("hello".getBytes());
//		fos3.flush();
		
		
		
//		bos4.write("hello".getBytes());
//		bos4.write('a');
//		bos4.write('a');
//		bos4.write('a');
//		bos4.flush();
		time = copy(bis4, fos4);
		System.out.println("buffered input, non buffered output: " + time);
		
//		bos4.write("hello".getBytes());
//		bos4.write('a');
//		bos4.write('a');
//		bos4.write('a');
//		bos4.flush();
	}
	
	static int data = -1;
	public static long copy(InputStream is, OutputStream os) throws Exception{
		long start = System.nanoTime();
		while(true) {
			data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		os.flush();
		is.close();
		os.close();		
		long end = System.nanoTime();
		return end - start;
	}

}
