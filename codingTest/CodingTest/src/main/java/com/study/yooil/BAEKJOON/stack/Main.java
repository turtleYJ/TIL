package com.study.yooil.BAEKJOON.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

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
		
//		// 4949
//		StringBuilder sb = new StringBuilder();
//		while(true) {
//			Stack<Character> stack = new Stack<>();
//			String S = br.readLine();
//			
//			if(S.length() == 1) break;
//			
//			try {
//				for(int i = 0; i < S.length(); i++) {
//					if(S.charAt(i) == '(') {
//						stack.push('(');
//					}
//					
//					if(S.charAt(i) == ')') {
//						if(stack.peek() == '(') {
//							stack.pop();
//						} else {
//							break;
//						}
//					}
//
//					if(S.charAt(i) == '[') {
//						stack.push('[');
//					}
//					
//					if(S.charAt(i) == ']') {
//						if(stack.peek() == '[') {
//							stack.pop();
//						} else {
//							break;
//						}
//					}
//				}
//				
//				if(stack.size() == 0) {
//					sb.append("yes").append('\n');
//				} else {
//					sb.append("no").append('\n');
//				}
//			} catch (Exception e) {
//				sb.append("no").append('\n');
//			}
//			
//			
//			
//		}
//		
//		System.out.println(sb);
		
		
		
//		// 1874
//		int start = 0;
//		int N = 0;
//		StringBuilder sb = new StringBuilder();
//		Stack<Integer> stack = new Stack<>();
//		
//		N = Integer.parseInt(br.readLine());
//		
//		while(N-- > 0) {
//			int value = 0; 
//			
//			value = Integer.parseInt(br.readLine());
//			
//			if(value > start) {
//				for(int i = start + 1; i <= value; i++) {
//					stack.push(i);
//					
//					sb.append('+').append('\n');
//				}
//				
//				start = value;
//			} else if(stack.peek() != value) {
//				System.out.println("NO");
//				
//				return;
//			} 
//			stack.pop();
//				
//			sb.append('-').append('\n');
//		
//		}
//		
//		System.out.println(sb);
		
//		// 17298
//		int N = 0;
//		Stack<Integer> stack = new Stack<>();
//		StringBuilder sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int[] seq = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			seq[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		for(int i = 0; i < N; i++) {
//			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
//				seq[stack.pop()] = seq[i];
//			}
//			
//			stack.push(i);
//		}
//		
//		while(!stack.isEmpty()) {
//			seq[stack.pop()] = -1;
//		}
//		
//		for(int i = 0; i < N; i++) {
//			sb.append(seq[i]).append(' ');
//		}
//		
//		System.out.println(sb);
		
//		// 10799
//		int result = 0;
//		String S = br.readLine();
//		Stack<Character> stack = new Stack<>();
//		
//		for(int i = 0; i < S.length(); i++) {
//			if(S.charAt(i) == '(') {
//				stack.push('(');
//			} else {
//				stack.pop();
//				
//				if(S.charAt(i - 1) == '(') {
//					result += stack.size();
//				} else {
//					result += 1;
//				}
//			}
//		}
//		
//		System.out.println(result);
		
//		// 17413
//		String S = br.readLine();
//		
//		Stack<Character> stack = new Stack<>();
//		boolean flag = false;
//		
//		for(int i = 0; i < S.length(); i++) {
//			
//			if(S.charAt(i) == '<') {
//				flag = true;
//				
//				while(!stack.isEmpty()) {
//					System.out.print(stack.pop());
//				}
//				
//				System.out.print(S.charAt(i));
//				
//				continue;
//			} else if(S.charAt(i) == '>') {
//				flag = false;
//				
//				System.out.print(S.charAt(i));
//				continue;
//			} else if(S.charAt(i) == ' ') {
//				while(!stack.isEmpty()) {
//					System.out.print(stack.pop());
//				}
//				
//				System.out.print(S.charAt(i));
//				
//				continue;
//			}
//			
//			if(flag == true) {
//				System.out.print(S.charAt(i));
//			}
//			
//			if(flag == false) {
//				stack.push(S.charAt(i));
//			}
//			
//			if(i == S.length() - 1) {
//				while(!stack.isEmpty()) {
//					System.out.print(stack.pop());
//				}
//			}
//			
//		}
		
//		// 17299
//		int N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		int[] count = new int[1000001];
//		int[] seq = new int[N];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int i = 0;
//		
//		while(st.hasMoreTokens()) {
//			int x = Integer.parseInt(st.nextToken());
//			
//			seq[i] = x;
//			count[x]++;
//			
//			i++;
//		}
//		
//		Stack<Integer> stack = new Stack<>();
//		
//		for(int j = 0; j < N; j++) {
//			
//			while(!stack.isEmpty() && count[seq[stack.peek()]] < count[seq[j]]) {
//				seq[stack.pop()] = seq[j];
//			}
//			
//			stack.push(j);
//			
//			// 시간 초과
////			for(int k = j + 1; k < N; k++) {
////				if(count[seq[j]] < count[seq[k]]) {
////					seq[j] = seq[k];
////					
////					break;
////				}
////				
////				if(k == N - 1) {
////					seq[j] = -1;
////				}
////			}
////			
////			if(j == 6) {
////				seq[j] = -1;
////			}
//		}
//		
//		while(!stack.isEmpty()) {
//			seq[stack.pop()] = -1;
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for (int result : seq) {
//			sb.append(result + " ");
//		}
//		
//		System.out.println(sb);
		
//		// 1918
//		String S = br.readLine();
//		
//		Stack<Character> stack = new Stack<Character>();
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i = 0; i < S.length(); i++) {
//			char x = S.charAt(i);
//			
//			switch (x) {
//			case '+':
//			case '-':
//			case '*':
//			case '/':
//				while(!stack.isEmpty() && priority(stack.peek()) >= priority(x)) {
//						sb.append(stack.pop());
//				}
//				
//				stack.push(x);
//				
//				break;
//			case '(':
//				stack.push(x);
//				
//				break;
//			case ')':				
//				while(true) {
//					
//					if(stack.peek() == '(') {
//						stack.pop();
//						
//						break;
//					}
//					
//					sb.append(stack.pop());
//				}
//				
//				break;
//			default:
//				sb.append(x);
//				break;
//			}
//						
//		}
//		
//		while(!stack.isEmpty()) {
//			sb.append(stack.pop());
//		}
//		
//		System.out.println(sb);
		
		// 1935
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		double[] alp = new double[N]; // 0 index가 A이다.(-65)
		Stack<Double> stack = new Stack<>();
		
		String postfix = br.readLine();
		
		for(int i = 0 ; i < N; i++) {
			alp[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < postfix.length(); i++) {
			double A = 0;
			double B = 0;
			
			char x = postfix.charAt(i);
			
			switch (x) {
			case '+':
				B = stack.pop();
				A = stack.pop();
				stack.push(A + B);
				
				break;
			case '-':
				B = stack.pop();
				A = stack.pop();
				stack.push(A - B);
				
				break;
			case '*':
				B = stack.pop();
				A = stack.pop();
				stack.push(A * B);
				
				break;
			case '/':
				B = stack.pop();
				A = stack.pop();
				stack.push(A / B);
				
				break;
			default:
				stack.push(alp[x-65]);
				
				break;
			}
		}
		
		System.out.printf("%.2f", stack.pop());
		
	}

	
	
	
	
//	static int priority(char op) {
//		if(op == '*' || op == '/') {
//			return 2;
//		} else if(op == '+' || op == '-') {
//			return 1;
//		} else {
//			return 0;
//		}
//	}

	
	
	
	
//	static void push1(int x) {
//		size1++;
//		arr1[size1 - 1] = x;
//	}
//	
//	static void push2(int x) {
//		size2++;
//		arr2[size2 - 1] = x;
//	}
//	
//	private static void pop1() {
//		if(size1 < 1) {
////			System.out.println(-1);
//			size1--;
//		} else {
////			System.out.println(arr[size - 1]);
//			arr1[size1 - 1] = 0;
//			size1--;
//		}
//	}
//	
//	private static void pop2() {
//		if(size2 < 1) {
////			System.out.println(-1);
//			size2--;
//		} else {
////			System.out.println(arr[size - 1]);
//			arr2[size2 - 1] = 0;
//			size2--;
//		}
//	}
	
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
