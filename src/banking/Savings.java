package banking;

public class Savings extends Account {

	private double interestRate = 0.12;
	
	public double CalculateAndPayInterest(int months) {
		double interest = getBalance() * (getInterestRate() / 12) * months;
		deposit(interest);
		return interest;
	}

	public Savings() {
		this("New Savings Account");
	}

	public Savings(String description) {
		super(description);
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
