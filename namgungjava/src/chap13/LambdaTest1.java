package chap13;
/*
 * 개인적인 의문을 위한 테스트 소스 코드
 * 
 * 1. 예시에선 인터페이스에 람다식을 만들었는 데 클래스도 가능할 것인가
 * 2. 기존에 익명객체를 만드는 방식을 두고 설명하면서 람다식이 동등한 메서드(매개변수의 타입과 개수, 반환값이 일치함)가 있으니 당연히 동작한다는 식으로 설명했다. 이 말을 있는 그대로 받아들이면 같은 형식 메서드를 가지고 있는 Object 객체도 자연스럽게 받아들여야한다.
 * 3. 코드를 짧게 줄여줄 람다식의 이용방법
 * 
 * 1 -> 함수형 인터페이스에만 사용 가능하다. 추상클래스는 고려되지 않는다. 
 * 2 -> 당연히 말도 안되는 소리다. 예상하던 대로다.
 * 3 -> 책에서 마지막에 설명해줬다. 그냥 바로 써도 되더라 심지어 해당되는 인터페이스에 함수형 인터페이스 애너테이션을 달 필요조차 없었다.
 */


public class LambdaTest1 {
	public static void main(String [] args) {
		LambdaTest1.Func1 f1;
		LambdaTest1.Func2 f2;
		LambdaTest1.Func3 f3;
		
		//2번 항목
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
		
		
		
		//3번 항목
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
	
//	원래는 다는 게 옳으나 애너테이션이 없어도 람다식에 뻘짓을 안해도 된다는 것을 보이기 위해 주석처리함. 이 애너테이션은 컴파일 단계에서 함수형 인터페이스 조건을 충족하는 지 알려주기 위한 것인듯 싶다.
//	@FunctionalInterface
	interface Func1{
		public void run();
	}
	
	//1번항목
	abstract class Func2 {
		abstract public void run();		
	}
	//1번항목	
	interface Func3{
		public void run();
		public void walk();
	}

}
