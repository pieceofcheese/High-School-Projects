package big_Bucks;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		
		//initializ stuff
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String name;

		ArrayList<BankAccount> aryList = new ArrayList<BankAccount>();
		ListIterator<BankAccount> iter = aryList.listIterator();
		
		//loop till done with creating accounts
		do {
			
			//scan for name
			Scanner kbReader = new Scanner(System.in);
			System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort)");
			
			//get input
			name = kbReader.nextLine();
			
			//check for exit
			if(!name.equalsIgnoreCase("Exit")) {
				
				// ask amount in account
				System.out.print("Please enter the amount of the deposit.");
				double amount = kbReader.nextDouble();
				System.out.println(" "); //Gives an eye-pleasing blank line
				
				//create new account, and add to arrayLists
				BankAccount account = new BankAccount(name, amount);
				
				iter.add(account);	
			}
			
		} while(!name.equalsIgnoreCase("EXIT"));
		
		//Search aryList and print out the name and amount of the largest bank account
		BankAccount ba = iter.previous();
		double maxBalance = ba.balance;
		String maxName = ba.name;
		
		//go back through array
		while(iter.hasPrevious()) {
			
			//get previous bank account
			BankAccount temp = iter.previous();
			
			//check if it's bigger
			if(temp.balance>maxBalance) {
				
				//replace
				maxBalance = temp.balance;
				maxName = temp.name;
				
			}
			
		}
		
		/*for(int j = 1; j<aryList.size(); j++) {
			
			BankAccount check = (BankAccount) aryList.get(j);
			
			if(maxBalance<check.balance) {
				
				maxBalance = check.balance;
				maxName = check.name;	
			}
		}*/
		
		//formatting
		System.out.println("");
		
		//print biggest balance
		System.out.println("The account with the largest balance belongs to " + maxName + ".");
		System.out.println("The ammount is $" + maxBalance);
		
	}
	
	

}
