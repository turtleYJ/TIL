package com.study.yooil.basic.step8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		// 1. 소수 찾기
//		int count = 0;
//		
//		try {
//			int N = Integer.parseInt(br.readLine());
//			
//			String[] strArr = new String[N];
//			int[] intArr = new int[N];
//			
//			strArr = br.readLine().split(" ");
//			
//			for(int i = 0; i < strArr.length; i++) {
//				intArr[i] = Integer.parseInt(strArr[i]);
//			}
//			
//			for(int i = 0; i < intArr.length; i++) {
//				if(intArr[i] == 1) {
//					continue;
//				} else if(intArr[i] == 2) {
//					count++;
//				} else {
//					count++;
//					
//					for(int j = 2; j < intArr[i]; j++) {
//						if(intArr[i] % j == 0) {
//							count--;
//							
//							break;
//						}
//					}
//				}
//			}
//			
//			System.out.println(count);
//			
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 2. 소수
//		int M = 0;
//		int N = 0;
//		int count = 0;
//		int sum = 0;
//		int minV = 0;
//		
//		try {
//			M = Integer.parseInt(br.readLine());
//			N = Integer.parseInt(br.readLine());
//			
//			if(M <= N) {
//				// 최소값
//				int k = M;
//				while(k <= N) {
//					count = 0;
//					for(int j = 1; j <= k; j++) {
//						if(k % j == 0) {
//							
//							count++;
//						}
//					}
//
//					if(count ==2) {
//						minV = k;
//						
//						break;
//					}
//					
//					k++;
//				}
//				
//				// 합산
//				for(int i = M; i <= N; i++) {
//						count = 0;
//						for(int j = 1; j <= i; j++) {
//							if(i % j == 0) {
//								
//								count++;
//							}
//						}
//						
//						if(count == 2) {
//							sum += i;
//						}
//				}
//				
//			} else { 
//				System.out.println("M은 N보다 작거나 같아야 합니다.");
//			}
//			
//			if(sum == 0) {
//				System.out.println("-1");
//			} else {
//				System.out.println(sum);
//				System.out.println(minV);
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		// 3. 소인수분해
//		int N = 0;
//		int temp = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			
//			temp = N;
//			
//			Roop1:
//			for(int i = 2; i <= N; i++) {
//				
//				while(temp % i == 0) {
//					temp /= i;
//					
//					System.out.println(i);
//					
//					if(temp == 1) {
//						break Roop1;
//					}
//				}
//				
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		// 4. 소수 구하기 (에라토스테네스의 체)
//		int M = 0;
//		int N = 0;
//		
//			StringTokenizer st;
//			try {
//				st = new StringTokenizer(br.readLine(), " ");
//				
//				M = Integer.parseInt(st.nextToken());
//				N = Integer.parseInt(st.nextToken());
//				
//				boolean arr[] = new boolean[N+1]; // 최대치의 수 만큼 배열 할당
//				
//				arr[0] = true;
//				arr[1] = true;
//				
//				for(int i = 2; i <= Math.sqrt(N+1); i++) {
//					// 아래에서 i의 제곱수 부터 검사를 시작함으로 전체범위의 제곱근까지 검사함.
//					for(int j = i*i; j < N+1; j += i) {
//						arr[j] = true;
//					}
//				}
//				
//				for(int i = M; i < N + 1; i++) {
//					if(arr[i] == false) {
//						System.out.println(i);
//					}
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
			// 베트트랑 공준
				try {
					
					
					while(true) {
						int n = 0;
						int count = 0;
						
						n = Integer.parseInt(br.readLine());
						
						if(n == 0) break;
						
						boolean[] arr = new boolean[2*n+1];
						
						arr[0] = true;
						arr[1] = true;
						
						for(int i = 2; i < Math.sqrt(2*n+1); i++) {
							for(int j = i*i; j < 2*n+1; j += i) {
								arr[j] = true;
							}
						}
						
						for(int i = n+1; i < 2*n+1; i++) {
							if(arr[i] == false) {
								count++;
							}
						}
						
						System.out.println(count);
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
