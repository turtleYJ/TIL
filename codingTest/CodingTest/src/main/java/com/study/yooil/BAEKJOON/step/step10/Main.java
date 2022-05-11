package com.study.yooil.BAEKJOON.step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		// 1. 블랙잭
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringTokenizer st2 = new StringTokenizer(br.readLine());
//		
//		int n = 0;
//		int target = 0;
//		int temp = 0;
//		int max = 0;
//		
//		n = Integer.parseInt(st.nextToken());
//		target = Integer.parseInt(st.nextToken());
//		
//		int[] arr = new int[n];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = Integer.parseInt(st2.nextToken());
//		}
//		
//		for(int i = n-1; i > 1; i--) {
//			for(int j = i-1; j > 0; j--) {
//				for(int k = j-1; k > -1; k--) {
//					temp = arr[i] + arr[j] + arr[k];
//					
//					if(temp > max && temp <= target) {
//						max = temp;
//					}
//				}
//			}
//		}
//		
//		System.out.println(max);
		
//		// 2.  분해합
//		String tempStr = "";
//		int n = 0;
//		int minus = 0;
//		int temp = 0;
//		int sum = 0;
//		int result = 0;
//		
//		n = Integer.parseInt(br.readLine());
//		
//		
//		
//		while(temp != n/2) {
//			sum = 0;
//			minus--;
//			temp = n + minus;
//			
//			tempStr = Integer.toString(temp);
//			
//			for(int i = 0; i < tempStr.length(); i++) {
//				sum += tempStr.charAt(i) - 48;
//			}
//			
//			if(sum == Math.abs(minus)) {
//				result = temp;
//			}
//			
//		}
//		
//		System.out.println(result);
		
//		// 3. 덩치
//		int N = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		int[][] arr = new int[N][2];
//		
//		int[] rank = new int[N];
//		
//		
//		
//		for(int i = 0; i < arr.length; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			for(int j = 0; j < 2; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		for(int i = 0; i < rank.length; i++) {
//			rank[i] = 1;
//			for(int j = 0; j < arr.length; j++) {
//				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
//					rank[i]++;
//				}
//			}
//		}
//		
//		for (int i : rank) {
//			System.out.printf("%d ", i);
//		}
		
//		// 4. 체스판 다시 칠하기
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = 0; // 행
//		int N1 = 0;
//		int M = 0; // 열
//		int M1 = 0;
//		int count = 0;
//		int BminCount  = 2500;
//		int WminCount  = 2500;
//		String S = "";
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		// B로 시작
//		char[][] Barr = new char[8][8];
//		
//		// W로 시작
//		char[][] Warr = new char[8][8];
//		
//		// input
//		char[][] input = new char[N][M];
//		
//		for(int i = 0; i < Warr.length; i++) {
//			for(int j = 0; j < Warr.length; j++) {
//				if(i % 2 == 0 &&j % 2 == 0) {
//					Warr[i][j] = 'W';
////					sb.append('W');
//				} else if(i % 2 == 0 &&j % 2 == 1) {
//					Warr[i][j] = 'B';
////					sb.append('B');
//				} else if(i % 2 == 1 &&j % 2 == 0) {
//					Warr[i][j] = 'B';
////					sb.append('B');
//				} else if(i % 2 == 1 &&j % 2 == 1) {
//					Warr[i][j] = 'W';
////					sb.append('W');
//				}
//			}
////			sb.append('\n');
//		}
//		
//		for(int i = 0; i < Barr.length; i++) {
//			for(int j = 0; j < Barr.length; j++) {
//				if(i % 2 == 0 && j % 2 == 0) {
//					Barr[i][j] = 'B';
////					sb.append('B');
//				} else if(i % 2 == 0 &&j % 2 == 1) {
//					Barr[i][j] = 'W';
////					sb.append('W');
//				} else if(i % 2 == 1 &&j % 2 == 0) {
//					Barr[i][j] = 'W';
////					sb.append('W');
//				} else if(i % 2 == 1 &&j % 2 == 1) {
//					Barr[i][j] = 'B';
////					sb.append('B');
//				}
//			}
////			sb.append('\n');
//		}
//		
//		// input 값을 입력
//		for(int i = 0; i < input.length; i++) {
//			S = br.readLine();
//			for(int j = 0; j < input[0].length; j++) {
//				input[i][j] = S.charAt(j);
//			}
//		}
//		
////		// input 값 출력
////		for(int i = 0; i < input.length; i++) {
////			for(int j = 0; j < input[0].length; j++) {
////				sb.append(input[i][j]);
////			}
////			sb.append('\n');
////		}
//		while(N1 <= N - 8) {
//			while(M1 <= M - 8) {
//				count = 0;
//				
//				for(int i = 0; i < 8; i++) {
//					for(int j = 0; j < 8; j++) {
//						if(input[N1+i][M1+j] != Barr[i][j]) {
//							count++;
//							
//						}
//					}
//				}
//				if(count < BminCount) {
//					BminCount = count;
//				}
//				M1++;
//			}
//			N1++;
//			M1 = 0;
//		}
//		
//		N1 = 0;
//		M1 = 0;
//		
//		while(N1 <= N - 8) {
//			while(M1 <= M - 8) {
//				count = 0;
//				
//				for(int i = 0; i < 8; i++) {
//					for(int j = 0; j < 8; j++) {
//						if(input[N1+i][M1+j] != Warr[i][j]) {
//							count++;
//						}
//					}
//				}
//				if(count < WminCount) {
//					WminCount = count;
//				}
//				M1++;
//			}
//			N1++;
//			M1 = 0;
//		}
//		
//		if(WminCount > BminCount) {
//			System.out.println(BminCount);
//		} else {
//			System.out.println(WminCount);
//		}
		
//		// 5. 영화감독 숌
//		int N = 0;
//		int num = 0;
//		int count = 0;
//		
//		N = Integer.parseInt(br.readLine());
//		
//		while(count != N) {
//			num++;
//			
//			if(Integer.toString(num).contains("666")){
//				
//				count++;
//			}
//			
//		}
//		
//		
//		
//		System.out.println(num);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
