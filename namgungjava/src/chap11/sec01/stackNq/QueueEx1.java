package chap11.sec01.stackNq;

import java.util.*;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String [] args) {
		System.out.println("help : 도움말");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			try {
				//화면에서 라인단위로 입력
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println("help : 도움말");
					System.out.println("q : 종료");
					System.out.println("history : 최근 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
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
				System.out.println("입력 오류");
				
			}
			
		}
	}
	
	public static void save(String input) {
		if(!"".equals(input)) q.offer(input);
		if(q.size() >MAX_SIZE) q.remove();
			
	}

}
