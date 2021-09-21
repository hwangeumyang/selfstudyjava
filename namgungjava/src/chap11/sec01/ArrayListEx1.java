package chap11.sec01;

import java.util.*;

public class ArrayListEx1 {
	static List l1;
	static List l2;
	@SuppressWarnings("unchecked")
	public static void main(String [] args) {
		ArrayList l1 = new ArrayList(10);
		l1.add(new Integer(5));
		l1.add(new Integer(4));
		l1.add(new Integer(2));
		l1.add(new Integer(0));
		l1.add(new Integer(1));
		l1.add(new Integer(3));
		
		ArrayList l2 = new ArrayList(l1.subList(1, 4));
		print(l1, l2);
		
		ArrayListEx1.l1 = l1;
		ArrayListEx1.l2 = l2;
		
		
		Collections.sort(l1);
		Collections.sort(l2);
		print(l1, l2);
		
		System.out.println("l1.containsAll(l2): " + l1.containsAll(l2));
		
		l2.add("B");
		l2.add("C");
		l2.add(3, "A");
		print();
		l2.set(3, "AA");
		print();
		
		//마스크 빼고 다 삭제
		System.out.println("l1.retainAll(l2): " + l1.retainAll(l2));
		print();
		
		//l1에 있으면 삭제
		for(int i=l2.size()-1; i>=0; --i) {
			if(l1.contains(l2.get(i))) l2.remove(i);
		}
		
		print();	
		
	}
	public static void print() {
		System.out.println("l1 : " + l1);
		System.out.println("l2 : " + l2);
		System.out.println();
	}
	public static void print(List l1, List l2) {
		System.out.println("l1 : " + l1);
		System.out.println("l2 : " + l2);
		System.out.println();
	}

}
