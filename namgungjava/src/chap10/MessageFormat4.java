package chap10;

import java.util.*;
import java.io.*;
import java.text.*;

public class MessageFormat4 {
	
	static String filepat = "{0}, {1}, {2}, {3}";
	static String filename = "data4.txt";
	public static void main(String [] args) throws Exception {
		write();
		Scanner s = new Scanner(new File(filename));

		
		String msg = "INSERT INTO CUST_INFO VALUES (''{0}'',''{1}'',''{2}'',''{3}'');";
		
		MessageFormat mf = new MessageFormat(filepat);
		while(s.hasNextLine()) {
			String line = s.nextLine();
			Object[] objs = mf.parse(line);
			System.out.println(MessageFormat.format(msg, objs));
			
		}
		
		s.close();
		
	}
	
	
	//메인 예제는 아니지만 실제 활용할 예제를 만들기 위핸 데이터셋을 생성
	public static void write() throws Exception {
		Object[][] argumentsArray = {
				{"이자바", "02-123-1234", "27", "07-09"},
				{"김프로", "02-122-1543", "33", "10-09"}
		};
		MessageFormat mf = new MessageFormat(filepat);
		
		
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Object[] args : argumentsArray) {
			bw.write(mf.format(args) + "\r\n");	
		}
		
		
		bw.flush();
		bw.close();
		
		
		
	}
	
	

}
