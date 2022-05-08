package com.study.yooil.programmers;

public class Solution3 {
	 public int solution(int alp, int cop, int[][] problems) {
		 	int al = alp;
		 	int co = cop;
		 	int result = 0;
		 	
		 	for(int i = 0; i < problems.length; i++) {
		 		if(problems[i][0] > al || problems[i][1] > co) {
		 			System.out.println(i + "번 문제는 풀어야함");
		 			
		 			int x = problems[i][0] - al;
		 			int y = problems[i][1] - co;
		 			
		 			System.out.println(x + " " + y);
		 		} else {
		 			System.out.println(i + "번 문제는 감당가능");
		 		}
		 	}
		 	
		 	
		 	
		 
	        int answer = 0;
	        return answer;
	    }
}

