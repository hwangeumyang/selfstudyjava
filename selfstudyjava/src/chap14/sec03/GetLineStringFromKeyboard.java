package chap14.sec03;

import java.io.*;

public class GetLineStringFromKeyboard {
	
	public static void main(String [] args) throws Exception {
//		int n;
//		for(int i=0 ;i<5; ++i) {
//			n = System.in.read();
//			if(n==13||n==10) {
//				--i;
//				continue;
//			}
//			System.out.println(n);
//			
//		}
		
		InputStream is = System.in;
		Reader r = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(r);
		
		while(true) {
			System.out.print("�Է��ϼ���: ");
			String lineStr = br.readLine();
			if(lineStr.equals("q") || lineStr.equals("quit")) break;
			System.out.println("�Էµȳ���: " + lineStr);
		}
		
		br.close();
	}

}
