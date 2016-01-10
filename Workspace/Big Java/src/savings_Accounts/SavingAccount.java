package savings_Accounts;

public class SavingAccount {
	
	//Constructor method
	public SavingAccount(double b, double i) {
		
		balance = b;
		interest = i;
	}
	
	//Methods
	
	//adding to the balance with interest method
	public void addInterest() {
		
		balance += balance * (interest/100);
	}
	
	//getting the balance method
	public double getBalance() {
		
		return balance;
	}
	
	//Static variables
	
	private double balance;
	private double interest;

}
