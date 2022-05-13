package com.study.yooil.ocjp;

//interface Readable {
//	public void readBook();
//	public void setBookMark();
//}
//
//abstract class Book implements Readable {
//	public void readBook() {}
//}
//
//class EBook extends Book {
//
//	@Override
//	public void setBookMark() {
//		// TODO Auto-generated method stub
//		
//	}
//}

// 117
class Bird {
	public void fly() {
		System.out.println("Fly.");
	}
}

class Peacock extends Bird {
	Peacock() {
		System.out.println("Peacock 인스턴스 생성");
	}
	
	public void dance() {
		System.out.println("Dance");
	}
}

public class Test3 {
	
	
	
	public static void main(String[] args) {
		//117
		Bird p = new Peacock();
		p.fly();
		((Peacock) p).dance();
		
		// 3
//		String[] strs = {"A", "B"};
//		int idx = 0;
//		for(String s : strs) {
//			strs[idx].concat("asdf");
//			idx++;
//		}
//		for(idx = 0; idx < strs.length; idx++) {
//			System.out.println(strs[idx]);
//		}
		
//		StringBuilder sb = new StringBuilder();
	
//		// case
//		int y2 = 100;
//		float fit = y2;
//		
//		System.out.println(fit);
		
//		// 12
//		int ans;
//		try {
//			int num = 10;
//			int div = 0;
//			ans = num / div;
//		} catch (ArithmeticException ae) {
//			ans = 0;
//		} catch (Exception e) {
//			System.out.println("dslkjfas");
//		}
//		
//		System.out.println("Answer = " + ans);
		
		// 34
//		int n[][] = {{1, 3}, {2, 4}};
//		for (int i = n.length - 1; i >= 0; i--) {
//			for(int y : n[i]) {
//				System.out.println(y);
//			}
//		}
		
//		// 53
//		int x;
//		x = 0;
//		
//		do {
//			System.out.print("*");
//		} while (x++ < 3);
		
//		String[] strs = new String[2];
//		String str = "";
//		
//		System.out.println(strs[0].concat("asdf"));
//		System.out.println(str);
		
//		// 106
//		int numbers[];
//		numbers = new int[2];
//		numbers[0] = 10;
//		numbers[1] = 20;
//		
//		numbers = new int[4];
//		numbers[2] = 30;
//		numbers[3] = 40;
//		for(int x : numbers) {
//			System.out.println(" " + x);
//		}
		
//		// 116
//		Short s1 = 200;
//		Integer s2 = 400;
////		String s3 = (String) (s1 + s2);
//		Long s4 = (long) s1 + s2;
//		System.out.println(s4);
		
		
		
		
	}
	
//	public static void main(String[] args) {
//		
//		Book book1 = new EBook();
//		book1.readBook();
//
//	}

}
