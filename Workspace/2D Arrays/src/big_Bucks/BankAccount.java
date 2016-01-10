package big_Bucks;

public class BankAccount {

	public BankAccount(String nm, double amt) {
		
		name = nm;
		balance=amt;
	}
	
	public void deposit(double dp) {
		
		balance += dp;
	}
	
	public void withdraw(double wd) {
		
		balance -= wd;
	}
	
	public String name;
	public double balance;
	
}
