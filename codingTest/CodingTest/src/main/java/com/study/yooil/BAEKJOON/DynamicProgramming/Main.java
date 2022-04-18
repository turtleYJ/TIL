package com.study.yooil.BAEKJOON.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] Sscore;
	static Integer[] dp;
//	static Long[][] dp ;
	static long remain = 1000000000;
	static int[] wine;
	static int[] seq;
	static Integer[] r_dp;
	static Integer[] l_dp;
	

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		// 2579
//		int T = 0;
//		
//		T = Integer.parseInt(br.readLine());
//		
//		Sscore = new int[T+1];
//		dp = new int[T+1];
//		
//		for(int i = 1; i <= T; i++) {
//			Sscore[i] = Integer.parseInt(br.readLine());
//		}
//		
//		for(int i = 0; i <= T; i++) {
//			dp[i] = -1;
//		}
//		
//		dp[0] = Sscore[0];
//		dp[1] = Sscore[1];
//		
//		if (T >= 2) {
//			dp[2] = dp[1] + Sscore[2];
//		}
//		
//		System.out.println(Smax(T));
		
//		// 10844
//		int T = 0;
//		long result = 0;
//		
//		T = Integer.parseInt(br.readLine());
//		
//		dp = new Long[T+1][10];
//		
//		for(int i = 0; i < 10; i++) {
//			dp[1][i] = 1L;
//		}
//		
//		for(int i = 1; i < 10; i++) {
//			result += func10844(T, i);
//		}
//		
//		System.out.println(result % remain);
		
//		// 2156
//		int n = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		wine = new int[n+1];
//		dp = new Integer[n+1];
//		
//		for(int i = 1; i < n + 1; i++) {
//			wine[i] = Integer.parseInt(br.readLine());
//		}
//		
//		dp[0] = 0;
//		dp[1] = wine[1];
//		if(n > 1) {
//			dp[2] = wine[1] + wine[2];
//		}
//		
//		System.out.println(func2156(n));
		
//		// 11053(LIS 알고리즘)
//		int n = 0;
//		int max = -1;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		seq = new int[n];
//		dp = new Integer[n];
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		for(int i = 0; i < seq.length; i++) {
//			
//			seq[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			dp[i] = 1;
//			
//			for(int j = 0; j < i; j++) {
//				if(seq[i] > seq[j] && dp[i] < dp[j] + 1) {
//					dp[i] = dp[j] + 1;
//				}
//			}
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			if(dp[i] > max) {
//				max = dp[i];
//			}
//		}
//		
//		System.out.println(max);
		
		// 11054 (LIS 알고리즘 응용)
		int n = 0;
		int max = -1;
		int point = 0;
		
		n = Integer.parseInt(br.readLine());
		
		seq = new int[n];
		r_dp = new Integer[n];
		l_dp = new Integer[n];
		dp = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < seq.length; i++) {
			
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < seq.length; i++) {
			r_dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(seq[i] > seq[j] && r_dp[i] < r_dp[j] + 1) {
					r_dp[i] = r_dp[j] + 1;
				}
			}
		}
		
		for(int i = seq.length - 1; i >= 0; i--) {
			l_dp[i] = 1;
			
			for(int j = seq.length - 1; j > i; j--) {
				if(seq[i] > seq[j] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1;
				}
			}
		}
		
		for(int i = 0; i < seq.length; i++) {
			dp[i] = r_dp[i] + l_dp[i] - 1;
		}
		
		for(int i = 0; i < seq.length; i++) {
			if(dp[i] > max) {
				max = dp[i];
				
			}
		}
		
		System.out.println(max);
	}
	
	
	
	
	
	
	
	
	
//	private static int recur11053(int N) {
//		
//		if(dp[N] == null) {
//			dp[N] = 1;
//			
//			for(int i = N - 1; i >= 0; i--) {
//				if(seq[i] < seq[N]) {
//					dp[N] = Math.max(recur11053(i) + 1, dp[N]); 
//				} 
//			}
//			
//		}
//		
//		return dp[N];
//		
//	}
	
	
//	private static int func2156(int N) {
//		if(dp[N] == null) {
//			dp[N] = Math.max(func2156(N - 1), Math.max(func2156(N - 2), func2156(N - 3) + wine[N - 1]) + wine[N]);
//		}
//		
//		return dp[N];
//	}
	
//	private static long func10844(int digit, int val) {
//		if(digit == 1) {
//			return dp[digit][val]; 
//		}
//		
//		if(dp[digit][val] == null) {
//			if(val == 0) {
//				dp[digit][val] = func10844(digit - 1, 1);
//			} else if(val == 9) {
//				dp[digit][val] = func10844(digit - 1, 8);
//			} else {
//				dp[digit][val] = func10844(digit - 1, val - 1) + func10844(digit - 1, val + 1);
//			}
//		}
//		
//		return dp[digit][val] % remain;
//	}
	
//	private static int Smax(int N) {
//		if(dp[N] == -1) {
//			dp[N] = Math.max(Smax(N-2), Smax(N-3) + Sscore[N - 1]) + Sscore[N];
//		}
//		
//		
//		return dp[N];
//	}

}
