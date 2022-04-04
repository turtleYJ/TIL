package com.study.yooil.BAEKJOON.step2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 1. 두 수 비교하기
//		Scanner sc = new Scanner(System.in);
//		int a, b;
//		
//		a = sc.nextInt();
//		b = sc.nextInt();
//		
//		if (a > b) {
//			System.out.println(">");
//		} else if (a < b) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}
		
		
		// 2. 시험 성적
//		Scanner sc = new Scanner(System.in);
//		int a;
//		
//		a = sc.nextInt();
//		
//		if (100 >= a && a >= 90) {
//			System.out.println("A");
//		} else if (89 >= a && a >= 80) {
//			System.out.println("B");
//		} else if (79 >= a && a >= 70) {
//			System.out.println("C");
//		} else if (69 >= a && a >= 60) {
//			System.out.println("D");
//		} else {
//			System.out.println("F");
//		}
		
		// 3. 윤년
//		Scanner sc = new Scanner(System.in);
//		int a;
//		
//		a = sc.nextInt();
//		
//		if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
//			System.out.println("1");
//		} else {
//			System.out.println("0");
//		}
		
//		4. 사분면 고르기
//		Scanner sc = new Scanner(System.in);
//		int a, b;
//		
//		a = sc.nextInt();
//		b = sc.nextInt();
//		
//		if (a > 0 && b > 0) {
//			System.out.println("1");
//		} else if (a < 0 && b > 0) {
//			System.out.println("2");
//		} else if (a < 0 && b < 0) {
//			System.out.println("3");
//		} else if (a > 0 && b < 0) {
//			System.out.println("4");
//		}
		
		// 5. 알람 시계
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		a = sc.nextInt();
		b = sc.nextInt();
		 
		if (b >= 45) {
			System.out.println(a + " " + (b-45));
		} else if (b < 45 && a != 0) {
			System.out.println((a-1) + " " + (15+b));
		} else if (b < 45 && a == 0) {
			System.out.println(23 + " " + (15+b));
		}
	}
}
