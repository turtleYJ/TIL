package com.study.yooil.BAEKJOON.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
	
	

	public static void main(String[] args) {
//		
		// 1. 정수 N개의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Test test = new Test();		
		List<Integer> arr = new ArrayList<>();
		int sum = 0;
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			while(st.hasMoreTokens()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			for (Integer i : arr) {
				sum += i;
			}
			
			System.out.println();
	
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		// 2. 셀프 넘버
//		int num = 0;		
//		int N = 1;
//		int i = 0;
//		ArrayList<Integer> temp = new ArrayList<>();
////		int[] temp = new int[10000];
//		
//		while(i < 10000) {
//			temp.add(i+1);
//			i++;
//		}
//		
//		while(N <= 10000) {
//			if(temp.contains(Integer.valueOf(N))) {
//				num = N;
//				while(num <= 10000) {
//					
//					num = num + num / 10000 + ((num % 10000) / 1000) + ((num % 1000) / 100) + ((num % 100) / 10) + (num % 10);
//					
//					temp.remove(Integer.valueOf(num));
//				}				
//			}
//			N++;
//		}
//		
//		for (int j : temp) {
//			System.out.println(j);
//		}
		
		// 3. 한수
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = 0;
//		int i = 1;
//		int a = 0; // 백의 자리
//		int b = 0; // 십의 자리
//		int c = 0; // 일의 자리
//		ArrayList<Integer> temp = new ArrayList<>();
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			a = N / 100;
//			b = (N % 100) / 10;
//			c = (N % 10);
//			
//			while(i <= N) {
//				
//				if(i < 100) {
//					temp.add(i);
//				} else if(i >= 100 && i <= 1000){
//					a = i / 100;
//					b = (i % 100) / 10;
//					c = (i % 10);
//					
//					if((a-b) == (b-c)) {
//						temp.add(i);
//					}
//				} else {
//					System.out.println("1000이하의 값을 입력하세요");
//					
//					return;
//				}
//				i++;
//			}
//			
//			System.out.println(temp.size());
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
