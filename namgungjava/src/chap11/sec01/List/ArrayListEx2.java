package chap11.sec01.List;

import java.util.*;

public class ArrayListEx2 {
	public static void main(String [] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int leng = source.length();
		
		List list = new ArrayList(leng/LIMIT + 10);
		
		
		for(int i=0; i<leng; i+=LIMIT) {
			if(i+LIMIT < leng) {
				list.add(source.substring(i, i+LIMIT));
			} else list.add(source.substring(i));
		}
		
		for(Object o : list)
			System.out.println(o);
	}

}
