package com.fintech.foundations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Introduction to Methods - Code organization with functions.
 * 
 * This demonstrates:
 * - Creating reusable methods
 * - Parameters and return values
 * - South African financial context
 * 
 * @author Jesse De Oliveira
 * @version 1.0
 * @since 2026-02-03
 */

public class MethodsBasics {
	public static void main(String[] args) {
		System.out.println("═══════════════════════════════════════");
        System.out.println("   METHODS DEMONSTRATION - FINTECH");
        System.out.println("═══════════════════════════════════════\n");
        
     // Example 1: Calculate VAT (15% South African rate)
        BigDecimal amount = new BigDecimal("8200.00");
        BigDecimal vat = calculateVat(amount);
        	
        System.out.println("Amount: R " + amount);
        System.out.println("VAT (15%): R " + vat);
        System.out.println("Total: R " + amount.add(vat));
        System.out.println();
        
     // Example 2: Validate transaction amount
      BigDecimal testAmount1 = new BigDecimal("20000000.00");
      BigDecimal testAmount2 = new BigDecimal("-100.00");
      
      System.out.println("Is R " + testAmount1 + " valid? " + isValidAmount(testAmount1));
      System.out.println("Is R " + testAmount2 + " valid? " + isValidAmount(testAmount2));
      System.out.println();
    		  
      // Example 3: Format currency for display
      BigDecimal price = new BigDecimal("1234567.89");	  
      String formatted = formatCurrency(price);
      
      System.out.println("Raw amount: " + price);
      System.out.println("Formatted: " + formatted);
	}
	/**
     * Calculates 15% VAT on a given amount.
     * 
     * @param amount The base amount in ZAR
     * @return VAT amount (15% of input)
     */
	public static BigDecimal calculateVat(BigDecimal amount) {
		BigDecimal vatRate = new BigDecimal("15.00");
        BigDecimal hundred = new BigDecimal("100");
        return amount.multiply(vatRate).divide(hundred, 2, RoundingMode.HALF_UP);
	}
	
	/**
     * Validates if transaction amount is positive and reasonable.
     * 
     * @param amount Amount to validate
     * @return true if valid, false otherwise
     */
	
	public static boolean isValidAmount(BigDecimal amount) {
		// must be positive
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			return false;
		}
		
		// Must be less than R 10 million (reasonable limit)
		BigDecimal maxAmount = new BigDecimal("10000000");
		if (amount.compareTo(maxAmount) >= 0) {
			return false;
		}
		
	return true;
	}
	
	/**
     * Formats amount as South African Rand with proper formatting.
     * 
     * @param amount Amount to format
     * @return Formatted string like "R 1,234.56"
     */
	
	public static String formatCurrency(BigDecimal amount) {
		// Round to 2 decimal places
		BigDecimal rounded = amount.setScale(2, RoundingMode.HALF_UP);
		
		// Format with R prefix
		return "R " + rounded;
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 