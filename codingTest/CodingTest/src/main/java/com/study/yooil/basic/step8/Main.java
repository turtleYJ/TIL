package com.study.yooil.basic.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
//		// 1. 손익분기점
//		String[] arrStr = new String[3];
//		int[] arrInt = new int[3];
//		int A1 = 0; // 고정비
//		int A2 = 0; // 유지비
//		int B = 0; // 개당 판매 액
//		
//		try {
//			arrStr = br.readLine().split(" ");
//			
//			for(int i = 0; i < arrStr.length; i++) {
//				arrInt[i] = Integer.parseInt(arrStr[i]);
//			}
//			
//			A1 = arrInt[0];
//			A2 = arrInt[1];
//			B = arrInt[2];
//			
//			if(A2 >= B) {
//				System.out.println("-1");
//				
//				return;
//			} else {
//				System.out.println(A1 / (B-A2) + 1);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		// 2. 벌집 (보류)
//		int n = 1;
		
//		// 4. 달팽이는 올라가고 싶다.
//		
//		try {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			int A = 0;
//			int B = 0;
//			int V = 0;
//			int day = 0;
//			
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//			V = Integer.parseInt(st.nextToken());
//			
//			// 5 1 10
//			day = (V - B) / (A - B);
//			
//			if((V-B) % (A-B) != 0) {
//				
//				day++;
//			} 
//			
//			bw.write(day + "");
//			bw.flush();
//			bw.close();
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 5. ACM 호텔
//		try {
//			int n = Integer.parseInt(br.readLine());
//			
//			String[] S = new String[n];
//			int[] result = new int[n];
//			
//			for(int i = 0; i < S.length; i++) {
//				S[i] = br.readLine();
//			}
//			
//			for(int i = 0; i < S.length; i++) {
//				int A = Integer.parseInt(S[i].split(" ")[0]);
//				int B = Integer.parseInt(S[i].split(" ")[1]);
//				int C = Integer.parseInt(S[i].split(" ")[2]);
//				
//				if(C % A != 0) {
//					result[i] = C % A * 100 + C / A + 1;
//				} else {
//					result[i] = A * 100 + C / A ;
//				}
//			}
//			
//			for (int i : result) {
//				System.out.println(i);
//			}
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 6. 부녀회장이 될테야
		
		int[][] apt = new int[15][14];
		
		// 호(-1 해주어야 한다.
		for(int j = 0; j < 14; j++) {
			apt[0][j] = j+1;
		}
		
		// 층(그대로)
		for(int i = 0; i < 15; i++) {
			apt[i][0] = 1;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 14; j++) {
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				System.out.println(apt[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine()) - 1]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
