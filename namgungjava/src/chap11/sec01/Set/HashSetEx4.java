package chap11.sec01.Set;

import java.util.*;

public class HashSetEx4 {
	public static void main(String [] arg) {
		HashSet set = new HashSet();
		
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("david", 10));
		set.add(new Person2("david", 10));
		
		System.out.println(set);
	}

}

class Person2 {
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 p = (Person2)obj;
			return this.name.equals(p.name) && this.age == p.age;
		}
		return false;
	}
	
	public int hashCode() {
		return (name+age).hashCode();
	}
	
	public String toString() {
		return name + " : " + age;		
	}
}