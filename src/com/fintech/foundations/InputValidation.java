package com.fintech.foundations;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Demonstrates proper input validation.
 * 
 * In fintech, bad input can cause:
 * - Crashes (program stops working)
 * - Data corruption (wrong amounts saved)
 * - Security issues (SQL injection, etc.)
 * 
 * Solution: Validate ALL user input before using it
 * 
 * @author Jesse Smith
 */

public class InputValidation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    INPUT VALIDATION DEMO               ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // ═══════════════════════════════════════════════════════
        // EXAMPLE 1: Validate positive integer
        // ═══════════════════════════════════════════════════════
        int age = 0;
        boolean validInput = false;
        
        while(!validInput) {
        	try {
        		System.out.println("Enter your age (must be positive): ");
        		age = scanner.nextInt();
        		
        		// Validation: Age must be positive
        		if (age <= 0) {
        			System.out.println("Error: Age must be greater than 0");
        			continue;  // Ask again
        		}
        		
        		// Validation: Age must be reasonable 
        		if (age > 150) {
        			System.out.println("Error: Age must be less than 150");
        			continue; // Ask again
        		}
        		
        		// If we got here, input is valid
        		validInput = true;
        		System.out.println("Valid age: " + age);
        		
        	} catch (Exception e) {
        		System.out.println("Error: please enter a valid number");
        		scanner.nextLine(); // Clear the bad input
        	}
        }
        
        System.out.println("");
        
        // ═══════════════════════════════════════════════════════
        // EXAMPLE 2: Validate BigDecimal amount
        // ═══════════════════════════════════════════════════════
        
        BigDecimal amount = null;
        validInput = false;
        
        while (!validInput) {
        	try {
        		System.out.println("Enter transaction amount (ZAR): R ");
        		amount = scanner.nextBigDecimal();
        		
        		// Validation: Amount must be a positive
        		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
        			System.out.println("Error: Amount must be greater than R 0");
        			continue;
        		}
        		
        		//Validation: Amount must be reasonable (<1 million)
        		BigDecimal maxAmount = new BigDecimal("1000000");
        		if (amount.compareTo(maxAmount) > 0) {
        			System.out.println("Error: Amount too large (max R 1,000,000)");
        			continue;
        		}
        		
        		validInput = true;
        		System.out.println(" Valid amount: R " + amount);
        	} catch (Exception e)  {
        			System.out.println("Error: Please enter a valid amount");
        			scanner.nextLine(); // Clear bad input
        		}
        	}
        
        // ═══════════════════════════════════════════════════════
        // EXAMPLE 3: Validate transaction type (String)
        // ═══════════════════════════════════════════════════════
        
        System.out.println();
        String transactionType = "";  
        validInput = false;
        
        while (!validInput) {
        	System.out.println("Enter transaction type (payshap/eft/international): ");
        	transactionType = scanner.next().toLowerCase().trim();
        	
        	// Validation: Must be one of the allowed types
        	if (transactionType.equals("payshap") ||
        		transactionType.equals("eft") ||
        		transactionType.equals("international")) {
        		validInput = true;
        		System.out.println("Valid type: " + transactionType);
        	} else {
        		System.out.println("Error: Type must be payshap, eft, or international");
        	}
        }
        
        // ═══════════════════════════════════════════════════════
        // Now we have ALL valid inputs - safe to use!
        // ═══════════════════════════════════════════════════════
        
        System.out.println("\n--- VALIDATED INPUT SUMMARY ---");
        System.out.println("Age: " + age);
        System.out.println("Amount: R " + amount);
        System.out.println("Type: " + transactionType);
        System.out.println("All inputs validated successfully!");
        
        scanner.close();
        
	}
}
























