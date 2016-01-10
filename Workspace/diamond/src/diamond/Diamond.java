package diamond;

import java.util.Scanner;

public class Diamond {
	
	public static void main(String[] args) {
		
		//variables, and objects
		int amount;

		int count = 1;
		int count2 = 1;
		Scanner scan = new Scanner(System.in);
		
		amount = scan.nextInt();
		
		//print top
		for(int x = 0; x<amount; x++) {
			
			//print space
			for(int y = 0; y<amount-count2; y++) {
				
				System.out.print(" ");
				
			}
			
			//print asteriks
			for(int y = 0; y<count; y++) {
				
				System.out.print("*");
				
			}
			
			//make next line
			System.out.println("");
			
			//increment up
			count += 2;
			count2 += 1;
			
		}
		
		//change variables for next loop
		count -= 2;
		count2 -= 1;
		
		//print bottom
		for(int x = 0; x<amount-1; x++) {
			
			//increment
			count += -2;

			count2 -= 1;
			
			//print space
			for(int y = 0; y<amount-count2; y++) {
				
				System.out.print(" ");
				
			}
			
			//print space
			for(int y = 0; y<count; y++) {
				
				System.out.print("*");
				
			}
			
			//print next line
			System.out.println("");

		}
		
		
	}

}
