package com.study.yooil.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] numbersS = br.readLine().split(", ");
		int[] numbers = new int[numbersS.length];
		
		for(int i = 0; i < numbersS.length; i++) {
			numbers[i] = Integer.parseInt(numbersS[i]);
		}
		
		String hand = "";
		
		hand = br.readLine();
		
		System.out.println(solution(numbers, hand));
	}
	
	static public String solution(int[] numbers, String hand) {
        String answer = "";
        int tempR = 0;
        int tempL = 0;
        int dstR = 0;
        int dstL = 0;
        
        int i = 0;
        
        while(i < numbers.length) {
        	int k = 0;
        	
        	k = numbers[i];
        	
        	switch (k) {
	     		case 1:
	     		case 4:
	     		case 7:
	     			System.out.print("L");
	     			tempL = k;
	     			break;
	     		case 3:
//	     			if()
	     		case 6:
	     		case 9:
	     			System.out.print("R");
	     			tempR = k;
	     			break;
	     		case 2:
	     		case 5:
	     		case 8:
	     		case 0:
	     			System.out.print("R");
	     			tempR = k;
	     			break;
	
     		}
        	
        	i++;
        }
        
        
        answer += "" + 1;
        
        return answer;
		
		
    }
}
