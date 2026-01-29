package com.fintech.foundations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSolution {
	public static void main(String[] args) {
		// THE WRONG WAY (don't do this)
		// BigDecimal wrong = new BigDecimal(0.1); //
		
		// THE RIGHT WAY - always use String!!!
		BigDecimal money1 = new BigDecimal("0.1");
		BigDecimal money2 = new BigDecimal("0.2");
		
		// Addition - use .add() method
		BigDecimal total = money1.add(money2);
		System.out.println("0.1 + 0.2 = " + total);
		
		// Subtraction 
		BigDecimal balance = new BigDecimal("1000.50");
		BigDecimal withdrawl = new BigDecimal("999.99");
		BigDecimal remaining = balance.subtract(withdrawl);
		System.out.println("1000 - 999.99 = " + remaining);
		
		// Multiplication
		BigDecimal price = new BigDecimal("0.1");
		BigDecimal quantity = new BigDecimal("3");
		BigDecimal totalPrice = price.multiply(quantity);
		System.out.println("0.1 * 3 = " + totalPrice);
		
		// Division - needs rounding rules
		BigDecimal amount = new BigDecimal("10.00");
		BigDecimal divisor = new BigDecimal("3");
		BigDecimal result = amount.divide(divisor, 2, RoundingMode.HALF_UP);
		System.out.println("10.00 / 3 = " + result);
		
	}
}
