package com.study.yooil.BAEKJOON;

public class main {

	public static void main(String[] args) {
		for(int i = 1 ; i < 1000; i++) {
			if(100 * Math.pow(i, 2) < Math.pow(2, i)) {
				System.out.println(i);
				
				break;
			}
		}
	}

}
