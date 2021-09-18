package chap10;

import java.text.MessageFormat;

//ex2 �⺻ ��� ���
//ex3 parse �̿� ����

public class MessageFormatEx2 {
	public static void main(String [] args) throws Exception {
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO " + tableName + " VALUES (''{0}'',''{1}'',''{2}'',''{3}'');";
		
		Object[][] argumentsArray = {
				{"���ڹ�", "02-123-1234", "27", "07-09"},
				{"������", "02-122-1543", "33", "10-09"}
		};
		
		String data[] = new String[2];
		
//		String result = MessageFormat.format(msg, argumentsArray[0]);
//		System.out.println(result);
		
		
		int i=0;
		for(Object[] arguments : argumentsArray) {
			data[i] = MessageFormat.format(msg, arguments);
			System.out.println(data[i]);
			++i;
		}
		
		MessageFormat mf = new MessageFormat(msg);
		
		i=0;
		for(String d : data) {
			Object[] objs = mf.parse(data[i++]);
			for(Object obj : objs) {
				System.out.print(obj + ", ");
			}
			System.out.println();
		}
		
		
	}

}
