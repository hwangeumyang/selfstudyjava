package chap11.sec01;
import java.util.*;
public class IteratorEx1 {
	public static void main(String [] a) {
		List list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) System.out.println(it.next());
		
	}

}
