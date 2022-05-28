package com.study.yooil.Test.problem1;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] v, int a, int b) {
		int answer = 0;
		
		return answer;
	}
}

public class Main {

	public static void main(String[] args) {
		int answer = 0;
		
		int[] v = new int[] {4, 5, 5};
		int a = 2;
		int b = 1;
		
//		List<Integer> arr = new ArrayList<>();
//		
//		for(int i = 0; i < v.length; i++) {
//			arr.add(v[i]);
//		}
//		
//		int hours = 0;
//		while(true) {
//			int max = 0;
//			
//			for(int i = 0; i < arr.size(); i++) {
//				max = Math.max(max, arr.get(i));
//			}
//			
//			if(max < a) break;
//			
//			int firstIdx = arr.indexOf(max);
//			int temp = 0;
//			
//			for(int i = 0; i < arr.size(); i++) {
//				if(i == firstIdx) {
//					temp = arr.get(i) - a;
//					
//					arr.set(i, temp);
//				}
//				
//				temp = arr.get(i) - b;
//				
//				arr.set(i, temp);
//			}
//			
//			hours++;
//		}
//		
//		System.out.println(hours);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < v.length; i++) {
			pq.add(v[i]);
		}
		
		while(true) {
			if(pq.peek() < a) break;
			
			pq.add(pq.poll() - a);
			
			for(int i = 0; i < pq.size() - 1; i++) {
				pq.add(pq.poll() - b);
			}
			
			System.out.println(pq);
			
			answer++;
		}
		
		
		System.out.println(answer);
	}

}
