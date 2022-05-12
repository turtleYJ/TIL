package com.study.yooil.BAEKJOON.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10824
		String num1 = "";
		String num2 = "";
		long result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
			num1 = st.nextToken() + st.nextToken();
			num2 = st.nextToken() + st.nextToken();
			
			result = Long.parseLong(num1) + Long.parseLong(num2);
			
			System.out.println(result);
			
		
		
	}

}
