package bankApp;

public class Savings extends Account {
	// List of properties specific to Savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;

	// Constructor to initialize Savings account properties
	public Savings(String name, String UID, double initialDeposit) {
		super(name, UID, initialDeposit);
		accountNumber = "1" + accountNumber;
		safetyDepositBox();
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}

	private void safetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}

	// List any methods specific to the Savings account

	@Override
	public void showInfo() {
		System.out.println("ACCOUNT-TYPE: Savings");
		super.showInfo();
		System.out
				.println("Your Savings Account Features: " + "\nSafety Deposit Box ID: " + safetyDepositBoxID
						+ "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
	}

}
