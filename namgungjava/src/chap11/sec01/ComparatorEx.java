package chap11.sec01;

import java.util.*;

public class ComparatorEx {
	public static void main(String [] args) {
		String [] animals = { "cat", "Dog", "lion", "tiger" };
		
		Arrays.sort(animals);
		print("animals", animals);
		
		Arrays.sort(animals, String.CASE_INSENSITIVE_ORDER);
		print("animals", animals);
		
		Arrays.sort(animals, new Descending());
		print("animals", animals);
	}
	static class Descending implements Comparator {
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Comparable && o2 instanceof Comparable) {
				Comparable c1 = (Comparable) o1;
				Comparable c2 = (Comparable) o2;
				return c1.compareTo(c2) * -1;				
			}
			return -1;
		}
	}
	public static void print(String name, Object[] o) {
		System.out.println(name + " : " + Arrays.toString(o));		
	}

}
