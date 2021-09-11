package chap14.sec03.verify;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoardService {
	File fp = new File("c:/temp/board");
	Map<Integer, Board> boards = new HashMap<>();
//	Scanner s = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(isr);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	int newLineCharNum;
	int lastBoardsId = 1;
	
	
	BoardService(){
		if(System.getProperty("os.name").toLowerCase().contains("win")) newLineCharNum = 2;
		else newLineCharNum = 1;
//		System.out.println(newLineCharNum);
	}
	

	public void go() {
		StringBuilder sb = new StringBuilder();
		String input;
		ObjectInputStream ois = null;
		//board load
		try {
			if(fp.exists()) {
				FileInputStream fis = new FileInputStream(fp);
				ois = new ObjectInputStream(fis);
				
				boards = (Map<Integer, Board>)ois.readObject();
//				ois.close();
				
				for(int i : boards.keySet()) {
					if(lastBoardsId<i) lastBoardsId = i;
				}
				lastBoardsId++;
			}
		} catch(EOFException eof) {
			System.out.println("���Ͽ� �ҷ��� ������ �����ϴ�.");

		}
		catch(IOException ie) {
			ie.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(Exception ee) {
			ee.printStackTrace();
		}
		
		
//		try {
//			ois.read();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		sb.append("---------------------------------------------------------------\n");
		sb.append("1. ��Ϻ��� | 2. �󼼺��� | 3. �ۼ��ϱ� | 4. �����ϱ� | 5. �����ϱ� | 6. �������� | 7. ����\n");
		sb.append("---------------------------------------------------------------\n");
		sb.append("����: ");		
		
		while(true) {
			System.out.print(sb);
			try {			
				input = reader.readLine();
//				System.out.println(input.length());
				
				switch(input) {
				case "1": listup();
					break;
				case "2": check();
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
				default : System.out.println("1~7���� �߿� �ϳ��� ������ �ּ���");
					break;					
				}
			} catch(IOException e) {
				System.out.println("readLine Error");
			}
			
		}

		
		
	}
	
	public void listup() {
		System.out.println("listup");
		for(Integer idx : boards.keySet()) {
			System.out.println(boards.get(idx));
			
		}
	}
	public void add() throws IOException{
		String title;
		String writer;
		StringBuffer cont = new StringBuffer();
		int i;
		int exitcounter=0;
		
		System.out.print("����: ");
		title = reader.readLine();
		System.out.print("�ۼ���: ");
		writer = reader.readLine();
		System.out.println("����: (���� �ι����� ����)");
		while(exitcounter<newLineCharNum*2) {
			i = reader.read();
			if(i=='\r'||i=='\n') exitcounter+=1;
			else exitcounter=0;
			
			cont.append((char)i);			
		}

		System.out.println("����: " + title);
		System.out.println("�ۼ���: " + writer);
		System.out.println(cont);
		
		Board newBoard = new Board(lastBoardsId++, title, cont.toString(), writer, new Date());
		boards.put(newBoard.getBno(), newBoard);
	}
	public void check() {
		System.out.println("check");
		System.out.println("Ȯ���Ϸ��� �Խñ� ��ȣ�� �����ּ��� ");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			Board b = boards.get(id);
			if(b == null) {
				System.out.println("�������� �ʴ� �Խñ��Դϴ�.");
				return;
			}			
			System.out.println("���: " + b.getTitle());
			System.out.println("�ۼ���: " + b.getWriter());
			System.out.println("��¥: " + sdf.format(b.getDate()));
			System.out.println("����: \n" + b.getContent());

		} catch(NumberFormatException nf) {
			System.out.println("���ڸ� �Է��� �ּ���.");
		} catch(Exception e) {
			System.out.println("error: check");
			e.printStackTrace();
		}

		
		
		
	}
	public void modify() {
		System.out.println("modify");
		System.out.println("�����ϱ� ���ϴ� �Խñ� ��ȣ�� ���� �ּ���");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			Board b = boards.get(id);
			if(b == null) {
				System.out.println("�������� �ʴ� �Խñ��Դϴ�.");
				return;
			}
			System.out.println("���: " + b.getTitle());
			System.out.println("�ۼ���: " + b.getWriter());
			System.out.println("��¥: " + sdf.format(b.getDate()));
			System.out.println(b.getContent());
			System.out.println("�߰��� ������ �����ֽʽÿ�: (���� �ι����� ����)");

			StringBuffer cont = new StringBuffer("�߰�:"+sdf.format(new Date())+">\n");
			int exitcounter=0;
			int i;
			while(exitcounter<newLineCharNum*2) {
				i = reader.read();
				if(i=='\r'||i=='\n') exitcounter+=1;
				else exitcounter=0;
				
				cont.append((char)i);			
			}
			
			b.setContent(b.getContent() + cont.toString());
			
		} catch(NumberFormatException nf) {
			System.out.println("���ڸ� �Է��� �ּ���.");
		} catch(Exception e) {
			System.out.println("error: modify");
			e.printStackTrace();			
		} 


		
	}
	public void delete() {
		System.out.println("delete");
		System.out.println("�����ϱ� ���ϴ� �Խñ� ��ȣ�� ���� �ּ���");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			boards.remove(id);
		} catch(NumberFormatException nf) {
			System.out.println("���ڸ� �Է��� �ּ���.");
		} catch(Exception e) {
			System.out.println("error: delete");
			e.printStackTrace();
		}
	}
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(fp);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(boards);
			
			oos.flush();
			oos.close();
		} catch(IOException ioe) {
			System.out.println("error: save " + ioe.getMessage());
		}
		
		System.out.println("saved");
		
	}
	public void exit() {
		System.exit(0);
	}
}
