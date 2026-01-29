package com.fintech.foundations;
import java.util.HashMap;
import java.math.BigDecimal;


public class BankingSystem {
	public static void main(String[] args) {
		// HashMap: Account Number → Balance (in ZAR)
		HashMap<String, BigDecimal> accounts = new HashMap<>();
		
		// Create accounts with initial balance
		accounts.put("001", new BigDecimal("1000.00"));
		accounts.put("002", new BigDecimal("2500.50"));
		accounts.put("003", new BigDecimal("750.25"));
		accounts.put("004", new BigDecimal("35000.00"));
		accounts.put("005", new BigDecimal("867.00"));
		
		System.out.println("=== CAPE TOWN BANKING SYSTEM ===\n");
		
		// Show all accounts
		System.out.println("--- REGISTERED ACCOUNTS ---");
		for (String accountNumber : accounts.keySet()) {
			BigDecimal balance = accounts.get(accountNumber);
			System.out.println("Account: " + accountNumber + ": R " + balance);
		}
		
		// Check specific account balance
		System.out.println("\n--- BALANCE INQUIRY ---");
		String queryAccount = "002";
		
		if (accounts.containsKey(queryAccount)) {
			BigDecimal balance = accounts.get(queryAccount);
			System.out.println("Account " + queryAccount + " balance: R " + balance);
		} else {
			System.out.println("Account not found!");
		}
		
		// DEPOSIT: Add money
		System.out.println("\n--- OPERATION: DEPOSIT ---");
		String depositAccount = "001";
		BigDecimal depositAmount = new BigDecimal("500.00");
		
		BigDecimal currentBalance = accounts.get(depositAccount);
		BigDecimal newBalance = currentBalance.add(depositAmount);
		accounts.put(depositAccount, newBalance);
		
		System.out.println("Deposit of R " + depositAmount + " to account " + depositAccount);
		System.out.println("Previous balance: R " + currentBalance);
		System.out.println("New balance: R " + newBalance);
		
		// WITHDRAWAL: Remove money
		System.out.println("\n--- OPERATION: WITHDRAWAL ---");
		String withdrawalAccount = "002";
		BigDecimal withdrawalAmount = new BigDecimal("2700.00");
		
		BigDecimal currentWithdrawalBalance = accounts.get(withdrawalAccount);
		
		// Check sufficient balance
		if (currentWithdrawalBalance.compareTo(withdrawalAmount) >= 0) {
			BigDecimal newWithdrawalBalance = currentWithdrawalBalance.subtract(withdrawalAmount);
			accounts.put(withdrawalAccount, newWithdrawalBalance);
			
			System.out.println("Withdrawl of R " + withdrawalAmount + " from account " + withdrawalAccount);
			System.out.println("Previous balance: R " + currentWithdrawalBalance);
			System.out.println("New balance: R " + newWithdrawalBalance);
			
		} else {
			
			System.out.println("ERROR: Insufficient funds!");
			System.out.println("Current balance: R " + currentWithdrawalBalance);
			System.out.println("Requested amount: R " + withdrawalAmount);
			
		}
		
		// Show final balances
		System.out.println("\n--- FINAL BALANCES ---");
		for (String accountNumber : accounts.keySet()) {
			BigDecimal balance = accounts.get(accountNumber);
			System.out.println("Account " + accountNumber + ": R " + balance);
		}
		
		// Calculate total bank balance
		System.out.println("\n--- BANK SUMMARY ---");
		BigDecimal totalBankBalance = new BigDecimal("0.00");
		
		for (BigDecimal balance : accounts.values()) {
			totalBankBalance = totalBankBalance.add(balance);
		}
		
		System.out.println("Total accounts: " + accounts.size());
		System.out.println("Total bank balance: R" + totalBankBalance);
		
		System.out.println("\n🇿🇦 Cape Town Fintech Portfolio Project");
		
	}
}













