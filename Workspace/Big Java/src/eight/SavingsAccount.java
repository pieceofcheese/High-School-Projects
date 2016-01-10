package eight;

public class SavingsAccount extends Account {
	
	//constructor
	public SavingsAccount(double balance, double interestRate) {
		
		super(balance);
		rate = interestRate;
		
	}
	
	//add
	public void addInterest() {
		
		super.balance += balance*(rate/100);
		
	}
	
	double rate;

}
