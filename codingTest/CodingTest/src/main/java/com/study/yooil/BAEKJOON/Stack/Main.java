package com.study.yooil.BAEKJOON.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr1;
	static int[] arr2;
	static int size1;
	static int size2;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		// 10828
//		int N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		arr = new int[N];
//		
//		while(N-- > 0) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			switch (st.nextToken()) {
//			case "push":
//				push(Integer.parseInt(st.nextToken()));
//				
//				break;
//			case "pop":
//				pop();
//				
//				break;
//			case "size":
//				size();
//				
//				break;
//			case "empty":
//				empty();
//				
//				break;
//			case "top":
//				top();
//				
//				break;
//			}
//		}
		
//		// 10773
//		int K = 0;
//		int sum = 0;
//		
//		K = Integer.parseInt(br.readLine());
//		
//		arr = new int[K];
//		
//		while(K-- > 0) {
//			int x = Integer.parseInt(br.readLine());
//			
//			switch (x) {
//			case 0:
//				pop();
//				
//				break;
//				
//			default:
//				push(x);
//				
//				break;
//			}
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] == 0) break;
//			
//			sum += arr[i];
//		}
//		
//		System.out.println(sum);
		
//		// 9012
//		int N = 0;
//		sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		
//		while(N-- > 0) {
//			int sum = 0;
//			char x = '\u0000';
//			size = 0;
//			
//			String S = br.readLine();
//			
//			arr = new int[S.length()];
//			
//			for(int i = 0; i < S.length(); i++) {
//				if(size < 0) {
//					break;
//				}
//				
//				x = S.charAt(i);
//				
//				switch (x) {
//				case '(':
//					push(1);
//					
//					break;
//				case ')':
//					pop();
//					
//					break;
//				}
//			}
//			
//			for (int i : arr) {
//				sum += i;
//			}
//			
//			if(size == 0) {
//				sb.append("YES").append('\n');
//			} else {
//				sb.append("NO").append('\n');
//			}
//		}
//		
//		System.out.println(sb);
		
		// 4949
		int N = 0;
		sb = new StringBuilder();
		
		while(true) {
			char x = '\u0000';
			int n = 0;
			size1 = 0;
			size2 = 0;
			
			String S = br.readLine();
			
			n = S.length();
			
			if(n == 1) break;
			
			arr1 = new int[n]; // ()
			arr2 = new int[n]; // []
			
			for(int i = 0; i < S.length(); i++) {
				if(size1 < 0 || size2 < 0) {
					break;
				}
				
				x = S.charAt(i);
				
				switch (x) {
				case '(':
					push1(1);
					
					break;
				case '[':
					push2(1);
					
					break;
				case ')':
					pop1();
					
					break;
				case ']':
					pop2();
					
					break;
				default:
					continue;
				}
			}
			
			if(size1 == 0 && size2 == 0) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}

	
	
	
	
	static void push1(int x) {
		size1++;
		arr1[size1 - 1] = x;
	}
	
	static void push2(int x) {
		size2++;
		arr2[size2 - 1] = x;
	}
	
	private static void pop1() {
		if(size1 < 1) {
//			System.out.println(-1);
			size1--;
		} else {
//			System.out.println(arr[size - 1]);
			arr1[size1 - 1] = 0;
			size1--;
		}
	}
	
	private static void pop2() {
		if(size2 < 1) {
//			System.out.println(-1);
			size2--;
		} else {
//			System.out.println(arr[size - 1]);
			arr2[size2 - 1] = 0;
			size2--;
		}
	}
	
//	private static void size() {
//		System.out.println(size);
//	}
//	
//	private static void empty() {
//		if(size == 0) {
//			System.out.println(1);
//		} else {
//			System.out.println(0);
//		}
//	}
//	
//	private static void top() {
//		if(size == 0) {
//			System.out.println(-1);
//		} else {
//			System.out.println(arr[size - 1]);
//		}
//	}
	
}
