package com.study.yooil.ocjp.test;

// problem 1
//class Bird {
//	public void fly() {
//		System.out.print("Fly.");
//	}
//}
//
//class Peacock extends Bird {
//	public void dance() {
//		System.out.print("Dance.");
//	}
//}

//// problem 2
//interface I {
//	public void displayI(); 
//}
//
//abstract class C2 implements I {
//	public void displayC2() {
//		System.out.println("C2");
//	}
//}
//
//class C1 extends C2 {
//	public void displayI() {
//		System.out.println("C1");
//	}
//}

//problem 3
class Base {
	public void test() {
		System.out.println("Base ");
	}
}
class DerivedA extends Base {
	public void test() {
		System.out.println("DerivedA ");
	}
}
class DerivedB extends DerivedA {
	public void test() {
		System.out.println("DerivedB ");
	}
}

public class Polymorphism {
	// problem 1
//	public static void main(String[] args) {
//		Bird b = new Peacock();
//		Peacock p = (Peacock) b;
//		p.fly();
//		p.dance();
//	}
//	
//	public static void main(String[] args) {
//		Peacock p = new Peacock();
//		p.fly();
//		p.dance();
//	}
	
//	// problem 2
//	public static void main(String[] args) {
//		C2 obj1 = new C1();
//		I obj2 = new C1();
//		
//		C2 s = (C2) obj2;
//		I t = obj1;
//		
//		t.displayI();
//		s.displayC2();
//	}
	
	// problem 3
	public static void main(String[] args) {
		Base b1 = new DerivedB();
		Base b2 = new DerivedA();
		Base b3 = new DerivedB();
		Base b4 = b3;
		b1 = (Base) b2;
		b1.test();
		b4.test();
	}
	
	


}


