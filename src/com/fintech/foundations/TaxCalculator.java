package com.fintech.foundations;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
	public static void main(String[] args) {
		//Transaction details
		BigDecimal amount = new BigDecimal("5000.00");
		String transactionType = "payshap"; // try: international, card_purchase, pashap, eft
		
		//Determine tax rate (South African VAT)
		BigDecimal taxRate;
		
		if (transactionType.equals("international")) {
			taxRate = new BigDecimal("15.00");  // 15% VAT
			System.out.println("Transaction: International Purchase (VAT applies)");
		} else if (transactionType.equals("card_purchase")) {
			taxRate = new BigDecimal("15.00");
			System.out.println("Transaction: Card Purchase (VAT applies)");
		} else if (transactionType.equals("payshap")) {
			taxRate = new BigDecimal("0.00");
			System.out.println("Transaction: Payshap (No VAT - person-to-person transfer)");
		} else if (transactionType.equals("eft")) {
			taxRate = new BigDecimal("0.00"); // No VAT on bank transfers
			System.out.println("Transaction: EFT (No VAT - bank transfer)");
		} else {
			taxRate = new BigDecimal("0.00");
			System.out.println("Transaction: Unknown");
		}
		
		// Calculate VAT: amount * (rate / 100)
		BigDecimal hundred = new BigDecimal("100");
		BigDecimal vat = amount.multiply(taxRate).divide(hundred, 2, RoundingMode.HALF_UP);
		
		// Calculate total
		BigDecimal total = amount.add(vat);
		
		// Display Results
		System.out.println("\n--- VAT CALCULATION (SA)---");
		System.out.println("Amount: R " + amount);
		System.out.println("VAT Rate: " + taxRate + "%");
		System.out.println("VAT: R " + vat);
		System.out.println("TOTAL: R " + total);
		System.out.println("------------------------");
		
		System.out.println("\nSouth African VAT Context:");
        System.out.println("- Standard VAT rate: 15%");
        System.out.println("- Applied to: goods, services, imports");
        System.out.println("- Exempt: PayShap (P2P), EFT (bank transfers)");
	}
}