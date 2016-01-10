package bank_Project;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Account ac = new Account(0);
		
		ac.deposit(1000);
		ac.withdraw(500);
		ac.withdraw(400);
		ac.printBalance();

	}

}
