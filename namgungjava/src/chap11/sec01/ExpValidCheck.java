package chap11.sec01;

import java.util.*;
import java.io.*;

public class ExpValidCheck {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			while(true) {
				String line = br.readLine();
				if(line.split(" ").length!=1) {
					System.out.println("usage: \"EXPRESSION\"");
					System.out.println("usage: \"((2+3)*1)+3\"");
					break;
				} else if(line.equals("x")) break;
				Stack st = new Stack();
				String exp = line;//expression
				
				System.out.println("exp : " + exp);
				try {
					for(int i=0; i<exp.length(); ++i) {
						char ch = exp.charAt(i);
						if(ch=='(') {
							st.push(ch+"");
						} else if(ch==')') {
							st.pop();
						}
					}
					
					if(st.isEmpty()) System.out.println("��ȣ��ġ");
					else System.out.println("��ȣ ����ġ");
				} catch(EmptyStackException ste) {
					System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
					ste.printStackTrace();
					break;
				}
				
				
			}			
			
			br.close();
		} catch(IOException io) {
			io.printStackTrace();
		}


	}

}
