package com.study.yooil.BAEKJOON.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		// 10808
//		String S = br.readLine();
//		
//		int[] alphabet = new int[26];
//		
//		int x = 0;
//		
//		for(int i = 0; i < S.length(); i++) {
//			x = S.charAt(i) - 97;
//			
//			alphabet[x]++;
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i : alphabet) {
//			sb.append(i + " ");
//		}
//		
//		System.out.println(sb);
		
//		//2743
//		String S = br.readLine();
//		
//		System.out.println(S.length());
		
		// 10820
		StringBuilder sb = new StringBuilder();
		
		String S = "";
		
		while((S = br.readLine()) != null) {
						
			int[] count = new int[4]; // 0 - 소문자, 1 - 대문자, 2 - 숫자, 3 - 공백
			
			int x = 0;
			for(int i = 0; i < S.length(); i++) {
				
				x = S.charAt(i);
				
				if(x >= 97 && x <= 122) {
					count[0]++;
				} else if(x >= 65 && x <= 90) {
					count[1]++;
				} else if(x >= 48 && x <= 57) {
					count[2]++;
				} else {
					count[3]++;
				}
				
			}
			
			for (int i : count) {
				sb.append(i + " ");
			}
			
			sb.append('\n');
			
		}
		
		
		System.out.println(sb);
	}

}
