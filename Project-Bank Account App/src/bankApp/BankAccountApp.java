package bankApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {

		List<Account> accounts = new LinkedList<Account>();

		/*
		 * Savings savAcc1 = new Savings("Adam Eve", "859294913213", 2000);
		 * 
		 * Current crrAcc1 = new Current("Tim Wilson", "343885712582", 1500);
		 * savAcc1.showInfo(); savAcc1.compound(); savAcc1.printBalance();
		 * 
		 * System.out.println("********"); crrAcc1.showInfo(); crrAcc1.compound();
		 * crrAcc1.printBalance();
		 */



		// transactions
		/*
		 * savAcc1.deposit(5000); savAcc1.withdraw(100); savAcc1.transfer("Home Rent",
		 * 300);
		 */

		// Read a CSV file then create new accounts based on that data
		String file = "./data/AccountDetails.txt";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String UID = accountHolder[1];
			String accountType = accountHolder[2];
			Double initialDeposit = Double.parseDouble(accountHolder[3]);

			// System.out.println(name + " " + sSN + " " + accountType + " " +
			// initialDeposit);

			if (accountType.equals("Savings")) {
				// System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Savings(name, UID, initialDeposit));
			} else if (accountType.equals("Current")) {
				// System.out.println("OPEN A CURRENT ACCOUNT");
				accounts.add(new Current(name, UID, initialDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		// accounts.get(5).showInfo();
		for (Account acc : accounts) {
			System.out.println("\n*************");
			acc.showInfo();
		}

	}

}
