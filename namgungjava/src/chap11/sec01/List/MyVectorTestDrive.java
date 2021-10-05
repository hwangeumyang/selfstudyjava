package chap11.sec01.List;

import java.util.*;

public class MyVectorTestDrive {
	public static void main(String [] args) {
		MyVector v = new MyVector();
		
		ArrayList<Integer> it = new ArrayList<>();
		
		for(int i=1; i<11; ++i) {
			it.add(10*i);
		}
		
		for(int i=1; i<11; ++i)
			v.add(100*i);
		
		System.out.println(it);
		System.out.println(v);
		
		System.out.println(v.capacity);
		
		v.addAll(it);
		System.out.println(it);
		System.out.println(v);

		
		v.addAll(5, it);
		System.out.println(v);
		System.out.println(v.capacity);
		
		v.addAll(30, it);
		System.out.println(v);
		System.out.println(v.capacity);
		
	}

}
