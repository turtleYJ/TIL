package Polymorphism;

class A {
	void exe() {
		System.out.println("A");
	}
};

class B extends A {
	void exe() {
		System.out.println("B");
	}
};

class C extends A {
	void exe() {
		System.out.println("C");
	}
};

public class Main {

	public static void main(String[] args) {
		
//		A var1 = new A(); // 자신(A)을 인스턴스로 생성
//		
//		// Up Casting
//		A var2 = new B(); // 자식(B)을 인스턴스로 생성
//		A var3 = new C(); // 자식(C)을 인스턴스로 생성
//		
//		// Down Casting
//		// var1, var2의 type이 A -> B로 바뀜. (부모에서 자식으로)
//		B var4 = (B)var2;
//		B var5 = (B)var1;
//		
//		// instanceof 연산자
//		// 		표현식
//		/* 		if(레퍼런스 instanceof 클래스타입) {
//		 * 			// true일때 처리할 내용.
//		 * 		}
//		 */
//		
//		if(var3 instanceof A) {
//			System.out.println("O");
//        } else {
//        	System.out.println("X");
//        }
//		
//		if(var3 instanceof B) {
//			System.out.println("O");
//		} else {
//			System.out.println("X");
//		}
//		
//		if(var3 instanceof C) {
//			System.out.println("O");
//		} else {
//			System.out.println("X");
//		}
		
		// 동적 바인딩
		C var1 = new C();
		var1.exe();
		
		A var2 = null;
		var2 = (A)var1;
		var2.exe();
		
	}

}
