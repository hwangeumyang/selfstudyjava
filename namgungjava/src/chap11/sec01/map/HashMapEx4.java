package chap11.sec01.map;

import java.util.*;
public class HashMapEx4 {
	public static void main(String [] args) {
		String [] data = { "A", "D", "Z", "K" };
		ArrayList dlist = new ArrayList<>(Arrays.asList(data));
		HashMap map = new HashMap();		
		
		for(String d : data) {
			int limit = (int)(Math.random()*6);//0~5
			for(int i=0; i<limit; ++i) {
				dlist.add(d);
			}
		}
		System.out.println("dlist: " + dlist);
		
		for(int i=0; i<dlist.size(); ++i) {
			String k = (String)dlist.get(i);
			if(map.containsKey(k)) map.put(k, (int)map.get(k)+1);
			else map.put(k, 1);
		}
		
		Set set=map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			HashMap.Entry e = (HashMap.Entry)it.next();
			System.out.print(e.getKey() + " ");
//			for(int i=0; i<(int)e.getValue(); ++i) System.out.print("#");
			System.out.print(makeBar('#', (int)e.getValue()));
			System.out.println(" " +e.getValue());
			
		}
	}
	
	public static String makeBar(char ch, int value) {
		char [] bar = new char[value];
		
		for(int i=0; i<value; ++i) bar[i] = ch;
		
		return new String(bar);
	}

}
