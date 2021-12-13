package chap13;
/*
 * �������� �ǹ��� ���� �׽�Ʈ �ҽ� �ڵ�
 * 
 * 1. ���ÿ��� �������̽��� ���ٽ��� ������� �� Ŭ������ ������ ���ΰ�
 * 2. ������ �͸�ü�� ����� ����� �ΰ� �����ϸ鼭 ���ٽ��� ������ �޼���(�Ű������� Ÿ�԰� ����, ��ȯ���� ��ġ��)�� ������ �翬�� �����Ѵٴ� ������ �����ߴ�. �� ���� �ִ� �״�� �޾Ƶ��̸� ���� ���� �޼��带 ������ �ִ� Object ��ü�� �ڿ������� �޾Ƶ鿩���Ѵ�.
 * 3. �ڵ带 ª�� �ٿ��� ���ٽ��� �̿���
 * 
 * 1 -> �Լ��� �������̽����� ��� �����ϴ�. �߻�Ŭ������ ������� �ʴ´�. 
 * 2 -> �翬�� ���� �ȵǴ� �Ҹ���. �����ϴ� ��δ�.
 * 3 -> å���� �������� ���������. �׳� �ٷ� �ᵵ �Ǵ��� ������ �ش�Ǵ� �������̽��� �Լ��� �������̽� �ֳ����̼��� �� �ʿ����� ������.
 */


public class LambdaTest1 {
	public static void main(String [] args) {
		LambdaTest1.Func1 f1;
		LambdaTest1.Func2 f2;
		LambdaTest1.Func3 f3;
		
		//2�� �׸�
//		f1 = new Object() {
//			public void run() {
//				System.out.println("hello");
//			}
//		};
		//non error
		f1 = new Func1() {
			@Override
			public void run() {
				
			}
		};
		f1 = () -> System.out.println("hey");
		// permited only functional interface
//		f2 = () -> System.out.println("hey");
//		f3 = () -> System.out.println("hey");
		
		test(new LambdaTest1.Func1() {
			@Override
			public void run() {
			}			
		});
		
		
		
		//3�� �׸�
		f1 = () -> System.out.println("hey");
		
		test( (f1 = (() -> System.out.println("hey") )));
		test( 
				(LambdaTest1.Func1)(() -> System.out.println("hey"))
				);
		
		test(() -> System.out.println("hey"));
		
	}
	
	public static void test(Func1 f) {
		f.run();
		
	}
	
//	������ �ٴ� �� ������ �ֳ����̼��� ��� ���ٽĿ� ������ ���ص� �ȴٴ� ���� ���̱� ���� �ּ�ó����. �� �ֳ����̼��� ������ �ܰ迡�� �Լ��� �������̽� ������ �����ϴ� �� �˷��ֱ� ���� ���ε� �ʹ�.
//	@FunctionalInterface
	interface Func1{
		public void run();
	}
	
	//1���׸�
	abstract class Func2 {
		abstract public void run();		
	}
	//1���׸�	
	interface Func3{
		public void run();
		public void walk();
	}

}
