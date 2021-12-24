package chap13;

import java.util.function.*;

/*
 * equlas메서드 참조를 보고 궁금해서 적은 코드
 */

public class LambdaTest4 {
	
	public static void main(String [] args) {
//		BiFunction<String, String, Boolean> f = String::equals; 
		BiFunction<Cat, Cat, Boolean> f = Cat::equals;
				
		Cat cat = new Cat();
		Cat catty = new Catty();
		
		System.out.println(f.apply(cat, catty));
		System.out.println(f.apply(catty, cat));
		
		//Working
		BiFunction<Cat, Rat, Boolean> ff = Cat::eat;
		//Error
//		BiFunction<Rat, Cat, Boolean> ff2 = Cat::eat;

		System.out.println(ff.apply(catty, new Rat()));
		
	}
}

class Cat {
	@Override
	public boolean equals(Object one) {
		
		return true;
	}
	public boolean eat(Rat rat) {
		return true;		
	}
}
class Catty extends Cat {
	@Override
	public boolean equals(Object one) {
		return false;
	}
}
class Rat {
	public String toString() {
		return "rat";
	}
	
}