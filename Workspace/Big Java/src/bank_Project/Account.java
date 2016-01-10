 package bank_Project;

public class Account {

	//Constructor method
	public Account(double b) {
		
		balance = b;
	}
	
	//Methods
	
	//Deposit method
	public void deposit(double d) {
		
		balance += d;
	}
	
	//Withdraw method
	public void withdraw (double w) {
		
		balance -= w;
	}
	
	//Print balance method
	public void printBalance() {
		
		System.out.println(String.format("%5.2f", balance));
	}
	
	//Get Balance method
	public double getBalance() {
		
		return balance;
	}
	
	//add Interest method
	public void addInterest(double i) {
		
		double add = balance * (i/100);
		balance += add;
	}
	
	//State variables
	
	private double balance;
	
}
