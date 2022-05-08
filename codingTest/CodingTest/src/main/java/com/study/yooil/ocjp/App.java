package com.study.yooil.ocjp;

//class E1 extends Exception {}
//
//class E2 extends RuntimeException {}

public class App {
//    public void m1() {
//    	System.out.println("m1.Accessed.");
//    }
//    
//    public void m2() {
//    	System.out.println("m2.Accessed.");
//    	throw new E2();
//    }
	
	public static void main(String[] args) {
		Boolean[] bool = new Boolean[2];
		
		bool[0] = new Boolean(Boolean.parseBoolean("true"));
//		bool[1] = new Boolean(null);
		bool[1] = null;
		
		System.out.println(bool[0] + " " + bool[1]);
	}
    
    
}