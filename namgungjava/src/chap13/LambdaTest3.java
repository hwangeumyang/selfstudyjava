package chap13;
/*
 * ���ٽ��� ������ �����ϴ� �Լ��� �������̽��� �����ϴ� ���̶�� �����ߴ� �� �ƴ϶���Ѵ�.
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
