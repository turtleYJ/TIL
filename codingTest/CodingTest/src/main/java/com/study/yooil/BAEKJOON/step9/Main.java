package com.study.yooil.BAEKJOON.step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static StringBuilder sb = null;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		// 1. 팩토리얼
//		
//		int n = 0;
//		int sum = 0;
//		
//		try {
//			n = Integer.parseInt(br.readLine());
//			
//			sum = factorial(n);
//			
//			System.out.println(sum);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 2. 피보나치 수
//		int n = 0;
//		int result = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		result = Fibonacci(n);
//		
//		System.out.println(result);
		
//		// 3. 별 찍기 - 10(*****)
//		int N = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		
//		arr = new char[N][N];
//		
//		starMaker(0, 0, N, false);
//		
//		// i - 행, j - 열
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				sb.append(arr[i][j]);
//			}
//			sb.append('\n');
//		}
//		
//		System.out.println(sb);
		
		// 4. 하노이 탑 이동 순서(*****)
		int N = 0;
		int result = 0;
		
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 3, 2);
		
		System.out.println(count);
		
		System.out.println(sb);
	}
	
	

	
	private static void hanoi(int N, int from, int to, int remain) {
		
		
		if(N == 0) return;
		
		count++;
		
		// 바로 전전
		hanoi(N-1, from, remain, to);
		sb.append(from + " " + to + "\n");
		// 바로 전
		hanoi(N-1, remain, to, from);
	}




	private static void starMaker(int x, int y, int N, boolean blank) {
		// 공백인 경우
		if(blank) {
			for(int i = x; i < x + N; i++) {
				for(int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			
			return;
		}
		
		// 더이상 쪼갤 수 없을 때
		if(N == 1) {
			arr[x][y] = '*';
			
			return;
		}
		
		
		// 기본
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					starMaker(i, j, size, true);
				} else {
					starMaker(i, j, size, false);
				}
			}
		}
		
		
	}


	private static int Fibonacci(int n) {
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		}
		
		return Fibonacci(n-1) + Fibonacci(n-2);
	}


	// 재귀 함수
	public static int factorial(int n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
