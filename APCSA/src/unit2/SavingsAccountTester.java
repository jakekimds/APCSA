package unit2;

public class SavingsAccountTester {

	public static void main(String[] args) {
		SavingsAccount account = new SavingsAccount(1000, 10);
		account.addInterest();
		System.out.println(account.getBalance());
	}

}
