package chap11.sec01.Set;

import java.util.*;

public class HashSetEx1 {
	public static void main(String [] args) {
		Object [] objArr = {"1", new Integer(1), 1, "2", "2", "2"};
		Set set = new HashSet();
		
		for(Object o : objArr) {
			set.add(o);
		}
		
		System.out.println(set);
		
	}

}
