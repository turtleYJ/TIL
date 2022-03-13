package com.study.yooil.basic.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
//		
//		// 1. 정수 N개의 합
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Test test = new Test();
//		
//		int[] a;
//		try {
//			a = new int[Integer.parseInt(br.readLine())];
//			
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			for(int i = 0; i < a.length; i++) {
//				a[i] = Integer.parseInt(st.nextToken());
//			}
//					
//			System.out.println(test.sum(a));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// 2. 셀프 넘버
		int num = 0;		
		int N = 1;
		int i = 0;
		ArrayList<Integer> temp = new ArrayList<>();
//		int[] temp = new int[10000];
		
		while(i < 10000) {
			temp.add(i+1);
			i++;
		}
		
		while(N <= 10000) {
			if(temp.contains(Integer.valueOf(N))) {
				num = N;
				while(num <= 10000) {
					
					num = num + num / 10000 + ((num % 10000) / 1000) + ((num % 1000) / 100) + ((num % 100) / 10) + (num % 10);
					
					temp.remove(Integer.valueOf(num));
				}				
			}
			N++;
		}
		
		for (int j : temp) {
			System.out.println(j);
		}
		
		
	}
	
	

}
