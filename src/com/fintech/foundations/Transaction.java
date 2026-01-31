package com.fintech.foundations;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


/**
 * Represents a financial transaction in a South African banking system.
 * Implements VAT calculation and maintains transaction integrity.
 * 
 * This class demonstrates:
 * - Encapsulation (private fields, public methods)
 * - Input validation (prevents invalid states)
 * - POPIA compliance (handles financial data securely)
 * - PayShap payment system integration
 * 
 * @author Jesse De Oliveira
 * @version 1.0
 * @since 2026-01-30
 */

public class Transaction {

	//===========================================
	//FIELDS (Private -  Encapsulation Principle)
	//===========================================
	
	/** Unique transaction identifier (e.g., TXN-abc123) */
	private String transactionId;
	
	/** Transaction amount in ZAR (South African Rand)*/
	private BigDecimal amount;
	
	/** 
	 * Transaction type:
	 * -payshap: Instant P2P payment (0% VAT)
	 * -eft: Electronic Funds Transfer (0%VAT)
	 * -international: Foreign Exchange (15% VAT)
	 * -card_purchase: Merchant transaction (15% VAT)
	*/
	private String type;
	
	/** Timestamp when transaction was created */
	private LocalDateTime timestamp;
	
	/** VAT amount (15% for applicable transactions, 0% for transfers) */
	private BigDecimal vatAmount;
	
	/** Account number this transaction belongs to */
	private String accountNumber;
	
	/** 
	 *Transaction status: 
	 * - pending: Awaiting processing
	 * - completed: Successfully processed
	 * - failed: Processing failed 
	*/
	private String status;
	
	//===========================================
	//CONSTRUCTOR
	//===========================================
	
	/** 
	 *Creates a new Transaction with automatic VAT calculation. 
	 *
	 *This constructor validates all inputs and generates a unique ID.
	 *It calculates VAT based on South African tax regulations (SARS).
	 *
	 *@param accountNumber The account number (8 digits, e.g., "12345678")
	 *@param amount Transaction amount in ZAR (must be positive)
	 *@param type Transaction type (payshap/eft/international/card_purchase)
	 *@throws IllegalArgumentException if inputs are invalid
	*/
	public Transaction(String accountNumber, BigDecimal amount, String type) {
		//====================================================
		//VALIDATION (Critical for fintech - prevent bad data)
		//====================================================
		
		// Validate amount is positive
		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException(
				"Transaction amount must be positive. Got: " + amount
			);
		}
		// Validate account number exists
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			throw new IllegalArgumentException(
				"Account number cannot be empty"	
			);
		}
		// Validate account number format (8 digits)
		if (!accountNumber.matches("\\d{8}")) {
			throw new IllegalArgumentException(
				"Account number must be 8 digits. Got: " + accountNumber	
			);
		}
		// Validate transaction type exists
		if (type == null || type.trim().isEmpty()) {
			throw new IllegalArgumentException(
				"Transaction type cannot be empty"	
			);
		}
		
		// ───────────────────────────────────────────────────────────
        // INITIALIZATION
        // ───────────────────────────────────────────────────────────
		
		this.transactionId = generateTransactionId();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.type = type.toLowerCase().trim();
		this.timestamp = LocalDateTime.now();
		this.status = "pending";
		this.vatAmount = calculateVAT();	
	}
	//====================================================
	//PRIVATE HELPER METHODS (Internal logic, not exposed)
	//====================================================
	
	/** 
	 *Generates a unique transaction ID using UUID.
	 *
	 *Format: TXN-{UUID}
	 *Example: TXN-a1b2c3d4-e5f6-7890-abcd-ef1234567890
	 *
	 *Why UUID? 
	 * - Globally unique (collision probability ~0) 
	 * - No database needed for ID generation
	 * - Industry standard for distributed systems
	 * 
	 * @return Unique transaction ID
	*/
	private String generateTransactionId() {
		return "TXN-" + UUID.randomUUID().toString();
	}
	
	/** 
	 *Calculates VAT based on South African tax regulations (SARS).
	 *
	 * VAT rules as of (2026):
	 * - Standard rate: 15%
	 * - Applied to: goods, services, imports, forex
	 * - Exempt: financial services, person-to-person transfers
	 * 
	 * Transaction Types:
	 * - payshap (P2P transfer): 0% VAT (exempt)
	 * - eft (bank transfer): 0% VAT (exempt)
	 * - international (forex): 15% VAT
	 * - card_purchase (merchant): 15% VAT
	 * 
	 * @return VAT amount in ZAR	
	*/
	private BigDecimal calculateVAT() {
		BigDecimal vatRate;
		
		// Determine VAT rate based on transaction type
		switch (this.type) {
		case "international":
		case "card_purcahse":
			vatRate = new BigDecimal("15.00"); // 15% standard VAT
			break;
		case "payshap":
		case "eft":
		default:
			vatRate = new BigDecimal("0.00"); // Exempt from VAT 
			break;
		}
		
		// Calculate: amount * (vatRate / 100)
		// Example: R1000 * (15 / 100) = R150	
		
		BigDecimal hundred = new BigDecimal("100.00");
		return amount.multiply(vatRate).divide(hundred, 2, RoundingMode.HALF_UP);
	}
	
	//=========================================
	//PUBLIC GETTERS (Read-only access to data)
	//=========================================
	
	/** 
	 * Gets the transaction ID
	 *@return Transaction ID (e.g., "TXN-abc123...") 
	*/
	public String getTransactionId() {
		return transactionId;
	}
	
	/** 
	 * Gets the transaction amount (excluding VAT).
	 * @return amount in ZAR 
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/** 
	 * Gets the transaction type.
	 * @return Type (payshap/eft/international/card_purcahse) 
	*/
	public String getType() {
		return type;
	}
	
	/** 
	 * Gets the transaction timestamp.
	 * @return Timestamp when transaction was created
	*/
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Gets the VAT amount.
	 * @return VAT in ZAR (0.00 for exempt transactions) 
	*/
	public BigDecimal getVatAmount() {
		return vatAmount;
	}
	
	/**
	 * gets the account number. 
	 * @return 8-digit account number
	*/
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Gets the transaction status
	 * @return Status (pending/completed/failed)
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * Calculates total amount including VAT.
	 * 
	 *  Formula: amount + vatAmount
	 *  Example: R 1000 + R 150 = R 1150
	 *  
	 *  @return Total amount (amount + VAT) in ZAR	
	*/
	public BigDecimal getTotalAmount() {
		return amount.add(vatAmount);
	}
	
	//=================================================
	//PUBLIC SETTERS (Limited - only status can change)
	//=================================================
	
	/**
	 * Updates transaction status.
	 * 
	 * Valid transitions:
	 *  - pending -> completed`
	 *  - pending -> failed
	 * Invalid transitions: 
	 *  - completed -> anything (cannot revert)
	 *  - failed -> anything (cannot retry)
	 *  
	 * @param newStatus The new status (pending/completed/failed)
	 * @throws IllegalArgumentException if status is invalid
	 * @throws IllegalStateException if transition is not allowed
	*/
	
	public void setStatus(String newStatus) {
		String status = newStatus.toLowerCase().trim();
		
		// Validate status value
		if (!status.equals("pending") &&
			!status.equals("completed") &&
			!status.equals("failed")) {
			throw new IllegalArgumentException(
				"Invalid status. Must be: pending, completed or failed. Got: " + newStatus
			);
		}
		
		// Validate status transition 
		if (this.status.equals("completed") && !status.equals("completed")) {
			throw new IllegalStateException(
				"Cannot change status of completed transaction"		
			);
		}
		
		if (this.status.equals("failed") && !status.equals("failed")) {
			throw new IllegalStateException(
				"Cannot change status of failed transaction"	
			);
		}
		
		this.status = status;
	}
	
	//=================================================
	//DISPLAY METHOD
	//=================================================
	
	/**
	 * Displays transaction details in a formatted receipt. 
	*/
	public void displayReceipt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║         TRANSACTION RECEIPT                ║");
        System.out.println("║    Cape Town Fintech Portfolio Demo       ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("   Transaction ID: " + transactionId);
        System.out.println("   Account: " + accountNumber);
        System.out.println("   Date: " + timestamp.format(formatter));
        System.out.println("   Type: " + type.toUpperCase());
        System.out.println("   Status: " + status.toUpperCase());
        System.out.println("─────────────────────────────────────────────");
        System.out.println("   Amount: R " + amount);
        System.out.println("   VAT (15%): R" + vatAmount);
        System.out.println("─────────────────────────────────────────────");
        System.out.println("   TOTAL: R " + getTotalAmount());
        System.out.println("╚════════════════════════════════════════════╝");
	
	
		// Show VAT explanation
		if (vatAmount.compareTo(BigDecimal.ZERO) > 0) {
			System.out.println("\n VAT applied: South African standard rate (15%)");
		} else {
			System.out.println("\n VAT exempt: " + 
				(type.equals("payshap") ? "Person-to-person transfer" : "Bank transfer"));
		}
		System.out.println();
	}
	
	//=================================================
	//TOSTRING (for debugging)
	//=================================================
	
	/**
	 * Returns string representation of transaction (for debugging)
	 * 
	 * @return String representation
	*/
	@Override
	public String toString() {
		return String.format(
			"Transaction[id=%s, account=%s, amount=%s, type=%s, status=%s, vat=%s]",
			transactionId, accountNumber, amount, type, status, vatAmount
		);							
	}
}
