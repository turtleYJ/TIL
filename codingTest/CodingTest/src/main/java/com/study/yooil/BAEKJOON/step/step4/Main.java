package com.study.yooil.BAEKJOON.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int i = 0;
//		int temp = 0;
//		int count = 0;
//		int[] N1 = new int[10];
//		int[] N2 = new int[10];
//		int[] remainder = new int[42];
//		
//		while(i < 10) {
//			try {
//				N1[i] = Integer.parseInt(br.readLine());
//				
//			} catch (NumberFormatException | IOException e) {
//				e.printStackTrace();
//			}
//			i++;
//		}
//		
//		i = 0;
//		
//		while(i < 10) {
//			N2[i] = N1[i] % 42;
//			i++;
//		}
//		
////		i = 0;
////		
////		while(i < 10) {
////			System.out.println(N2[i]);
////			i++;
////		}
//		
//		i = 0;
//		
//		while(i < 10) {
//			temp = N2[i];
//			remainder[temp]++;
//			i++;			
//		}
//		
//		i = 0;
//		
//		while(i < 42) {
//			if(remainder[i] != 0) {
//				count++;
//			}			
//			i++;
//		}
//		
//		System.out.println(count);
//		
//		// 5. 평균
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = 0;
//		double max = 0;
//		double result = 0;
//		double sum = 0;
//		
//		try {
//			N = Integer.parseInt(br.readLine());
//			if(N <= 1000) {
//				String[] score = new String[N];
//				Double[] intScore = new Double[N];
//				score = br.readLine().split(" ");
//				
//				
//				
//				// 대입 반복문
//				for(int i = 0; i < N; i++) {
//					intScore[i] = Double.parseDouble(score[i]); 
//				}
//				
//				Arrays.sort(intScore, Collections.reverseOrder());
//				
//				max = intScore[0];
//				
//				// 계산 및 대입 반복문
//				for(int i = 0; i < N; i++) {
//					intScore[i] = intScore[i] / max * 100;
//					
//					sum += intScore[i];
//				}
//				
//				result = sum / N;
//				
//				System.out.println(Arrays.toString(intScore));
//				System.out.println(result);
//			} else {
//				System.out.println("1000보다 적은 수를 입력하세요");
//			}
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		// 5. 평균(re)
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		try {
//			double arr[] = new double[Integer.parseInt(br.readLine())];
//			
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			for(int i = 0; i < arr.length; i++) {
//				arr[i] =  Double.parseDouble(st.nextToken());
//			}
//			
//			double sum = 0;
//			Arrays.sort(arr);
//			
//			for(int i = 0; i < arr.length; i++) {
//				sum += arr[i] / arr[arr.length - 1] * 100;
//			}
//			
//			System.out.println(sum/arr.length);
//			
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		
//		// 6. OX퀴즈
//	
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		try {
//			
//			int N = Integer.parseInt(br.readLine());
//			int[] sum = new int[N];
//			int temp = 0;
//		
//			String[] arr = new String[N];
//			for(int i = 0; i < arr.length; i++) {
//				arr[i] = br.readLine();
//				
//				temp = 0;
//				
//				for(int j = 0; j < arr[i].length(); j++) {
//					if(arr[i].charAt(j) == 'O') {
//						temp += 1;
//						
//						sum[i] += temp;						
//					} else if(arr[i].charAt(j) == 'X') {
//						temp = 0;
//					}
//				}
//			}
//			
//			for (int i : sum) {
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
		
		// 7. 평균은 넘겠지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			int[] size = new int[N];
			int[][] arr2 = null;
			double[] sum = new double[N];
			double[] avg = new double[N];
			double[] result = new double[N];
			double[] count = new double[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine();
				
				StringTokenizer st = new StringTokenizer(arr[i], " ");
				
				size[i] = Integer.parseInt(st.nextToken());				
				
				arr2 = new int[N][size[i]];
				
				for(int j = 0; j < size[i]; j++) {
					arr2[i][j] = Integer.parseInt(st.nextToken());
					
					sum[i] += arr2[i][j];
				}
				
				avg[i] = sum[i] / size[i];
				
				for(int j = 0; j < size[i]; j++) {
					if(arr2[i][j] > avg[i]) {
						count[i] += 1;
					}
				}
				
//				System.out.println(count);
				
				result[i] = count[i] / size[i] * 100;
				
//				System.out.println(avg);
//				System.out.println(result);
//				System.out.println(Arrays.toString(arr2));
				
				
			}

			for (double d : result) {
				System.out.println(String.format("%.3f", d) + "%");
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
