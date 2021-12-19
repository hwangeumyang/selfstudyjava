package chap13.sec01;

public class LambdaEx1 {
	
	static void execute(MyFunction f) {
		f.run();
	}
	static MyFunction getMyFunction() {
		return () -> System.out.println("f3.run()");
	}

	
	public static void main(String [] args ) {
		
		MyFunction f[] = {
				() -> System.out.println("f1.run()"),
				new MyFunction() {
					public void run() {
						System.out.println("f2.run()");
					}
				},
				getMyFunction()
				
		};
		
		for(MyFunction func : f) {
			func.run();
		}
		
		execute(f[0]);
		execute(() -> System.out.println("run()"));
		
		
	}
	
	@FunctionalInterface
	interface MyFunction {
		void run();
	}
}

