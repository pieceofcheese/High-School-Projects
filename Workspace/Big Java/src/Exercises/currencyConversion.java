package Exercises;

import java.util.Scanner;

public class currencyConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//declaration
		float rate, US, Euro;
		String input;
		char check;
		Scanner scan = new Scanner(System.in);
		
		//ask for conversion rate and take input
		System.out.println("What is the current conversion rate of the US dollar to the Euro?");
		rate = scan.nextFloat();
		
		//asking for conversion, and operation loop
		do {
			
			//asking for conversion and taking input
			System.out.println("What would you like to do?\n A. US -> Euro\n B.Euro -> US\n\n q to quit");
			input = scan.next();
			
			//setting the first letter as a character data type
			check = input.charAt(0);
			
			//checking if it should quit the program
			if (check == 'q') {
				break;
				
			//asking how much cash and then calculating
			} else {
				
				switch (check) {
					//US to Euro program
					case 'A':
					case 'a':	//asking for the monetary amount and storing input
								System.out.println("How much US dollars?");
								US = scan.nextFloat();
								
								//calculation
								Euro = rate * US;
								
								//print response
								System.out.println("You will have " + Euro + "Euros");
								break;
					
					//Euro to US program
					case 'B':
					case 'b':	//asking for the amount and storing the input
								System.out.println("How much Euros?");
								Euro = scan.nextFloat();
								
								//calculation
								US = Euro/rate;
								
								//printing response
								System.out.println("You will have " + US + "Dollars");
								break;
					
					//if you enter an invalid entry
					default:	
								//send back to selection
								break;
				}
			}
			//to break the loop in its entirety
			} while (check!=('q'));
		
		//close scanner
		scan.close();

	}

}
