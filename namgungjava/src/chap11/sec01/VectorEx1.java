package chap11.sec01;

import java.util.*;

public class VectorEx1 {
	public static void main(String [] ags) {
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		p(v);
		
		v.trimToSize(); //����� ���
		System.out.println("after trimToSize()");
		p(v);
		
		v.ensureCapacity(6);//�ּ� 6ĳ�۱���
		System.out.println("after unsureCapacity(6)");
		p(v);
		
		//ĳ�۽�Ƽ�� ���ڶ�� 2��� Ȯ���Ѵ�.
		v.setSize(7);
		System.out.println("after setSize(7)");
		p(v);
		
		v.clear();
		System.out.println("after clear()");
		p(v);
		
	}
	public static void p(Vector v) {
		System.out.println(v);;
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
	}

}
