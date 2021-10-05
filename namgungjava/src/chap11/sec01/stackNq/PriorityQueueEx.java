package chap11.sec01.stackNq;

import java.util.*;

//Comparator를 사용하는 예제로 조금 바꾸었다.

public class PriorityQueueEx {
	public static void main(String [] args) {
		Queue pq = new PriorityQueue(new PriorityQueueEx().new Comp());
		pq.offer(new FakeInt(3));
		pq.offer(new FakeInt(5));
		pq.offer(new FakeInt(2));
		pq.offer(new FakeInt(1));
		pq.offer(new FakeInt(7));
		
		System.out.println(pq);
	}
	
	class Comp implements Comparator<FakeInt>{
		@Override
		public int compare(FakeInt o1, FakeInt o2) {
			if(o1.getV()<o2.getV()) return -1;
			else if(o1.getV()==o2.getV()) return 0;
			
			return 1;
		}
		
	}
	static class FakeInt{
		int value;
		FakeInt(int value){
			this.value = value;			
		}
		int getV(){
			return value;
		}
		@Override
		public String toString() {
			return value + ""; 
		}
	}
}
