package eight;

import java.util.ArrayList;

public class Eightpointthree {
	
	public static void main(String[] args) {
		
		//initialize variables
		double max = 0,min = 0;
		
		//construct array list
		ArrayList<Account> aryLst = new ArrayList<Account>();
		
		//
		for(int j = 1; j<aryLst.size(); j++) {
			
			Account check = (Account) aryLst.get(j);
			
			if (check.balance<min) {
				
				min = check.balance;
				
			}
			
			if (check.balance>max) {
				
				max = check.balance;
				
			}
			
		}
	}

}
