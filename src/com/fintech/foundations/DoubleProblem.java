package com.fintech.foundations;
public class DoubleProblem {
	public static void main (String[] args) {
		//the shocking truth about doubles
		double money1 = 0.1;
		double money2 = 0.2;
		double total = money1 + money2;
		
		System.out.println("0.1 + 0.2 = " + total);
		
		//Another example
		double balance = 1000.50;
		double withdrawl = 999.99;
		double remaining = balance - withdrawl;
		
		System.out.println("Expected: 0.51");
		System.out.println("Got: " + remaining);
		
		//The real danger: multiplication
		double price = 0.1;
		double quantity = 3;
		double total2 = price * quantity;
		
		System.out.println("\n0.1 * 3 = " + total2);
		System.out.println("Is it exactly 0.3?" + (total2 == 0.3));		
	}
}
