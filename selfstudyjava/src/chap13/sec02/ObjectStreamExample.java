package chap13.sec02;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ObjectStreamExample {
	static String fp = "c:/temp/board.db";

	public static void main(String [] args) throws Exception {
		writeList();
		List<Board> list = readList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Board board : list) {
			System.out.printf("%d\t%s\t%s\t%s\n", board.getBno(), board.getContent(), board.getWriter(), sdf.format(board.getDate()));
		}
		
		
	}
	
	public static void writeList() throws Exception {
		List<Board> list =new ArrayList<>();
		
		list.add(new Board(1, "����1", "����1", "�۾���1", new Date()));
		list.add(new Board(1, "����2", "����2", "�۾���2", new Date()));
		list.add(new Board(1, "����3", "����3", "�۾���3", new Date()));
		
		FileOutputStream fos = new FileOutputStream("C:/temp/board.db");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public static List<Board> readList() throws Exception {
		FileInputStream fis = new FileInputStream(fp);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Board> list = (List<Board>) ois.readObject();
		
		ois.close();
		return list;
	}

}


