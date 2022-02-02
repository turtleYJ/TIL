package com.study.yooil.basic.step5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		
		// 1. 최소, 최대
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = 0;
//		int i = 0;
//		String str = null;
//				
//		try {
//			N = Integer.parseInt(br.readLine());
//			String[] arr = new String[N];
//			int[] integer = new int[N];
//			arr = br.readLine().split(" ");
//			
//			while (!(i == N)) {
//				integer[i] = Integer.parseInt(arr[i]);
//				i += 1;
//			}
//			
//			Arrays.sort(integer);
//			
//			bw.write(integer[0] + " " + integer[N-1] );
//			
//			bw.flush();
//			bw.close();
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 2. 최댓값
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int i = 0;
//		int max = 0;
//		int maxIndex = 0;
//		int[] N = new int[9];
//		
//		while(i < 9) {
//			try {
//				N[i] = Integer.parseInt(br.readLine());
//				if (N[i] >= 100) {
//					System.out.println("100 보다 작은 수를 입력하시오");
//					return;
//				}
//			} catch (NumberFormatException | IOException e) {
//				e.printStackTrace();
//			}
//			i++;
//		}
//		
//		max = N[0];
//		
//		for(i = 0; i < N.length; i++) {
//			
//			if (N[i] > max) {
//				max = N[i];
//				maxIndex = i;
//			}
//		}
//		
//		maxIndex += 1;
//		
//		System.out.println(max);
//		System.out.println(maxIndex);
		
//		 3. 숫자의 개수
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int i = 0;
//		int temp = 0;
//		String result = null;
//		int[] N = new int[3];
//		int[] count = new int[10];
//		
//		while(i < 3) {
//			try {
//				N[i] = Integer.parseInt(br.readLine());
//				
//			} catch (NumberFormatException | IOException e) {
//				e.printStackTrace();
//			}
//			i++;
//		}
//		
//		result = "" + N[0] * N[1] * N[2];
//		
//		for(i = 0; i < result.length(); i++) {
//			temp = Integer.parseInt("" + result.charAt(i));
//			count[temp]++;
//		}
//		
//		for (int n : count) {
//			System.out.println(n);
//		}
		
		// 4. 나머지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i = 0;
		int temp = 0;
		int count = 0;
		int[] N1 = new int[10];
		int[] N2 = new int[10];
		int[] remainder = new int[42];
		
		while(i < 10) {
			try {
				N1[i] = Integer.parseInt(br.readLine());
				
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		i = 0;
		
		while(i < 10) {
			N2[i] = N1[i] % 42;
			i++;
		}
		
//		i = 0;
//		
//		while(i < 10) {
//			System.out.println(N2[i]);
//			i++;
//		}
		
		i = 0;
		
		while(i < 10) {
			temp = N2[i];
			remainder[temp]++;
			i++;			
		}
		
		i = 0;
		
		while(i < 42) {
			if(remainder[i] != 0) {
				count++;
			}			
			i++;
		}
		
		System.out.println(count);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
