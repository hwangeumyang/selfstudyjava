package chap13;
/*
 * 기본적인 사용례
 */


public class LambdaTest2 {
	public static <T> void main(String [] args) {
		
		test(() -> (int)5);
		
		test2((s) -> s+="ff");
		test2( s -> {
			s+="ff";
			return s;
			
		});
		
		test3(()->System.out.println("f"));
		
		test4((a)->{
			for(int i : a) System.out.println(i);
			
		});
		
		
		
	}
	
	public static void test(Func1 f) {
		System.out.println(f.random());
		
	}
	public static void test2(Func2 f) {
		System.out.println(f.run("A"));
	}
	public static void test3(Func3 f) {
		f.run();
	}
	public static void test4(Func4 f) {
		int[] a = new int[4];
		int[] b = {1, 1, 1, 1};
		f.run(b);
	}
	interface Func1 {
		int random();
	}
	
	@FunctionalInterface
	interface Func2 {
		String run(String s);
	}
	
	interface Func3 {
		void run();
	}
	
	interface Func4 {
		void run(int [] arr);
	}
}
