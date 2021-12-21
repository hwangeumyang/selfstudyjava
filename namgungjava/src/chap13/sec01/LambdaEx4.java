package chap13.sec01;

import java.util.ArrayList;

public class LambdaEx4 {
	
	public static void main(String [] args) {

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10; ++i) list.add(i);
		
		list.forEach(i->System.out.print(i + " "));
		System.out.println();
		
		
		//2의 배수 or 3의 배수 제거
		list.removeIf(x -> x%2==0 || x%3 == 0);
		System.out.println(list);
		
		list.replaceAll(i->i*10);
		System.out.println(list);
		
		java.util.Map<String, String> map = new java.util.HashMap<>();
		for(int i=0; i<4; i++) map.put(i+"", i+"");
		
		map.forEach((k, v) -> System.out.printf("(k : %s, v : %s) ", k, v));
		
	
		
		
		
	}
	

}
