package com.study.yooil.basic.step3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = 0;
//		
//		a = sc.nextInt();
//		
//		for (int i = 1; i < 10; i++) {
//			System.out.printf("%d * %d = %d\n", a, i, a*i);
//		}
		
		// 2. A + B
//		Scanner sc = new Scanner(System.in);
//		int T = 0;
//		
//		T = sc.nextInt();
//		
//		int[] A = new int[T];
//		int[] B = new int[T];
//		
//		for(int i = 0; i < T; i++) {
//			A[i] = sc.nextInt();
//			B[i] = sc.nextInt();
//		}
//		
//		for(int i = 0; i < T; i++) {
//			System.out.println(A[i] + B[i]);
//		}
		
		// 3. 합
//		Scanner sc = new Scanner(System.in);
//		int n = 0;
//		int sum = 0;
//		
//		n = sc.nextInt();
//		
//		for(int i = 1; i < n+1; i++) {
//			sum += i;
//		}
//		
//		System.out.println(sum);
		
		
		// 4. 빠른 A + B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 0;
		
		try {
			T = Integer.parseInt(br.readLine());
			int[] A = new int[T];
			int[] B = new int[T];
			String[] arr = new String[2];
			
			for(int i = 0; i < T; i++) {
				arr = br.readLine().split(" ");
				A[i] = Integer.parseInt(arr[0]); 
				B[i] = Integer.parseInt(arr[1]); 
			}
			
			for(int i = 0; i < T; i++) {
				bw.write(A[i] + B[i] + "\n");
			}
			
			bw.flush();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}

}
