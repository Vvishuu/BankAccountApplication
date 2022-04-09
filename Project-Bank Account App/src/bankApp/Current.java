package bankApp;

public class Current extends Account {
	// List of properties specific to Current account
	private int debitCardNumber;
	private int debitCardNumberPin;

	// Constructor to initialize Current account properties
	public Current(String name, String UID, double initialDeposit) {
		super(name, UID, initialDeposit);
		accountNumber = "2" + accountNumber;
		setDebtCard();
	}

	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
	}

	// List any methods specific to the Current account
	private void setDebtCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardNumberPin = (int) (Math.random() * Math.pow(10, 4));
	}

	@Override
	public void showInfo() {
		System.out.println("ACCOUNT-TYPE: Current");
		super.showInfo();
		System.out.println("Your Current Account Features: " + "\nYour Debit Card Number: " + debitCardNumber
				+ "\nYour Debit Card Number Pin: " + debitCardNumberPin);
	}

}
