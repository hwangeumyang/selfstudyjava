package chap12.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FruitBoxEx4 {
	
	static class Fruit {
		String name;
		int weight;
		
		public Fruit(String name, int weight) {
			this.name = name;
			this.weight = weight;
		}
		
		public String toString() { return name + "(" + weight + ")"; }
	}
	
	static class Apple extends Fruit{
		Apple(String name, int weight) {
			super(name, weight);
		}
	}
	static class Grape extends Fruit{
		Grape(String name, int weight) {
			super(name, weight);
		}
	}
	
	static class FruitComp implements Comparator<Fruit> {
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o2.weight - o1.weight;
		}
	}
	static class AppleComp implements Comparator<Apple> {
		@Override
		public int compare(Apple a1, Apple a2) {
			return a1.weight - a2.weight;
		}
	}
	static class GrapeComp implements Comparator<Grape> {
		@Override
		public int compare(Grape g1, Grape g2) {
			return g1.weight - g2.weight;
		}
	}
	

	
	
	public static void main(String [] args) {
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		
		appleBox.add(new Apple("greenApple", 300));
		appleBox.add(new Apple("greenApple", 100));
		appleBox.add(new Apple("greenApple", 200));
		
		grapeBox.add(new Grape("GreenGrape", 400));
		grapeBox.add(new Grape("GreenGrape", 300));
		grapeBox.add(new Grape("GreenGrape", 200));
		
		Collections.sort(appleBox.getList(), new AppleComp());
		Collections.sort(grapeBox.getList(), new GrapeComp());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		
	}
	static class FruitBox<T extends Fruit> extends Box<T>{}
	
	static class Box<T> {
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) {
			list.add(item);
		}
		T get(int i) {
			return list.get(i);
		}
		ArrayList<T> getList() {
			return list;
		}
		int size() {
			return list.size();
		}
		public String toString() {
			return list.toString();
		}		
	}

}
