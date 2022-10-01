package banking;

public class Account {

	private static int nextAccountNbr = 1;
	private int accountNbr;
	private String description;
	private double balance;
	
	public Account() {
		this("New Account");
	}
	public Account(String description) {
		this.accountNbr = nextAccountNbr++;
		this.description = description;
		this.balance = 0;
	}
	
	public void deposit(double amount) throws IllegalArgumentException {
		if(!isAmountGtZero(amount)) {
			throw new IllegalArgumentException("amount must be >= zero");
		}
		this.setBalance(this.getBalance() + amount);
	}
	
	public void withdraw(double amount) throws IllegalArgumentException {
		if(!isAmountGtZero(amount)) {
			throw new IllegalArgumentException("amount must be >= zero");
		}
		if(!areFundsSufficient(amount)) {
			throw new IllegalArgumentException("insufficient funds");
		}
		this.setBalance(this.getBalance() - amount);
	}
	
	/*
	 *	If the withdraw fails, it is because either the amount is invalid
	 *	or there are insufficient funds and the IllegalArgument exception
	 *	is thrown.
	 *
	 * 	If the withdraw succeeds and the deposit fails, the amount is 
	 * 	redeposited back into the account and an exception is thrown
	 * 
	 * 	If no exceptions are thrown, the transfer succeeded.
	 */
	public void transfer(double amount, Account toAccount) throws IllegalArgumentException, Exception {
		// withdraw from the current account
		try {
			this.withdraw(amount);
		} catch(IllegalArgumentException ex) {
			throw ex;
		}
		// deposit to the other account
		try {
			toAccount.deposit(amount);
		} catch (IllegalArgumentException ex) {
			deposit(amount);
			throw new Exception("transfer failed");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%3d | %-16s | %7.2f", getAccountNbr(), getDescription(), getBalance());
	}
	
	private boolean isAmountGtZero(double amount) {
		return (amount >= 0) ? true : false;
	}
	private boolean areFundsSufficient(double amount) {
		return (this.getBalance() >= amount) ? true : false;
	}
	
	public int getAccountNbr() {
		return accountNbr;
	}
	public void setAccountNbr(int accountNbr) {
		this.accountNbr = accountNbr;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
