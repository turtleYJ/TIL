package com.study.yooil.ocjp;

class Bird {
	public void fly() {
		System.out.print("Fly.");
	}
}

class Peacock extends Bird {
	public void dance() {
		System.out.print("Dance.");
	}
}

public class Test2 {
	
	
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
	
	public static void main(String[] args) {
		int x = 10;
		int y = ++x;
		int z = 0;
		if(y >= 10 || y <= ++x) {
			z = x;
		} else {
			z = x++;
		}
		
		System.out.println(z);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("abcde", 0, 3);
		
		System.out.println(sb);
	}
}
