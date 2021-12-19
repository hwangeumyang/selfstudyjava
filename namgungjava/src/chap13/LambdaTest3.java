package chap13;
/*
 * 람다식이 적당히 존재하는 함수형 인터페이스를 구현하는 것이라고 생각했는 데 아니라고한다.
 */


public class LambdaTest3 {
	public static void main(String [] args) {
		
		Func1 f = () -> {
			System.out.println("what");
			
		};
		
		Func1 f2 = new Func1() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Object obj = (Func1)() -> {};
		
		
	}
	

	@FunctionalInterface
	interface Func1{
		public void run();
	}

}
