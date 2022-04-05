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
	}
}
