package com.study.yooil.programmers;

public class Main {

	public static void main(String[] args) {
//		String[] survey = {"TR", "RT", "TR"};
//		int[] choices = {7, 1, 3};
//		
//		String S = new Solution1().solution(survey, choices);
//		
//		System.out.println(S);
		
		
		// 2번
		int[] queue1 = {1, 1};
		int[] queue2 = {1, 5};
		
		int result = new Solution2().solution(queue1, queue2);
		
		System.out.println(result);
		
//		// 3번
//		int[][] problems = {{0,0,2,1,2}, {4,5,3,1,2}, {4,11,4,0,2}, {10,4,0,4,2}};
//		
//		new Solution3().solution(0, 0, problems);
		
	}

}
