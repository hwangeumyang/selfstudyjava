package chap11.sec01.stackNq;

import java.util.*;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String [] args) {
		System.out.println("help : ����");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			try {
				//ȭ�鿡�� ���δ����� �Է�
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println("help : ����");
					System.out.println("q : ����");
					System.out.println("history : �ֱ� �Է��� ��ɾ " + MAX_SIZE + "�� �����ݴϴ�.");
				} else if(input.equalsIgnoreCase("history")) {
					int i=0;
					
					save(input);
					
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext()) System.out.println(++i + "." + it.next());
					
//					Iterator it = q.iterator();
//					
//					while(it.hasNext()) {
//						System.out.println(++i + "." + it.next());
//					}
					
					
				} else {
					save(input);
					System.out.println(input);
				}
				
			} catch(Exception e) {
				System.out.println("�Է� ����");
				
			}
			
		}
	}
	
	public static void save(String input) {
		if(!"".equals(input)) q.offer(input);
		if(q.size() >MAX_SIZE) q.remove();
			
	}

}
