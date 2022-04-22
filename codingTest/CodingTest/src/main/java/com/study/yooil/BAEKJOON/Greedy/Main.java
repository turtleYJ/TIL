package com.study.yooil.BAEKJOON.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 11047
//		int N = 0;
//		int K = 0;
//		int sum = 0;
//		int num = 0;
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken()); // 동전 개수
//		K = Integer.parseInt(st.nextToken()); // 가치의 합
//		
//		int[] arr = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		for(int i = N - 1; i >= 0; i--) {
//			if(arr[i] <= K) {
//				sum += K / arr[i];
//				K = K % arr[i];
//				
//				if(K == 0) break;
//			}
//		}
//		
//		System.out.println(sum);
		
//		// 1931
//		int N = 0;
//		int count = 0;
//		int end = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		int[][] arr = new int[N][2];
//		
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			arr[i][0] = Integer.parseInt(st.nextToken());
//			arr[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
////		for(int i = 0; i < N; i++) {
////			
////			System.out.println(arr[i][0] + " " + arr[i][1]);
////		}
//		
//		Arrays.sort(arr, (e1, e2) -> {
//			if(e1[1] - e2[1] == 0) {
//				return e1[0] - e2[0];
//			}
//			
//			return e1[1] - e2[1];
//		});
//
//		
////		for(int i = 0; i < N; i++) {
////			System.out.println(arr[i][0] + " " + arr[i][1]);
////		}
//		
//		for(int i = 0; i < N; i++) {
//			if(arr[i][0] >= end) {
//				end = arr[i][1];
//				
//				count++;
//			}
//		}
//		
//		System.out.println(count);
		
//		// 11399
//		int N = 0;
//		int sum = 0;
//		int result = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int[] time = new int[N];
//		
//		for(int i = 0; i < time.length; i++) {
//			time[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(time);
//		
//		for(int i = 0; i < time.length; i++) {
//			sum += time[i];
//			
//			result += sum;
//		}
//		
//		System.out.println(result);
		
//		// 1541
//		int sum = Integer.MAX_VALUE;
//		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
//		
//		while(subtraction.hasMoreTokens()) {
//			int temp = 0;
//			
//			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
//			
//			while(addition.hasMoreTokens()) {
//				temp += Integer.parseInt(addition.nextToken());
//			}
//			
//			if(sum == Integer.MAX_VALUE) {
//				sum = temp;
//			} else {
//				sum -= temp;
//			}
//		}
//		
//		System.out.println(sum);
		
		// 13305
		int N = 0;
		long sum = 0;
		
		N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N - 1];
		long[] cost = new long[N];
		
		StringTokenizer distST = new StringTokenizer(br.readLine()); 
		StringTokenizer costST = new StringTokenizer(br.readLine()); 
		
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(distST.nextToken());
			cost[i] = Integer.parseInt(costST.nextToken());
		}
		
		for(int i = 0; i < N - 1; i++) {
			if(cost[i] < cost[i + 1]) {
				cost[i + 1] = cost[i];
			}
			
			sum += dist[i] * cost[i];
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
