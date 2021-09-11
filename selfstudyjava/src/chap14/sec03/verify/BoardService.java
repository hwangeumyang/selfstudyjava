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
			System.out.println("파일에 불러올 내용이 없습니다.");

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
		sb.append("1. 목록보기 | 2. 상세보기 | 3. 작성하기 | 4. 수정하기 | 5. 삭제하기 | 6. 파일저장 | 7. 종료\n");
		sb.append("---------------------------------------------------------------\n");
		sb.append("선택: ");		
		
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
				default : System.out.println("1~7까지 중에 하나만 선택해 주세요");
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
		
		System.out.print("제목: ");
		title = reader.readLine();
		System.out.print("작성자: ");
		writer = reader.readLine();
		System.out.println("내용: (엔터 두번으로 종료)");
		while(exitcounter<newLineCharNum*2) {
			i = reader.read();
			if(i=='\r'||i=='\n') exitcounter+=1;
			else exitcounter=0;
			
			cont.append((char)i);			
		}

		System.out.println("제목: " + title);
		System.out.println("작성자: " + writer);
		System.out.println(cont);
		
		Board newBoard = new Board(lastBoardsId++, title, cont.toString(), writer, new Date());
		boards.put(newBoard.getBno(), newBoard);
	}
	public void check() {
		System.out.println("check");
		System.out.println("확인하려는 게시글 번호를 적어주세요 ");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			Board b = boards.get(id);
			if(b == null) {
				System.out.println("존재하지 않는 게시글입니다.");
				return;
			}			
			System.out.println("재목: " + b.getTitle());
			System.out.println("작성자: " + b.getWriter());
			System.out.println("날짜: " + sdf.format(b.getDate()));
			System.out.println("내용: \n" + b.getContent());

		} catch(NumberFormatException nf) {
			System.out.println("숫자를 입력해 주세요.");
		} catch(Exception e) {
			System.out.println("error: check");
			e.printStackTrace();
		}

		
		
		
	}
	public void modify() {
		System.out.println("modify");
		System.out.println("삭제하길 원하는 게시글 번호를 적어 주세요");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			Board b = boards.get(id);
			if(b == null) {
				System.out.println("존재하지 않는 게시글입니다.");
				return;
			}
			System.out.println("재목: " + b.getTitle());
			System.out.println("작성자: " + b.getWriter());
			System.out.println("날짜: " + sdf.format(b.getDate()));
			System.out.println(b.getContent());
			System.out.println("추가할 내용을 적어주십시오: (엔터 두번으로 종료)");

			StringBuffer cont = new StringBuffer("추가:"+sdf.format(new Date())+">\n");
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
			System.out.println("숫자를 입력해 주세요.");
		} catch(Exception e) {
			System.out.println("error: modify");
			e.printStackTrace();			
		} 


		
	}
	public void delete() {
		System.out.println("delete");
		System.out.println("삭제하길 원하는 게시글 번호를 적어 주세요");
		try {
			String input = reader.readLine();
			Integer id = Integer.parseInt(input);
			boards.remove(id);
		} catch(NumberFormatException nf) {
			System.out.println("숫자를 입력해 주세요.");
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
