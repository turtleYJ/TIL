package com.study.yooil.programmers;

import java.util.LinkedList;

public class Solution2 {
	
	
	public int solution(int[] queue1, int[] queue2) {
		LinkedList<Long> q1 = new LinkedList<>();
		LinkedList<Long> q2 = new LinkedList<>();
		
		for(int i = 0; i < queue1.length; i++) {
			q1.offer((long)queue1[i]);
			q2.offer((long)queue2[i]);
		}
		
		int count = 0;
		
		while(true) {
			long sum1 = 0; 
			long sum2 = 0; 
			
			for(int i = 0; i < q1.size(); i++) {
				sum1 += q1.get(i);
			}
			for(int i = 0; i < q2.size(); i++) {
				sum2 += q2.get(i);
			}
			
			long half = (sum1 + sum2) / 2;
			
			if(sum1 == sum2) {
				break;
			} else if(sum1 > sum2) {
				long x = q1.poll();
				
				if(x > half) {
					return -1;
				}
				q2.offer(x);
				
				count++;
			} else {
				q1.offer(q2.poll());
				
				count++;
			}
		}
		
		return count;
    }
}
