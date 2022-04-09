package bankApp;

public abstract class Account implements IBaseRate {
	// List of common properties for Saving and Current accounts
	private String name;
	private String UID;
	private double balance;

	static int index = 10000;// Unique 5-digit number
	protected String accountNumber;
	protected double rate;

	// Constructor to set base properties and initialize the account
	public Account(String name, String UID, double initialDeposit) {
		this.name = name;
		this.UID = UID;
		balance = initialDeposit;

		// Set account number
		index++;
		this.accountNumber = setAccountNumber();

		setRate();
	}

	public abstract void setRate();

	// Generate account number
	private String setAccountNumber() {
		String lastTwoOfUID = UID.substring(UID.length() - 2, UID.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfUID + uniqueID + randomNumber;
	}

	public void compound() {
		double accuredInterest = balance * (rate / 100);// balance is principle here
		balance += accuredInterest;
		System.out.println("Accured Interest: " + accuredInterest);
	}

	// List common methods - transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Deposited: " + amount);
		printBalance();
	}

	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawed: " + amount);
		printBalance();
	}

	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfered: " + amount + " to " + toWhere);
		printBalance();
	}

	public void printBalance() {
		System.out.println("Your Balance is: " + balance);
	}

	public void showInfo() {
		System.out.println(
				"NAME: " + name + "\nACCOUNT NUMBER: " + accountNumber + "\nBALANCE: " + balance + "\nRate: " + rate);
	}

}