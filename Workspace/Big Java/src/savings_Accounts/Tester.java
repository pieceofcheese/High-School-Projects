package savings_Accounts;

public class Tester {
	
	public static void main(String[] args) {
		
		SavingAccount ac1 = new SavingAccount(1000, 10);
		
		ac1.addInterest();
		ac1.addInterest();
		ac1.addInterest();
		ac1.addInterest();
		ac1.addInterest();
		System.out.println(ac1.getBalance());
	}

}
