package com.study.yooil.BAEKJOON.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] Sscore;
	static Integer[] dp;
//	static Long[][] dp ;
//	static Integer[][] dp;
	static long remain = 1000000000;
	static int[] wine;
	static int[][] seq;
//	static int[] seq;
	static Integer[] r_dp;
	static Integer[] l_dp;
	static char[] arrX;
	static char[] arrY;
	

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
		
//		// 11054 (LIS 알고리즘 응용)
//		int n = 0;
//		int max = -1;
//		int point = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		seq = new int[n];
//		r_dp = new Integer[n];
//		l_dp = new Integer[n];
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
//			r_dp[i] = 1;
//			
//			for(int j = 0; j < i; j++) {
//				if(seq[i] > seq[j] && r_dp[i] < r_dp[j] + 1) {
//					r_dp[i] = r_dp[j] + 1;
//				}
//			}
//		}
//		
//		for(int i = seq.length - 1; i >= 0; i--) {
//			l_dp[i] = 1;
//			
//			for(int j = seq.length - 1; j > i; j--) {
//				if(seq[i] > seq[j] && l_dp[i] < l_dp[j] + 1) {
//					l_dp[i] = l_dp[j] + 1;
//				}
//			}
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			dp[i] = r_dp[i] + l_dp[i] - 1;
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			if(dp[i] > max) {
//				max = dp[i];
//				
//			}
//		}
//		
//		System.out.println(max);
		
//		// 2565 (LIS 알고리즘 응용2)
//		int n = 0;
//		int max = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		seq = new int[n][2];
//		dp = new Integer[n];
//		
//		for(int i = 0; i < seq.length; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			seq[i][0] = Integer.parseInt(st.nextToken());
//			seq[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(seq, new Comparator<int[]>() {
//			
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
//		
//		for(int i = 0; i < seq.length; i++) {
//			dp[i] = 1;
//			
//			for(int j = 0; j < i; j++) {
//				if(seq[i][1] > seq[j][1]) {
//					dp[i] = Math.max(dp[i], dp[j] + 1);
//				}
//			}
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			max = Math.max(max, dp[i]);
//		}
//		
//		System.out.println(n - max);
		
		
//		// 9251 (LCS, Longest Common Sequence)
//		String Sx = "";
//		String Sy = "";
//		
//		Sx = br.readLine();
//		Sy = br.readLine();
//		
//		arrX = new char[Sx.length() + 1];
//		arrY = new char[Sy.length() + 1];
//		
//		dp = new Integer[arrX.length][arrY.length];
//		
//		for(int i = 1; i < arrX.length; i++) {
//			arrX[i] = Sx.charAt(i-1);
//		}
//		
//		for(int i = 1; i < arrY.length; i++) {
//			arrY[i] = Sy.charAt(i-1);
//		}
//		
////		System.out.println(Arrays.toString(arrX));
////		System.out.println(Arrays.toString(arrY));
//		
//		System.out.println(LCS(Sx.length(), Sy.length()));
		
//		// 1912
//		int n = 0;
//		int max = -100000;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//	
//		seq = new int[n];
//		dp = new Integer[n];
//		
//		for(int i = 0; i < seq.length; i++) {
//			seq[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		for(int i = n - 1; i >= 0; i--) {
//			sumSeq(i);
//		}
//		
//		for(int i = 0; i < seq.length; i++) {
//			max = Math.max(max, dp[i]);
//		}
//		
//		System.out.println(max);
		
//		// 11726
//		int n = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		dp = new Integer[n + 1];
//		
//		dp[0] = 0;
//		dp[1] = 1;
//		
//		if(n > 1) {
//			dp[2] = 2;
//		}
//				
//		
//		System.out.println(tiling(n));
		
//		// 12865 (못품)
//		int N = 0;
//		int K = 0;
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken()); // 물품의 수
//		K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
//		
//		dp = new Integer[N];
//		seq = new int[N][2];
//		
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			
//			seq[i][0] = Integer.parseInt(st2.nextToken());
//			seq[i][1] = Integer.parseInt(st2.nextToken());
//		}
//		
//		
//		
//		System.out.println(Knapsack(N - 1, K));
//		
//		System.out.println(Arrays.toString(dp));
		
		
	}
	
	
	
	
	
	
//	private static Integer Knapsack(int N, int K) {
//		if(N < 0) return 0;
//		
//		
//		if(dp[N] == null) {
//			if(seq[N][0] > K) {
//				dp[N] = Knapsack(N - 1, K);
//			} else {
//				dp[N] = Math.max(Knapsack(N - 1, K), Knapsack(N - 1, K - seq[N][0]) + seq[N][1]);
//			}
//			
//			
//		}
//		
//		return dp[N];
//	}
	
//	private static int tiling(int N) {
//		if(dp[N] == null) {
//			dp[N] = tiling(N - 1) + tiling(N - 2);
//		}
//		
//		return dp[N] % 10007;
//	}
	
//	private static int sumSeq(int N) {
//		if(N == -1) return 0;
//		if(dp[N] == null) {
//			
//			dp[N] = Math.max(sumSeq(N - 1) + seq[N], seq[N]);
//			
////			dp[N] = 0;
////			
////			if(seq[N] > 0) {
////				dp[N] = sumSeq(N - 1) + seq[N];
////			}
//		}
//		
//		return dp[N];
//	}
//	
//	private static int LCS(int x, int y) {
//		if(x == 0 || y == 0) {
//			dp[x][y] = 0;
//		}
//		
//		if(dp[x][y] == null) {
//			
//			if(arrX[x] == arrY[y]) {
//				dp[x][y] = LCS(x - 1, y - 1) + 1;
//			} else {
//				dp[x][y] = Math.max(LCS(x, y - 1), LCS(x - 1, y));
//			}
//		}
//		
//		return dp[x][y];
//	}
	
	
	
	
	
	
	
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
