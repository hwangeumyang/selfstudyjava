package chap14.sec03.verify;

import java.io.*;
import java.util.*;

public class BoardService {
	File fp = new File("c:/temp/board");
	List<Board> boards = new ArrayList<>();
//	Scanner s = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(isr);
	

	public void go() {
		StringBuilder sb = new StringBuilder();
		String input;
		
		//board load
		try {
			if(fp.exists()) {
				FileInputStream fis = new FileInputStream(fp);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				boards = (List<Board>)ois.readObject();
			}
		} catch(IOException ie) {
			System.out.println("���� " + ie.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		sb.append("---------------------------------------------------------------\n");
		sb.append("1. ��Ϻ��� | 2. �󼼺��� | 3. �ۼ��ϱ� | 4. �����ϱ� | 5. �����ϱ� | 6. �������� | 7. ����\n");
		sb.append("---------------------------------------------------------------\n");
		sb.append("����: ");		
		
		while(true) {
			System.out.print(sb);
			try {			
				input = reader.readLine();
				System.out.println(input.length());
				
				switch(input) {
				case "1": listup();
					break;
				case "2": check();
				System.out.println("1");
					break;
				case "3": add();
					break;
				case "4": modify();
					break;
				case "5": delete();
					break;
				case "6": save();
					break;
				case "7": exit();
					return;
					
				}
			} catch(IOException e) {
				System.out.println("readLine Error");
			}
			
		}

		
		
	}
	
	public void listup() {
		System.out.println("listup");
		for(Board b : boards) {
			System.out.println(b);
			
		}
	}
	public void add() throws IOException{
		String title;
		String writer;
		StringBuffer cont = new StringBuffer();
		char[] cbuf = new char[1024];
		
		System.out.print("����: ");
		title = reader.readLine();
		System.out.print("�ۼ���: ");
		writer = reader.readLine();
		System.out.println("����: (���� �ι����� ����)");
		while(true) {
			if(reader.read(cbuf) == -1) break;;
			
			if(cont.length()<4) continue;
			if(cont.substring(cont.length()-2, cont.length()).equals("\n\n")) break;
			if(cont.substring(cont.length()-4, cont.length()).equals("\r\n\r\n")) break;
			
			System.out.println(cont);
		}
		
		
		
		
	}
	public void check() {
		System.out.println("check");
		
	}
	public void modify() {
		System.out.println("modify");
		
	}
	public void delete() {
		System.out.println("delete");
		
	}
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(fp);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(boards);
		} catch(IOException ioe) {
			System.out.println("error: save " + ioe.getMessage());
		}
		
	}
	public void exit() {
		System.exit(0);
	}
}
