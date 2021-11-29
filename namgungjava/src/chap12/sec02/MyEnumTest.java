package chap12.sec02;

enum AAAnimal { Dog, Cat }
public class MyEnumTest {
	enum MyEnum { Dog }
	
	public static void main(String [] args ) {
		
//		System.out.println(AAAnimal.Dog == MyAnimal.Animal.Dog); Error
		System.out.println(AAAnimal.Dog == AAAnimal.Cat);
		System.out.println(MyAnimal.Animal.Dog == MyAnimal.Animal.Dog);
		
		System.out.println(ABC.TT);
		
//		System.out.println(MyEnum.Dog);
		
	}
	
	

}

class MyAnimal {
	enum Animal { Dog, cat }
	
	
	
}