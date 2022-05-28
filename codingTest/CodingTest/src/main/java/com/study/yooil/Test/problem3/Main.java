package com.study.yooil.Test.problem3;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] day;
	static Integer[] DP;
	static int[][] masks;
	static int max;
	static int min;

	public static void main(String[] args) {
		String[] S = {"2022/05/02", "2022/05/01", "2022/05/07", "2022/05/05", "2022/05/08", "2022/05/13~2022/05/15", "2022/05/14~2022/05/17", "2022/05/01~2022/05/02", "2022/05/16"};
		int[][] mask = {{3200, 4}, {2300, 2}, {1100, 1}, {4200, 6}};
		
		
//		for(int i = 0; i < S.length; i++) {
//			System.out.println(S[i]);
//		}
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//
//		LocalDate date = LocalDate.parse(S[0], formatter);
//		
//		System.out.println(date.getDayOfYear());
		
//		String SS = "~";
//		
//		System.out.println(SS.contains("~"));;
		
		
		day = new int[3651]; // 2021 ~ 2030년의 일 수를 인덱스로 표현함.
		DP = new Integer[3651]; // 2021 ~ 2030년의 일 수를 인덱스로 표현함.
		masks = mask;
		
		Arrays.sort(masks, (o1, o2) -> {
			
			return o1[1] - o2[1];
		});
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 배열에 날짜 집어넣기. '0' 이 아닌 것은 외출 일
		for(int i = 0; i < S.length; i++) {
			String targetS = S[i];
			
			if(targetS.contains("~")) {
				StringTokenizer st = new StringTokenizer(targetS, "~");
				
				String S1 = st.nextToken();
				String S2 = st.nextToken();
				
				int dOfy1 = LocalDate.parse(S1, formatter).getDayOfYear();
				int dOfy2 = LocalDate.parse(S2, formatter).getDayOfYear();
				
				int date1 = (Integer.parseInt(S1.substring(2, 4)) - 21) * 365 + dOfy1;
				int date2 = (Integer.parseInt(S1.substring(2, 4)) - 21) * 365 + dOfy2;
				
				min = Math.min(date1, min);
				max = Math.max(date2, min);
				
				for(int j = date1; j <= date2; j++) {
					day[j]++;
				}
				
			} else {
				int dOfy = LocalDate.parse(targetS, formatter).getDayOfYear();
				
				int date = (Integer.parseInt(targetS.substring(2, 4)) - 21) * 365 + dOfy;
				
				min = Math.min(date, min);
				max = Math.max(date, min);
				
				day[date]++;
			}
			
		}
		
		DP[min] = masks[0][0];
		
		System.out.println(func(max));;
		
	}

	
	
	
	private static int func(int N) { 
		if(DP[N] == null && day[N] != 0) {
			DP[N] = Integer.MAX_VALUE;
			
			for(int i = 0; i < masks.length; i++) {
				int price = masks[i][0];
				int dur = masks[i][1];
				
				if(N - dur >= min) {
					DP[N] = Math.min(DP[N], func(N - dur) + price);
				} 
			}
			
		}
		
		return DP[N];
	}

}
