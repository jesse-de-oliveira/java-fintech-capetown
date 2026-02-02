package com.fintech.foundations;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Big-O Notation - Understanding algorithm efficiency.
 * 
 * Demonstrates:
 * - O(1) - Constant time
 * - O(n) - Linear time
 * - O(n²) - Quadratic time (avoid!)
 * 
 *  @author Jesse De Oliveira
 *  @since 2026-02-03
 */

public class BigOBasics {
	public static void main(String[] args) {
		System.out.println("═══════════════════════════════════════");
        System.out.println("   BIG-O NOTATION EXAMPLES");
        System.out.println("═══════════════════════════════════════\n");
        
        // ═══════════════════════════════════════════════════════
        // O(1) - CONSTANT TIME (Best!)
        // ═══════════════════════════════════════════════════════
        System.out.println("O(1) - CONSTANT TIME");
        System.out.println("HashMap lookup - instant!\n");
        
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("001", "R 10000");
        accounts.put("002", "R 5000");
        accounts.put("003", "R 7500");
        
        // This is O(1) - same speed whether 3 or 3 million accounts
        String balance = accounts.get("002");
        System.out.println("Account 002 balance: " + balance);
        System.out.println("Speed: Instant (O(1))\n");
        
        // ═══════════════════════════════════════════════════════
        // O(n) - LINEAR TIME (Acceptable)
        // ═══════════════════════════════════════════════════════
        System.out.println("O(n) - LINEAR TIME");
        System.out.println("Loop through transactions once\n");
        
        ArrayList<Integer> transactions = new ArrayList<>();
        transactions.add(100);
        transactions.add(200);
        transactions.add(300);
        transactions.add(400);
        transactions.add(500);
        
        // This is O(n) - if 5 items, 5 operations
        // If 1000 items, 1000 operations
        
        int total = 0;
        for(int amount : transactions) {
        	total += amount;
        }
        System.out.println("Total transactions: " + total);
        System.out.println("Speed: Grows with size (O(n))\n");
        
        // ═══════════════════════════════════════════════════════
        // O(n²) - QUADRATIC TIME (BAD! Avoid!)
        // ═══════════════════════════════════════════════════════
        
        System.out.println("O(n²) - QUADRATIC TIME (Avoid!)");
        System.out.println("Nested loops - very slow!\n");
        
        int[] numbers = {1,2,3,4,5};
        // This is O(n²) - outer loop runs n times
        // For each outer loop, inner loop runs n times
        // Total: n × n = n²
        
        System.out.println("Comparing all pairs:");
        int comparisons = 0;
        for(int i = 0; i < numbers.length; i++) {
        	for(int j = 0; j < numbers.length; j++) {
        		System.out.println("Compare " + numbers[i] + " with " + numbers[j]);
        			comparisons++;
        	}
        }
        
        System.out.println("\nTotal comparisons: " + comparisons);
        System.out.println("With 5 items: 25 operations (5²)");
        System.out.println("With 100 items: 10,000 operations (100²)");
        System.out.println("With 1000 items: 1,000,000 operations (1000²)");
        System.out.println("Speed: Grows exponentially (O(n²)) - BAD!\n");
        
        // ═══════════════════════════════════════════════════════
        // SUMMARY
        // ═══════════════════════════════════════════════════════
        System.out.println("═══════════════════════════════════════");
        System.out.println("INTERVIEW CHEAT SHEET:");
        System.out.println("═══════════════════════════════════════");
        System.out.println("O(1)  → HashMap lookup → Best!");
        System.out.println("O(n)  → Single loop → Good");
        System.out.println("O(n²) → Nested loops → Avoid!");
        System.out.println("═══════════════════════════════════════");
	}
}