package com.study.yooil.BAEKJOON.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
//	static long[] arr;
//	static long[][] arr2;
//	static Integer[] dp;
//	static int[][][] dp2 = new int[21][21][21];
//	static long[] dp;
	static int[][] cost;
	static int[][] dp;
	static int[][] tri;
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2748번
//		int N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		arr = new long[N + 1];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = -1;
//		}
//		
//		arr[0] = 0; 
//	    arr[1] = 1; 
//		
//		System.out.println(fibonacci(N));
		
		
//		// 1003
//		int N = 0;
//		long[] result = null;
//		int n = 0;
//		int num = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		N = Integer.parseInt(br.readLine());
//		
//		while(n < N) {
//			num = Integer.parseInt(br.readLine());
//			
//			arr2 = new long[num + 1][2];
//			
//			for(int i = 0; i < arr2.length; i++) {
//				arr2[i][0] = -1;
//				arr2[i][1] = -1;
//			}
//			
//			arr2[0][0] = 1;
//			arr2[0][1] = 0;
//			if(num > 0 ) {
//				arr2[1][0] = 0;
//				arr2[1][1] = 1;
//			}
//			
//			
//			result = fibo(num);
//			
//			sb.append(result[0] + " " + result[1]).append('\n');
//			
//			n++;
//		}
//			
//		System.out.println(sb);
		
//		// 1463
//		// 2로 나누는 경우, 3으로 나누는 경우, 1을 빼는 경우
//		int N = 0;
//		N = Integer.parseInt(br.readLine());
//		
//		dp = new Integer[N+1];
//		
//		dp[0] = dp[1] = 0;
//		
//		System.out.println(func1003(N));
		
//		// 9183
//		int a = 0;
//		int b = 0;
//		int c = 0;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		while(true) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			a = Integer.parseInt(st.nextToken());
//			b = Integer.parseInt(st.nextToken());
//			c = Integer.parseInt(st.nextToken());
//			
//			if(a == -1 && b == -1 && c == -1) break;
//			
//			sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c)).append('\n');
//			
//		}
//		
//		System.out.println(sb);
		
//		// 9461
//		int T = 0;
//		StringBuilder sb = new StringBuilder();
//		
//		T = Integer.parseInt(br.readLine());
//		
//		dp = new long[101];
//		
//		
//		dp[1] = 1;
//		dp[2] = 1;
//		dp[3] = 1;
//		dp[4] = 2;
//		dp[5] = 2;
//		
//		
//		for(int i = 0; i < T; i++) {
//			sb.append(P(Integer.parseInt(br.readLine()))).append('\n');
//		}
//		
//		
//		System.out.println(sb);
		
//		// 1149
//		int T = 0;
//		
//		T = Integer.parseInt(br.readLine());
//		
//		cost = new int[T][3];
//		dp = new int[T][3];
//		
//		for(int i = 0; i < T; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			cost[i][0] = Integer.parseInt(st.nextToken());
//			cost[i][1] = Integer.parseInt(st.nextToken());
//			cost[i][2] = Integer.parseInt(st.nextToken());
//		}
//		
//		// 0 - 빨, 1 - 초, 2 - 파
//		dp[0][0] = cost[0][0];
//		dp[0][1] = cost[0][1];
//		dp[0][2] = cost[0][2];
//		
//		System.out.println(Math.min(Math.min(price(T-1, 0), price(T-1, 1)), price(T-1, 2)));
		
		// 1932
		T = 0;
		int max = 0;
		StringBuilder sb = new StringBuilder();
		
		T =  Integer.parseInt(br.readLine());
		
		tri = new int[T][T];
		dp = new int[T][T];
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < T; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = tri[0][0];
		
//		for(int i = 0; i < T; i++) {
//			for(int j = 0; j < T; j++) {
//				System.out.printf("%d ", dp[i][j]);
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < T; i++) {
			if(max < sum(T-1, i)) {
				max = sum(T-1, i);
			}
		}
		
		System.out.println(max);
		
		
		}
	
	
	
	private static int sum(int N , int X) {
		if(dp[N][X] == -1 && X == 0) {
			dp[N][X] = sum(N-1, X) + tri[N][X];
		} else if(dp[N][X] == -1 && X == N) {
			dp[N][X] = sum(N-1, X-1) + tri[N][X];
		} else if(dp[N][X] == -1) {
			dp[N][X] = Math.max(sum(N-1, X-1), sum(N-1, X)) + tri[N][X];
		}
		
		return dp[N][X];
	}
	
	
	
	
//	Red일 경우
//
//	Cost[N][0] = min( Cost[N-1][1], Cost[N-1][2] ) + Cost[N][0]
//
//	 
//
//	Green일 경우
//
//	Cost[N][1] = min( Cost[N-1][0], Cost[N-1][2] ) + Cost[N][1]
//
//	 
//
//	Blue일 경우
//
//	Cost[N][2] = min( Cost[N-1][0], Cost[N-1][1] ) + Cost[N][2]
	
//	private static int price(int N, int color) {
//		if(dp[N][color] == 0) {
////			Red일 경우
//			if(color == 0) {
//				return dp[N][color] = Math.min(price(N-1, 1), price(N-1, 2)) + cost[N][color];
//			}
////			Green일 경우
//			if(color == 1) {
//				return dp[N][color] = Math.min(price(N-1, 0), price(N-1, 2)) + cost[N][color];
//			}
////			Blue일 경우
//			if(color == 2) {
//				return dp[N][color] = Math.min(price(N-1, 0), price(N-1, 1)) + cost[N][color];
//			}
//		}
//		
//		
//		return dp[N][color];
//	}
//	
	
	
	
	
	
//	private static long P(int N) {
//		if(dp[N] != 0) {
//			return dp[N];
//		} else {
//			return dp[N] = P(N-1) + P(N-5);
//		}
//	}

//	static int w(int a, int b, int c) {
//		if(inRange(a, b, c) && dp2[a][b][c]  != 0) {
//			return dp2[a][b][c];
//		} 
//		
//		if(a <= 0 || b <= 0 || c <= 0) {
//			return 1;
//		} else if(a > 20 || b > 20 || c > 20) {
//			return dp2[20][20][20] = w(20, 20, 20);
//		} else if(a < b && b < c) {
//			return dp2[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
//		} else {
//			return dp2[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
//		}
//	}
//	
//	static boolean inRange(int a, int b, int c) {
//		return a > 0 && b > 0 && c > 0 && a < 21 && b < 21 && c < 21;
//	}
//		
//	static int func1003(int N) {
//		
//		if(dp[N] == null) {
//			if(N % 6 == 0) {
//				dp[N] = Math.min(func1003(N/3), Math.min(func1003(N/2), func1003(N-1))) + 1;
//			} else if (N % 2 == 0) {
//				dp[N] = Math.min(func1003(N/2), func1003(N-1)) + 1;
//			} else if (N % 3 == 0) {
//				dp[N] = Math.min(func1003(N/3), func1003(N-1)) + 1;
//			} else {
//				dp[N] = func1003(N-1) + 1;
//			}
//		}
//		
//		
//		return dp[N];
//	}	
//	
//	static long fibonacci(int n) {
//	    if(arr[n] == -1) {
//	    	arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
//	    }
//	    
//	    return arr[n];
//	}
//	
//	static long[] fibo(int N) {
//		if(arr2[N][0] == -1) {
//	    	arr2[N][0] = fibo(N - 1)[0] + fibo(N - 2)[0];
//	    	arr2[N][1] = fibo(N - 1)[1] + fibo(N - 2)[1];
//	    }
//		
//		return arr2[N];
//	}
	
	
}


	