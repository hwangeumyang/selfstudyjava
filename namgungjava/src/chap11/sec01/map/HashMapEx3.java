package chap11.sec01.map;

import java.util.*;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap(); 
	public static void main(String [] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "이자바", "010-222-2221");
		addPhoneNo("친구", "이자바", "010-333-1111");
		addPhoneNo("회사", "이자바", "010-441-1111");
		addPhoneNo("회사", "이자바", "010-555-1111");
		addPhoneNo("회사", "이자바", "010-666-1111");
		addPhoneNo("회사", "이자바", "010-777-1111");
		addPhoneNo("세탁", "010-888-1111");
	
		printList();
	}
	public static void addPhoneNo(String group, String name, String tel){
		addGroup(group);
		HashMap groupmap = (HashMap)phoneBook.get(group);
		if(!groupmap.containsKey(tel)) groupmap.put(tel, name);
		
	}
	public static void addGroup(String group) {
		if(!phoneBook.containsKey(group))
			phoneBook.put(group, new HashMap());		
	}
	public static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	static void printList(){
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(e.getKey() + "[" + subSet.size() + "]");
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				System.out.println(subE.getKey() + " " + subE.getValue());
				
			}
			System.out.println();
			
		}
		
		
		
	}
}
