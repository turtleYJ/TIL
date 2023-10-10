package ch11_컬렉션프레임워크;

import java.util.*;

class Fruit				  { public String toString()  { return "Fruit";}}
class Apple extends Fruit { public String toString()  { return "Apple";}}
class Grape extends Fruit { public String toString()  { return "Grape";}}
class Toy				  { public String toString()  { return "Toy"  ;}}

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box();
		Box<Apple> appleBox = new Box();
		Box<Toy> toyBox = new Box();
//		Box<Grape> grapeBox = new Box<Apple>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
		appleBox.add(new Apple());
//		appleBox.add(new Toy());
		
		toyBox.add(new Toy());
//		toyBox.add(new Apple());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
	
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);		}
	T get(int i)	 { return list.get(i);  }
	int size()		 { return list.size();  }
	public String toString()  { return list.toString();}
}
