package com.study.yooil.BAEKJOON.step.step1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		
//		System.out.println("강한친구 대한육군");
//		System.out.println("강한친구 대한육군");
//		
//		// 구현(고양이)
//		System.out.println("\\    /\\");
//		System.out.println(" )  ( \')");
//		System.out.println("(  /  )");
//		System.out.println(" \\(__)|");
//		
//		System.out.println();
//		
//		// 구현(개)
//		System.out.println("|\\_/|");
//		System.out.println("|q p|   /}");
//		System.out.println("( 0 )\"\"\"\\");
//		System.out.println("|\"^\"`    |");
//		System.out.println("||_/=\\\\__|");
//		
//		// 수학, 구연 사칙연산		
//		Scanner sc = new Scanner(System.in);
//		int A, B;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		System.out.println(A + B);			
//		System.out.println(A - B);		
//		System.out.println(A * B);		
//		System.out.println(A / B);
//		System.out.println(A % B);
//		
//		// 수학, 구연 사칙연산2
//		Scanner sc = new Scanner(System.in);
//		int A, B, C;		
//		A = sc.nextInt();
//		B = sc.nextInt();		
//		C = sc.nextInt();
//		
//		System.out.println((A + B) % C);
//		System.out.println(((A % C) + (B % C)) % C);
//		System.out.println((A * B) % C);
//		System.out.println(((A % C) * (B % C)) % C);
		
		// 수학, 구연 사칙연산2
		Scanner sc = new Scanner(System.in);
		int A, B;	
		A = sc.nextInt();
		B = sc.nextInt();
		
		System.out.println(A * (B % 10));
		System.out.println(A * ((B % 100) / 10));
		System.out.println(A * (B / 100));
		System.out.println(A * B);
	}
	
	

}
