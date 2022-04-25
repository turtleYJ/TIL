package com.study.yooil.BAEKJOON.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
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
		
//		// 13305
//		int N = 0;
//		long sum = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		long[] dist = new long[N - 1];
//		long[] cost = new long[N];
//		
//		StringTokenizer distST = new StringTokenizer(br.readLine()); 
//		StringTokenizer costST = new StringTokenizer(br.readLine()); 
//		
//		for(int i = 0; i < N - 1; i++) {
//			dist[i] = Integer.parseInt(distST.nextToken());
//			cost[i] = Integer.parseInt(costST.nextToken());
//		}
//		
//		for(int i = 0; i < N - 1; i++) {
//			if(cost[i] < cost[i + 1]) {
//				cost[i + 1] = cost[i];
//			}
//			
//			sum += dist[i] * cost[i];
//		}
//		
//		System.out.println(sum);
		
//		// 1026
//		int N = 0;
//		int sum = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer stA = new StringTokenizer(br.readLine());
//		StringTokenizer stB = new StringTokenizer(br.readLine());
//		
//		Integer[] arrA = new Integer[N];
//		Integer[] arrB = new Integer[N];
//		
//		for(int i = 0; i < arrA.length; i++) {
//			arrA[i] = Integer.parseInt(stA.nextToken());
//			arrB[i] = Integer.parseInt(stB.nextToken());
//		}
//		
//		Arrays.sort(arrA);
//		Arrays.sort(arrB, Collections.reverseOrder());
//		
//		for(int i = 0; i < arrA.length; i++) {
//			sum += arrA[i] * arrB[i];
//		}
//		
//		System.out.println(sum);
		
//		// 5585
//		int price = 0;
//		int count = 0;
//		
//		price = 1000 - Integer.parseInt(br.readLine());
//		
//		count += price / 500;
//		
//		count += price % 500 / 100;
//		
//		count += price % 100 / 50;
//		
//		count += price % 50 / 10;
//		
//		count += price % 10 / 5;
//		
//		count += price % 5 / 1;
//		
//		System.out.println(count);
		
//		// 2217
//		int N = 0;
//		int result = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		int[] lope = new int[N]; 
//		
//		for(int i = 0; i < N; i++) {
//			lope[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(lope);
//		
//		for(int i = 0; i < N; i++) {
//			result = Math.max(result, lope[i] * (N - i));
//		}
//		
//		System.out.println(result);
		
//		// 10610
//		String num = br.readLine();
//		int sum = 0;
//		String result = "";
//		
//		Integer[] arr = new Integer[num.length()];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int)num.charAt(i) - 48;
//		}
//		
//		Arrays.sort(arr, Collections.reverseOrder());
//		
//		for(int i = 0; i < arr.length - 1; i++) {
//			sum += arr[i];
//		}
//		
//		if(arr[arr.length - 1] != 0 || sum % 3 != 0) {
//			System.out.println(-1);
//		} else {
//			for(int i = 0; i < arr.length; i++) {
//				result += arr[i] + "";
//			}
//			
//			System.out.println(result);
//		}
		
//		// 1789
//		long sum = 0;
//		long S = Long.parseLong(br.readLine());
//		int i = 1;
//		int count = 0;
//		
//		while(sum <= S) {
//			sum += i;
//			
//			i++;
//			count++;
//			
//		}
//		
//		System.out.println(count - 1);
		
//		// 1946
//		int n = 0;
//		int k = 0;
//		int N = 0;
//		int min_of_itv = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		while(k < n) {
//			int count = 1;
//			
//			N = Integer.parseInt(br.readLine());
//			
//			int[][] score = new int[N][2];
//			
//			for(int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				
//				score[i][0] = Integer.parseInt(st.nextToken());
//				score[i][1] = Integer.parseInt(st.nextToken());
//			}
//			
//			Arrays.sort(score, (e1, e2) -> {
//				return e1[0] - e2[0];
//			});
//			
//			min_of_itv = score[0][1];
//			
//			for(int i = 1; i < N; i++) {
//				if(score[i][1] < min_of_itv) {
//					min_of_itv = score[i][1];
//					count++;
//				}
//			}
//			
//			System.out.println(count);
//			
////			for(int i = 0; i < N; i++) {
////				System.out.println(score[i][0] + " " + score[i][1]);
////			}
//			
//			k++;
//		}
		
		// 1715
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }

        int ans = 0;
        
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            ans += a+b;
            pq.add(a+b);
        }
        
        System.out.println(ans);
    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
