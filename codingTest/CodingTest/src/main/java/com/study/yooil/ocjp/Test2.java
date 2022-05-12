package com.study.yooil.ocjp;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.study.yooil.ocjp.test.Acc;

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

// **
//class C1 {}
//class C2 extends C1 {}
//class C3 extends C2 {}

//class MyException extends RuntimeException{}

//// 174
//class Caller {
//	void init() {
//		System.out.println("Indslkfj");
//	}
//	
//	void start() {
//		init();
//		System.out.println("dsfsad");
//	}
//}

public class Test2 {
//	// 174
//	public static void main(String[] args) {
//		Caller c = new Caller();
//		c.start();
//		c.init();
//		
//	}
	
	// **
//	public static void main(String[] args) {
//		C1 obj1 = (C1) new C2();
//		C2 obj2 = (C2) new C3();
//		C2 obj3 = (C2) new C1();
//		C3 obj4 = (C3) obj2;
//	}
	
//	public static void main(String[] args) {
//		Bird b = new Peacock();
//		Peacock p = (Peacock) b;
//		p.fly();
//		p.dance();
//	}
	
//	public static void main(String[] args) {
//		Peacock p = new Peacock();
//		p.fly();
//		p.dance();
//	}
	
//	public static void main(String[] args) {
//		try {
//			int num = 10;
//			int div = 0;
//			int ans = num / div;
//		} catch (ArithmeticException ae e) {
//			ans = 0;
//		} catch (Exception e2) {
//			System.out.println("Invalid calculation");
//		}
//		System.out.println("Answer = " + ans);
//	}
	
//	public static void main(String[] args) {
//		int x = 10;
//		int y = ++x;
//		int z = 0;
//		if(y >= 10 || y <= ++x) {
//			z = x;
//		} else {
//			z = x++;
//		}
//		
//		System.out.println(z);
//		
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("abcde", 0, 3);
//		
//		System.out.println(sb);
//	}
	
//	public static void main(String[] args) {
//		int numbers[] = {12, 13, 42};
//		int[] keys = findMax(numbers);
//		
//	}
//
//	private static int[] findMax(int[] numbers) {
//		int[] keys = new int[3];
//		
//		return keys;
//	}
	
//	public static void main(String[] args) {
//		System.out.println(Math.random());
//	}
	
//	public static void main(String[] args) {
//		int nums1[] = {1, 2, 3};
//		int nums2[] = {1, 2, 3, 4, 5};
//		nums2 = nums1;
//		for (int x : nums2) {
//			System.out.print(x + ":");
//		}
//	}
	
//	public static void main(String[] args) {
//		int array[] = new int[3];
//		array = {1, 2, 3};
//	}
	
//	public static void main(String[] args) {
//		Acc obj = new Test2();
//		
//		System.out.println(obj.s);
//	}
	
//	public static void main(String[] args) {
//		int[][] arr = new int[2][4];
//		arr[0] = new int[] {1, 3, 5, 7};
//		arr[1] = new int[] {1, 3};
//		
//		for(int[] a : arr) {
//			for(int i : a) {
//				System.out.print(i + "");
//			}
//			System.out.println();
//		}
//	}
	
	// 191
//	public static void doSum(Integer x, Integer y) {
//		System.out.println("Integer");
//	}
//	public static void doSum(double x, double y) {
//		System.out.println("double");
//	}
//	public static void doSum(float x, float y) {
//		System.out.println("float");
//	}
//	
//	public static void doSum(long x, long y) {
//		System.out.println("long");
//	}
//	
//	public static void doSum(short x, short y) {
//		System.out.println("short");
//	}
//	
//	public static void main(String[] args) {
//		doSum(10, 20);
//		doSum(10.0, 20.0);
//	}
	
	// 
//	class Vehicle {
//		
//	}
//	
//	class Car extends Vehicle {
//		int y
//		
//		Car() {
//			super();
//			this(20);
//		}
//		
//		Car(int y) {
//			this.y = y
//		}
//	}
	
//	// 210
//	public static final int Min = 1;
//	
//	public static void main(String[] args) {
//		int x = args.length;
//		if(checkLimit(x)) {
//			System.out.println("Java Se");
//		} else {
//			System.out.println("Java EE");
//		}
//	}
//
//	private static boolean checkLimit(int x) {
//		
//		return (x >= Min) ? true : false;
//	}
	
	// 213
//	public static void main(String[] args) {
//		String ta = "A ";
//		ta = ta.concat("B ");
//		String tb = "C ";
//		ta = ta.concat(tb);
//		ta.replace('C', 'D');
//		ta = ta.concat(tb);
//		
//		System.out.println(ta);
//	}
	
//	// 221
//	static public void main(String[] args) {
//		char colorCode = 'y';
//		
//		switch (colorCode) {
//		case 'r':
//			int color = 100;
//			break;
//		case 'b':
//			color = 100;
//			break;
//		case 'y':
//			color = 100;
//			break;
//		}
//		
//		System.out.println(color);
//	}
	
//	// 223
//	static public void main(String[] args) {
//		LocalDate date2 = LocalDate.of(6, 20, 2014);
//		LocalDate date3 = LocalDate.parse("2014-06-20", DateTimeFormatter.ISO_DATE);
//		
//		System.out.println(date2);
//	}
	
//	static double area;
//	int b = 2, h = 3;
//	public static void main(String[] args) {
//		double p, b, h;
//		if(area == 0) {
//			b = 3;
//			h = 4;
//			p = 0.5;
//			area = p * b * h;
//		}
//		System.out.println(area);
//	}
	
//	// 129
//	public static void main(String[] args) {
//		try {
//			method1();
//		} catch (MyException ne) {
//			System.out.println("A");
//		}
//	}
//	
//	public static void method1() {
//		try {
//			throw 3 > 10 ? new MyException() : new IOException();
//		} catch (IOException e) {
//			System.out.println("I");
//		} catch (Exception re) {
//			System.out.println("B");
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
