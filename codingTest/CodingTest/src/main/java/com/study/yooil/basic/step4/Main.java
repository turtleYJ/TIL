package com.study.yooil.basic.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		// 1. A + B - 5
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int A = 0;
//		int B = 0;
//		String[] arr =  new String[2];
//		
//		try {
//			while(true) {			
//			arr = br.readLine().split(" ");
//			A = Integer.parseInt(arr[0]);
//			B = Integer.parseInt(arr[1]);	
//			
//			if(A == 0 && B == 0) {
//				break;
//			}
//			bw.write(A + B + "\n");
//			}
//			
//			bw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();			
//		}
		
		// 2. A + B - 4
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        String input;
//        StringBuilder sb = new StringBuilder();
//        
//        try {
//			while((input = br.readLine()) != null){
//			    st = new StringTokenizer(input, " ");
//			    
//			    int A = Integer.parseInt(st.nextToken());
//			    int B = Integer.parseInt(st.nextToken());
//			    
//			    
//			    sb.append((A+B)).append("\n");
//			}
//		} catch (NumberFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(sb);
//    
        // 3. 더하기 사이클
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = 0;
        int N1 = 0;
        int count = 0;
        
		try {
			N = Integer.parseInt(br.readLine());
			
			N1 = N;
			
			
			do {
				N = (N % 10) * 10 + (N / 10 + N % 10) % 10;
				count += 1;
			} while (!(N == N1));
			
			bw.write(count + "");
			bw.close();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
