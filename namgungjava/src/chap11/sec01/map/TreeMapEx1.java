package chap11.sec01.map;

import java.util.*;

public class TreeMapEx1 {
	
	public static void main(String [] args) {
		char [] d = "AKAKDKAKKKZD".toCharArray();
		
		String [] data = new String[d.length];
		for(int i=0, leng=data.length; i<leng; ++i) data[i] = String.valueOf(d[i]);
		
		TreeMap map = new TreeMap();
		
		for(int i=0; i<data.length; ++i) {
			if(map.containsKey(data[i])) {
				map.put(data[i], (Integer)map.get(data[i])+1);
			}
			else {
				map.put(data[i], 1);
			}
		}
		
		System.out.println("기본정렬");
		for(Object obj : map.entrySet()) {
			Map.Entry ent = (Map.Entry) obj;			
//			String k = (String)ent.getKey();
			int v = (Integer)ent.getValue();
			
			System.out.println(ent.getKey() + " : " + printBar('#', v) + " " + v);
		}
		
//		Set set = map.entrySet();
//		List list = new ArrayList(set);
		List list = new ArrayList(map.entrySet());
		
		
		
		System.out.println("값의 크기가 큰 순서로 정렬");
		Collections.sort(list, new ValueComparator());
		
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			Map.Entry ent = (Map.Entry) it.next();
//			System.out.println(ent.getKey() + " : " + printBar('#', (Integer)ent.getValue()) + " " + ent.getValue() );
//			
//		}
		
		for(Object obj : list) {
			Map.Entry<Object, Integer> ent = (Map.Entry) obj;
			System.out.println(ent.getKey() + " : " + printBar('#', ent.getValue()) + " " + ent.getValue());
		}
		
	}
	
	static class ValueComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			int output = -1;
			
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry<Object, Integer> e1 = (Map.Entry)o1;
				Map.Entry<Object, Integer> e2 = (Map.Entry)o2;

//				output = e1.getValue() < e2.getValue() ? -1 : e1.getValue() == e2.getValue() ? 0 : 1;
				output = e2.getValue() - e1.getValue();
			}
			
			return output;			
		}
	}
	
	
	public static String printBar(char ch, int value) {
		char [] bar = new char[value];
		
		for(int i=0; i<value; ++i) bar[i] = ch;
		
		return new String(bar);
	}

}
