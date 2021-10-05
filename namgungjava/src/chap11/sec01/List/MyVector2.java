package chap11.sec01.List;

import java.util.*;

public class MyVector2 extends MyVector implements Iterator{
	int cursor = 0;
	int lastRet = -1;
	
	MyVector2(int capacity){
		super(capacity);
	}
	MyVector2(){
		this(10);
	}
	
	@Override
	public String toString() {
		String tmp = "";
		Iterator it = iterator();
		
		if(it.hasNext()) tmp += it.next();
		while(it.hasNext()) {
			tmp += ", ";
			tmp += next();
		}
		
		return "[" + tmp + "]";
	}
	public Iterator iterator() {
		cursor = 0;
		lastRet = -1;
		return this;
	}
	@Override
	public boolean hasNext() {
		return cursor != size();
	}
	@Override
	public Object next() {
		Object next = get(cursor);
		lastRet = cursor++;
//		System.out.println(data[0]);
//		System.out.println(next);
		return next;
	}
	public void remove() {
		if(lastRet == -1) throw new IllegalStateException();
		else {
			remove(lastRet);
			cursor--;
			lastRet= -1;
		}
	}
	

}
