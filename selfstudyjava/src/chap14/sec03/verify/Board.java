package chap14.sec03.verify;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Board implements Serializable {
	private int bno;
	private static int lastbno=1;
	private String title;
	private String content;
	private String writer;
	private Date date;
	
	public Board(String title, String content, String writer, Date date) {
		bno = lastbno++;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;		
	}
	
	public Board(int bno, String title, String content, String writer, Date date) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return String.format("%d\t%s\t%s\t%s\n", bno, title, writer, sdf.format(date)); 
	}
	
}