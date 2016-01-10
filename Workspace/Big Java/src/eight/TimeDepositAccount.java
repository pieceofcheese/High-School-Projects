package eight;

public class TimeDepositAccount extends SavingsAccount {
	
	//constructor
	public TimeDepositAccount(int mM, double b, double r, double wP) {
		
		super(b, r);
		
		months = mM;
		penalty = wP;
		
	}
	
	//add interest
	public void addInterest() {
		
		//call saving account method
		super.addInterest();
		
		//reduce # of months
		months -= 1;
	}
	
	//withdrawing money
	public void withdraw(double w) {
		
		//call withdraw from Account
		super.withdraw(w);
		
		//check if the penalty should be applied
		if (months>0) {
			balance -= penalty;
		}
	}
	
	//get months remaining
	public int getMonths() {
		return months;
	}
	
	private int months;
	private double penalty;

}
