package com.study.yooil.ocjp.test;

public class CheckingAccount {
	public int amount;
	
	public CheckingAccount() {
		amount = 100;
	}

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount();
		
		System.out.println(ca.amount);
	}

}
