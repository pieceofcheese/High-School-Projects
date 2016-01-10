package bank_Project;

public class MomTest {
	
	public static void main(String[] args) {
		
		Account momsSavings = new Account(1000);
		momsSavings.addInterest(10);
		
		System.out.println("The balance in momsSavings is $" + momsSavings.getBalance());
	}

}
