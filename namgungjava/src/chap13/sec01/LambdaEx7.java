package chap13.sec01;

import java.util.*;
import java.util.function.*;

public class LambdaEx7 {
	
	public static void main(String [] args) {

		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		
		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF"));
		System.out.println(h2.apply(2));
		
		
		Function<String, String> f2 = x->x; //항등함수
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = (i) -> i<100;
		Predicate<Integer> q = (i) -> i>200;
		Predicate<Integer> r = (i) -> i%2==0;
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));
		
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.println(str1==str2);
		
		
//		Predicate<String> p2 = Predicate.isEqual(str1);
		Predicate<String> p2 = (s) -> s.equals(str1);
		
		boolean result = p2.test(str2);
		System.out.println(result);
		
		
		
		
	}
	
}
