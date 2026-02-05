// 

package com.fintech.foundations;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Compound Interest Calculator for South African banking.
 * 
 * Calculates future value of investments using compound interest formula.
 * Simplified version: A = P(1 + r)^t (yearly compounding)
 * 
 * Real-world usage:
 * - Savings account growth (FNB, Capitec, TymeBank)
 * - Investment projections
 * - Retirement planning
 * - Loan calculations
 * 
 * @author Jesse De Oliveira
 * @version 1.0
 * @since 2026-02-03
 */

public class CompoundInterestCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   COMPOUND INTEREST CALCULATOR             ║");
        System.out.println("║   South African Banking Context            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // ═══════════════════════════════════════════════════════
        // INPUT 1: Principal Amount (Initial Investment)
        // ═══════════════════════════════════════════════════════
        
        BigDecimal principal = null;
        boolean validInput = false;
        
        System.out.println("\nCommon SA bank rates:");
        System.out.println("  FNB Pure Save: 6%");
        System.out.println("  Capitec Global One: 7.5%");
        System.out.println("  TymeBank GoalSave: 8%");
        System.out.println("  Standard Bank MyMo: 5%\n");
        
        while (!validInput) {
        	try {
        		System.out.println("Enter initial investment (ZAR): R ");
        		principal = scanner.nextBigDecimal();
        		
        		// Validation:  Must be positive
                if (principal.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("❌ Rate must be positive\n");
                    continue;
                }
                
                // Validation: Reasonable limit (R 100 million)
                BigDecimal maxAmount = new BigDecimal("100000000");
                if (principal.compareTo(maxAmount) > 0) {
                    System.out.println("❌ Amount too large\n");
                    continue;
                }
                
                validInput = true;
                
             } catch (Exception e) {
            	 System.out.println("❌ Invalid amount. Enter a number.\n");
            	 scanner.nextLine(); // Clear buffer
                }
        	}
        
        // ═══════════════════════════════════════════════════════
        // INPUT 2: Annual Interest Rate
        // ═══════════════════════════════════════════════════════
        
        BigDecimal annualRate = null;
        validInput = false;
        
        System.out.println("\nCommon SA bank rates:");
        System.out.println("  FNB Pure Save: 6%");
        System.out.println("  Capitec Global One: 7.5%");
        System.out.println("  TymeBank GoalSave: 8%");
        System.out.println("  Standard Bank MyMo: 5%\n");
        
        while (!validInput) {
            try {
                System.out.print("Enter annual interest rate (%): ");
                annualRate = scanner.nextBigDecimal();
                
                // Validation: Must be positive
                if (annualRate.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("❌ Rate must be positive\n");
                    continue;
                }
                
                // Validation: Reasonable (max 50%)
                BigDecimal maxRate = new BigDecimal("50");
                if (annualRate.compareTo(maxRate) > 0) {
                    System.out.println("❌ Rate too high (max 50%)\n");
                    continue;
                }
                
                validInput = true;
                
            } catch (Exception e) {
                System.out.println("❌ Invalid rate. Enter a number.\n");
                scanner.nextLine();
            }
        }
        
        // ═══════════════════════════════════════════════════════
        // INPUT 3: Number of Years
        // ═══════════════════════════════════════════════════════
        int years = 0;
        validInput = false;
        
        while (!validInput) {
            try {
                System.out.print("\nEnter number of years: ");
                years = scanner.nextInt();
                
                // Validation: Must be positive
                if (years <= 0) {
                    System.out.println("❌ Years must be positive\n");
                    continue;
                }
                
                // Validation: Reasonable (max 50 years)
                if (years > 50) {
                    System.out.println("❌ Years too high (max 50)\n");
                    continue;
                }
                
                validInput = true;
                
            } catch (Exception e) {
                System.out.println("❌ Invalid number. Enter whole years.\n");
                scanner.nextLine();
            }
        }
        
        // ═══════════════════════════════════════════════════════
        // CALCULATE COMPOUND INTEREST
        // ═══════════════════════════════════════════════════════
        
        // Convert annual rate to decimal (8% → 0.08)
        BigDecimal rateDecimal = annualRate.divide(
            new BigDecimal("100"), 
            10, 
            RoundingMode.HALF_UP
        );
        
        // Calculate: A = P(1 + r)^t
        // We'll do this year by year for clarity
        BigDecimal finalAmount = principal;
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         YEAR-BY-YEAR BREAKDOWN             ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println(String.format("  Year 0: R %,.2f (initial)", 
                                        principal.doubleValue()));
        
        for (int year = 1; year <= years; year++) {
        	// Calculate interest for this year
        	BigDecimal interest = finalAmount.multiply(rateDecimal);
            
            // Add interest to get new balance
            finalAmount = finalAmount.add(interest);
            
            // Display this year
            System.out.println(String.format("  Year %d: R %,.2f (+ R %,.2f)", 
                                            year, 
                                            finalAmount.doubleValue(),
                                            interest.doubleValue()));
        }
        
        // ═══════════════════════════════════════════════════════
        // CALCULATE TOTAL INTEREST EARNED
        // ═══════════════════════════════════════════════════════
        BigDecimal totalInterest = finalAmount.subtract(principal);
        
        // ═══════════════════════════════════════════════════════
        // DISPLAY FINAL RESULTS
        // ═══════════════════════════════════════════════════════
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║              FINAL SUMMARY                 ║");
        System.out.println("╠═══════════════════════════════════════5-100═════╣");
        System.out.println(String.format("  Initial Investment:  R %,.2f", 
                                        principal.doubleValue()));
        System.out.println(String.format("  Interest Rate:       %.2f%% per year", 
                                        annualRate.doubleValue()));
        System.out.println(String.format("  Time Period:         %d years", years));
        System.out.println("─────────────────────────────────────────────");
        System.out.println(String.format("  💰 Final Balance:    R %,.2f", 
                                        finalAmount.doubleValue()));
        System.out.println(String.format("  📈 Interest Earned:  R %,.2f", 
                                        totalInterest.doubleValue()));
        
        // Calculate effective gain percentage
        BigDecimal gainPercentage = totalInterest
            .divide(principal, 4, RoundingMode.HALF_UP)
            .multiply(new BigDecimal("100"));
        
        System.out.println(String.format("  📊 Total Gain:       %.2f%%", 
                gainPercentage.doubleValue()));
        System.out.println("╚════════════════════════════════════════════╝");
        
        // ═══════════════════════════════════════════════════════
        // CALCULATE AGAIN?
        // ═══════════════════════════════════════════════════════
        System.out.print("\nCalculate another scenario? (y/n): ");
        String again = scanner.next().toLowerCase();
        
        if (again.equals("y") || again.equals("yes")) {
            System.out.println("\n" + "═".repeat(45) + "\n");
            scanner.close();
            System.out.println("Please run the program again.");
        } else {
            System.out.println("\n💰 Happy investing! Build wealth with compound interest.");
            scanner.close();
        }
        
	}
}
 
	
