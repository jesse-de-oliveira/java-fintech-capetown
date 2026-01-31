package com.fintech.foundations;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Introduction to Scanner - Reading user input from console.
 * 
 * This demonstrates:
 * - Creating Scanner object
 * - Reading different data types
 * - Basic user interaction
 * 
 * @author Jesse De Oliveira
 * @version 1.0
 * @since 2026-01-31
 */

public class ScannerBasics {
	public static void main(String[] args) {
		// Create Scanner object (reads from keyboard)
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    SCANNER BASICS - USER INPUT         ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // ═══════════════════════════════════════════════════════
        // Example 1: Reading a String (person's name)
        // ═══════════════════════════════════════════════════════
        
        System.out.println("What is your name? ");
        String name = scanner.nextLine();  // Reads entire line
        System.out.println("Hello " + name + "!\n");
        
        // ═══════════════════════════════════════════════════════
        // Example 2: Reading an integer (age)
        // ═══════════════════════════════════════════════════════
        
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old.\n");
        
        // ═══════════════════════════════════════════════════════
        // Example 3: Reading a BigDecimal (money amount)
        // ═══════════════════════════════════════════════════════
        
        System.out.println("Enter a transaction amount (ZAR): R ");
        BigDecimal amount = scanner.nextBigDecimal();
        
        // Calculate VAT (15%)
        BigDecimal vatRate = new BigDecimal("15.00");
        BigDecimal hundred = new BigDecimal("100.00");
        BigDecimal vat = amount.multiply(vatRate).divide(hundred, 2, java.math.RoundingMode.HALF_UP);
        BigDecimal total = vat.add(amount);
        
        System.out.println("\n--- TRANSACTION SUMMARY ---");
        System.out.println("Amount:    R " + amount);
        System.out.println("VAT (15%): R " + vat);
        System.out.println("Total:     R " + total);
        
        // ═══════════════════════════════════════════════════════
        // IMPORTANT: Always close Scanner when done
        // ═══════════════════════════════════════════════════════
        
        scanner.close();
        
        System.out.println("\n Scanner demonstration complete!");
        
        // **As you type, understand:**
        // - `Scanner scanner = new Scanner(System.in)` → Creates object that reads from keyboard
        // - `scanner.nextLine()` → Waits for user to type and press Enter
        // - `scanner.nextInt()` → Reads and converts to integer
        // - `scanner.nextBigDecimal()` → Reads and converts to BigDecimal (perfect for money!)
        // - `scanner.close()` → Releases resources (good practice)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
}