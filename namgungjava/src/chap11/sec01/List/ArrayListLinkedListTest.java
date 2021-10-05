package chap11.sec01.List;

import java.util.*;

public class ArrayListLinkedListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();
		
		System.out.println("순차추가");
		System.out.println("al: " + add1(al) );
		System.out.println("LL: " + add1(ll));

		System.out.println("중간추가");
		System.out.println("al: " + add2(al) );
		System.out.println("LL: " + add2(ll));
		
		System.out.println("중간삭제");
		System.out.println("al: " + remove2(al) );
		System.out.println("LL: " + remove2(ll));
		
		System.out.println("순차삭제");
		System.out.println("al: " + remove1(al) );
		System.out.println("LL: " + remove1(ll));
		
	}
	
	public static long add1(List l) {
		long start = System.currentTimeMillis();
		for(int i=0; i<1000000; ++i) {
			l.add(i+"");
		}
		long end = System.currentTimeMillis();
		return end - start;		
	}
	public static long add2(List l) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; ++i) {
			l.add(500, "X");
		}
		long end = System.currentTimeMillis();
		return end - start;		
	}
	public static long remove1(List l) {
		long start = System.currentTimeMillis();
		for(int i=l.size()-1; i>=0; --i) l.remove(i);
		long end = System.currentTimeMillis();
		return end - start;		
	}
	public static long remove2(List l) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; ++i) l.remove(i);
		long end = System.currentTimeMillis();
		return end - start;		
	}
	

}
