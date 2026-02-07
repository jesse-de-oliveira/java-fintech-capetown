package com.fintech.foundations.Day4;

import java.util.HashMap;
import java.math.BigDecimal;

public class AccountLookupSystem {
    
    // Class-level HashMap for account storage
    private static HashMap<String, BigDecimal> accounts = new HashMap<>();
    
    /**
     * Creates or updates account balance.
     * Time: O(1), Space: O(n) for n accounts
     */
    public static void setBalance(String accountNum, BigDecimal balance) {
        accounts.put(accountNum, balance);
    }
    
    /**
     * Gets account balance.
     * Time: O(1)
     */
    public static BigDecimal getBalance(String accountNum) {
        return accounts.getOrDefault(accountNum, BigDecimal.ZERO);
    }
    
    /**q
     * Checks if account exists.
     * Time: O(1)
     */
    public static boolean accountExists(String accountNum) {
        return accounts.containsKey(accountNum);
    }
    
    /**
     * Deposits money to account.
     * Time: O(1)
     */
    public static void deposit(String accountNum, BigDecimal amount) {
        BigDecimal current = getBalance(accountNum);
        BigDecimal newBalance = current.add(amount);
        setBalance(accountNum, newBalance);
    }
    
    /**
     * Withdraws money from account.
     * Time: O(1)
     * Returns true if successful, false if insufficient funds
     */
    public static boolean withdraw(String accountNum, BigDecimal amount) {
        BigDecimal current = getBalance(accountNum);
        
        if (current.compareTo(amount) >= 0) {
            BigDecimal newBalance = current.subtract(amount);
            setBalance(accountNum, newBalance);
            return true;
        }
        
        return false;  // Insufficient funds
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        System.out.println("=== ACCOUNT LOOKUP SYSTEM ===\n");
        
        // Setup accounts
        setBalance("001", new BigDecimal("5000.00"));
        setBalance("002", new BigDecimal("3000.00"));
        setBalance("003", new BigDecimal("7500.00"));
        
        // Test 1: Check balance (O(1) lookup)
        System.out.println("Account 001 balance: R " + getBalance("001"));
        System.out.println("Account 999 balance: R " + getBalance("999"));
        System.out.println();
        
        // Test 2: Deposit
        System.out.println("Depositing R 1000 to account 001...");
        deposit("001", new BigDecimal("1000.00"));
        System.out.println("New balance: R " + getBalance("001"));
        System.out.println();
        
        // Test 3: Withdraw (success)
        System.out.println("Withdrawing R 500 from account 002...");
        boolean success = withdraw("002", new BigDecimal("500.00"));
        System.out.println("Success: " + success);
        System.out.println("New balance: R " + getBalance("002"));
        System.out.println();
        
        // Test 4: Withdraw (insufficient funds)
        System.out.println("Withdrawing R 10000 from account 002...");
        success = withdraw("002", new BigDecimal("10000.00"));
        System.out.println("Success: " + success);
        System.out.println("Balance unchanged: R " + getBalance("002"));
    }
}