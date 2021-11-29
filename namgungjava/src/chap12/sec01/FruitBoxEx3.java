package chap12.sec01;

import java.util.ArrayList;


public class FruitBoxEx3 {
	static interface Eatable {}
	
	static class Fruit implements Eatable { public String toString() {return "Fruit";}}
	static class Apple extends Fruit { public String toString() { return "Apple"; }}
	static class Grape extends Fruit { public String toString() { return "Grape"; }}
	
	static class Juice {
		String name;
		Juice(String name) {
			this.name = name;
		}
		public String toString() {
			return this.name;
		}		
	}
	static class Juicer{
//this work
//		static Juice makeJuice(FruitBox<?> box) { 
		static Juice makeJuice(FruitBox<? extends Fruit> box) {
		
			String tmp = "";
			for(Fruit f : box.getList()) tmp+= f + "";
			return new Juice(tmp);	
		}
	}
	public static void main(String [] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		
		
		
		
	}
	
	static class Box<T> {
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) { list.add(item); }
		T get(int i) { return list.get(i); }
		int size() { return list.size(); }
		ArrayList<T> getList() { return list; }
		public String toString() { return list.toString(); }		
	}
	
	static class FruitBox<TT extends Fruit & Eatable> extends Box<TT> {}

}
