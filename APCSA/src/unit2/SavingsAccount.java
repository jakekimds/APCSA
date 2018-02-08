package unit2;

public class SavingsAccount {
	private double balance;
	private double interest;

	public SavingsAccount() {
		balance = 0;
		interest = 0;
	}

	public SavingsAccount(double initialBalance) {
		balance = initialBalance;
		interest = 0;
	}

	public SavingsAccount(double initialBalance, double inst) {
		balance = initialBalance;
		interest = inst;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public void addInterest() {
		balance *= (1 + interest / 100);
	}

	public double getBalance() {
		return balance;
	}
}