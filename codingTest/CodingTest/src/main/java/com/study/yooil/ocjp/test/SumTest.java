package com.study.yooil.ocjp.test;

public class SumTest {

	private static void doSum(Integer x, Integer y) {
		System.out.println("Integer" + (x + y));
	}
	
	private static void doSum(double x, double y) {
		System.out.println("double" + (x + y));
	}
	
	private static void doSum(float x, float y) {
		System.out.println("float" + (x + y));
	}
	
	public static void main(String[] args) {
		doSum(10, 20);
		doSum(10.0, 20.0);
	}

	

}
