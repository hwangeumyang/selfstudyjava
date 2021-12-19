package chap13.sec01;

public class LambdaEx3 {
	@FunctionalInterface
	interface MyFunction {
		void myMethod();
	}
	static int a = 10;

	
	class Outer{
		int val = 10;
		
		class Inner {
			int val = 20;
			
			void method(int i) {
				int val = 30;
//				i = 10;
				
				MyFunction f = () -> {
//					int a= Inner.this.val;
					System.out.printf("%20s: %d%n", "i", i);
					System.out.printf("%20s: %d%n", "val", val);
					System.out.printf("%20s: %d%n", "this.val", ++this.val);
					System.out.printf("%20s: %d%n", "Outer.this.val", ++Outer.this.val);
					System.out.println(a);
				};
				
				f.myMethod();
			}
		}
	}
	
	public static void main(String [] args) {
		new LambdaEx3().new Outer().new Inner().method(20);
		
	}

}
