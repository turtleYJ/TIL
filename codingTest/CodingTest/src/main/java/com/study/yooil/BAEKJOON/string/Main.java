package com.study.yooil.BAEKJOON.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10808
		String S = br.readLine();
		
		int[] alphabet = new int[26];
		
		int x = 0;
		
		for(int i = 0; i < S.length(); i++) {
			x = S.charAt(i) - 97;
			
			alphabet[x]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i : alphabet) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
		
		
	}

}
