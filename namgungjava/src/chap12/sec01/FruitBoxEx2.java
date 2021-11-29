package chap12.sec01;

import java.util.ArrayList;


public class FruitBoxEx2 {
	static interface Eatable {}
	
	static class Fruit implements Eatable { public String toString() {return "Fruit";}}
	static class Apple extends Fruit { public String toString() { return "Apple"; }}
	static class Grape extends Fruit { public String toString() { return "Grape"; }}
	static class Toy { public String toString() { return "Toy"; }}	
	
	public static void main(String [] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		Box<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Toy> toyBox = new Box<Toy>();
//		Box<Toy> toyBox = new FruitBox<>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		
		
		
		
		
		
		
		
		
		
	}
	
	static class Box<T> {
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) { list.add(item); }
		T get(int i) { return list.get(i); }
		int size() { return list.size(); }
		public String toString() { return list.toString(); }		
	}
	
	static class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

}
