package com.study.yooil.basic.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
//		// 1. 아스키 코드
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int a = 0;
//		
//		try {
//			a = (int)(br.readLine().charAt(0));
//			
//			System.out.println(a);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 2. 숫자의 합
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = 0;
//		String[] arr = null;
//		int sum = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			arr = new String[N];
//			
//			arr = br.readLine().split("");
//			
//			for(int i = 0; i < arr.length; i++) {
//				sum += Integer.parseInt(arr[i]); 
//			}
//			
//			System.out.println(sum);
//			
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 3. 알파벳 찾기
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		ArrayList<Character> al = new ArrayList<>();
//		String str = null;
//		
//		
//		try {
//			str = br.readLine();
//			
//			for(int i = 0; i < str.length(); i++) {
//				al.add(str.charAt(i));
//			}
//			
//			for(int j = 97; j < 123; j++) {
//				
//				char ch = (char)j;
//
//				System.out.print(al.indexOf(ch) + " ");
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		// 4. 문자열 반복
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = 0;
//		int k = 0;
//		char ch = 0;
//		
//		try {
//			
//			n = Integer.parseInt(br.readLine());
//			
//			int[] N = new int[n];
//			String[] S = new String[n];
//			
//			StringBuilder sb = new StringBuilder();
//			
//			
//			while(k < n) {
//				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//				
//				N[k] = Integer.parseInt(st.nextToken());
//				S[k] = st.nextToken();
//				
//				for(int i = 0; i < S[k].length(); i++) {
//					ch = S[k].charAt(i);
//					for(int j = 0; j < N[k]; j++) {
//						sb.append(ch);
//					}
//				}
//				
//				sb.append("\n");
//				
//				k++;
//			}
//			
//			System.out.println(sb);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		// 5. 단어 공부 (!! 못품)
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String S = null;
//		int n = 0;
//		int max = 0;
//		char maxCh = '\u0000';
//		
//		try {
//			S = br.readLine().toLowerCase();
//			
//			n = S.length();
//			
//			char[] ch = new char[n];
//			int[] count = new int[n];
//			
//			// 대입해준다.
//			for(int i = 0; i < n; i++) {
//				ch[i] = S.charAt(i);
//			}
//			
//			// 축출
//			for(int i = 0; i < n; i++) {
//				
//				 count[i] = countChar(S, ch[i]); 
//				 
//				 if(i > 0 && ch[i] != ch[i-1]) {
//					 if(max == count[i-1]) {
//						 System.out.println("?");
//						 return;
//					 } else if(max < count[i]) {
//						 max = count[i];
//					 } 
//				 }
//			}
//			
//			System.out.println(max);
//			
//			System.out.println(maxCh);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		// 7. 상수
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] strArr = new String[2];
//		int[] intArr = new int[2];
//		String[] temp = new String[2];
//		
//		try {
//			strArr = br.readLine().split(" ");
//			
//			for(int i = 0; i < 2; i++) {
//				temp[i] = Character.toString(strArr[i].charAt(2)) + strArr[i].charAt(1) + strArr[i].charAt(0);
//			}
//			
//			if(Integer.parseInt(temp[0]) > Integer.parseInt(temp[1])) {
//				System.out.println(temp[0]);
//			} else if(Integer.parseInt(temp[0]) == Integer.parseInt(temp[1])) {
//				System.out.println("서로 다른 수를 입력하시오");
//			} else {
//				System.out.println(temp[1]);
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
	
		// 8. 다이얼
		
		// 각 문자당 걸리는 시간 : 2 + (n-1)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = null;
		int sum = 0;
		
		try {
			S = br.readLine();
			
			char[] ch = new char[S.length()];
			
			for(int i = 0; i < S.length(); i++) {
				ch[i] = S.charAt(i);
				
				switch (ch[i]) {
				case 'A':
				case 'B':
				case 'C':
					sum += 3;
					break;
				case 'D':
				case 'E':
				case 'F':
					sum += 4;
					break;
				case 'G':
				case 'H':
				case 'I':
					sum += 5;
					break;
				case 'J':
				case 'K':
				case 'L':
					sum += 6;
					break;
				case 'M':
				case 'N':
				case 'O':
					sum += 7;
					break;
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
					sum += 8;
					break;
				case 'T':
				case 'U':
				case 'V':
					sum += 9;
					break;
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					sum += 10;
					break;
				}
			}
			
			System.out.println(sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
//	public static int countChar(String str, char ch) {
//		
//		return str.length() - str.replace(String.valueOf(ch), "").length();
//	}

}
