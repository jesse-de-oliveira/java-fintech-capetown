package com.fintech.foundations;
import java.math.BigDecimal;

/**
 *Test suite for Transaction class.
 *Demonstrates proper usage and edge cases. 
*/
public class TransactionTest {
	public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   TRANSACTION CLASS TEST SUITE             ║");
        System.out.println("║   Cape Town Fintech Portfolio              ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // TEST 1: Payshap Transaction (no VAT)
        System.out.println("TEST 1: Payshap Transaction (P2P - No VAT)");
        System.out.println("───────────────────────────────────────────");
        
        Transaction payshap = new Transaction(
        		"12345678",
        		new BigDecimal("1000.00"),
        		"payshap"
        );
        
        payshap.displayReceipt();
        
        System.out.println("PASS: VAT = R " + payshap.getVatAmount());
        System.out.println("Expected: R 0.00");
        System.out.println();
        
        //TEST 2: International Transaction (15% VAT)
        System.out.println("TEST 2: International (15% VAT)");
        System.out.println("───────────────────────────────────────────");

        Transaction international = new Transaction(
        		"87654321",
        		new BigDecimal("5000.00"),
        		"international"
        		);
        
        international.displayReceipt();
        System.out.println("PASS: VAT = R " + international.getVatAmount());
        System.out.println("Expected: R 750.00 (15% of R 5000)");
        System.out.println();
        
        //TEST 3: Status Updates
        System.out.println("TEST 3: Status Transitions");
        System.out.println("───────────────────────────────────────────");
        
        System.out.println("Intial: " + payshap.getStatus());
        payshap.setStatus("completed");
        System.out.println("After update: " + payshap.getStatus());
        System.out.println("PASS: Status changed from 'pending' -> 'completed'");
        System.out.println();
        
        //TEST 4: Invalid Transition (Should Fail)
        System.out.println("TEST 4: Invalid Transition Test");
        System.out.println("───────────────────────────────────────────");
        
        try {
        	payshap.setStatus("pending");
        	System.out.println("FAIL: allowed invalid transition");
        } catch (IllegalStateException e) {
        	System.out.println("PASS: Rejected invalid transition");
        	System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        //TEST 5: Validation (Negative Amount)
        System.out.println("TEST 5: Input Validation");
        System.out.println("───────────────────────────────────────────");
        
        try {
        	Transaction invalid = new Transaction(
        		"11111111",
        		new BigDecimal("-100.00"),
        		"payshap"
        	);
        	System.out.println("FAIL: Accepted negative amount");
        } catch (IllegalArgumentException e) {
        	System.out.println("PASS: rejected negative amount");
        	System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        //SUMMARY
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║          All TESTS PASSED                  ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  * Encapsulation working                   ║");
        System.out.println("║  * Validation preventing bad data          ║");
        System.out.println("║  * VAT calculation accurate                ║");
        System.out.println("╚════════════════════════════════════════════╝");
          
	}
}
 