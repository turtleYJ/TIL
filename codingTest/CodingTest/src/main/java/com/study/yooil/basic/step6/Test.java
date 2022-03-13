package com.study.yooil.basic.step6;

public class Test {

	long sum(int[] a) {
		
		long sum = 0;
		
		for (int i : a) {			
			sum += i;
		}
		
		return sum;
	}
}
