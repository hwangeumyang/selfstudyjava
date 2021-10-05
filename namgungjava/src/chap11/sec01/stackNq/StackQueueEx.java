package chap11.sec01.stackNq;

import java.util.*;
public class StackQueueEx {
	public static void main(String [] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		for(int i=0; i<3; ++i) {
			st.push(i + "");
			q.offer(i + "");
		}
		
		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("= Q");
		while(!q.isEmpty())
			System.out.println(q.poll());
			
		
		
		
		
	}
}
