package test_3;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//intialize variables
		boolean quit = false;
		double[] student;
		double target;
		double sale;
		double profitPer;
		
		//construct scanner object
		Scanner scan = new Scanner(System.in);
		
		//ask for the number of students fundraising
		System.out.println("How many students are fundraising?");
		student = new double[scan.nextInt()];
		
		//ask for the sales target
		System.out.println("How many sales, is the target for each student?");
		target = scan.nextDouble();
		
		//ask for the price of the item
		System.out.println("How much does each item sell for?");
		sale = scan.nextDouble();
		
		//ask for the profit margin
		System.out.println("How much profit do you make per item?");
		profitPer = scan.nextDouble();
		
		//menu loop
		do {
			
			//print out the menu
			System.out.println("\n\nWhat would you like to do?\n1. Add to sales\n2. Print current results\n3. Quit");
			
			//switch for menu
			switch(scan.nextInt()) {
			
			//add sales to each person
			case 1: // loop so that you can add to each person
					for(int y = 0; y<student.length; y++) {
						
						//ask for each student and add to total
						System.out.println("How many sales has student " + (y+1) + " made?");
						student[y] = scan.nextDouble();
					} 
					break;
			
			case 2: //Print out choice
					
					//initialize new variables
					double high = 0;
					double low = 0;
					double totalSaleValue = 0;
					double profit = 0;
					double deficit = 0;
					
					//for loop deciding the lowest and highest values
					for (int y = 0; y<student.length; y++) {
						
						//if it's the highest
						if (student[y]>high||high==0) {
							
							high = student[y];
						} 
						
						//if it's the lowest
						if (student[y]<low||low==0) {
							
							low = student[y];
						}
						
					}
					
					//calculations for totals (sale, profit, owe)
					for (int y = 0; y<student.length; y++) {
						
						totalSaleValue += student[y]*sale;
						profit += student[y]*profitPer;
						deficit += student[y]*(sale-profitPer);
					}
					
					//beginning of printing
					System.out.println("**********************************************");
					
					//for loop to print each students statistics
					for (int y = 0; y<student.length; y++) {
						
						//print out which student and how much he/she made
						System.out.println("Student " + (y+1) + " raised $" + String.format("%5.2f",(student[y]*sale)));
						
						//if/else to decide whether he is above or below the target
						if ((student[y])<target) {
							
							//if he's below the target
							System.out.println("The student is $" + String.format("%5.2f",((target*sale)-(student[y]*sale))) + " under the target\n");
						} else {
							
							//if he's above the target
							System.out.println("The student is $" + String.format("%5.2f",((student[y]*sale)-(target*sale))) + " over the target\n");
						}
					}
					
					//print out the high/low, and other pertinent data
					System.out.println("**********************************************");
					System.out.println("Results for band Fundraiser:");
					System.out.println("Lowest amount:\t\t$" + String.format("%5.2f",(low*sale)));
					System.out.println("Highest amount:\t\t$" + String.format("%5.2f",(high*sale)) + "\n");
					System.out.println("Total value of sales\t$" + String.format("%5.2f",totalSaleValue));
					System.out.println("Total money raised:\t$" + String.format("%5.2f",profit));
					System.out.println("Total owes to supplier:\t$" + String.format("%5.2f",(deficit)));
					System.out.println("**********************************************");
					
					break;
					
			case 3: //quit the while loop
					quit = true;
					break;
			
			default://if the user doesn't enter a valid choice 
					System.out.println("Please enter a valid choice.");
			}
			
		} while(quit!=true);
		
		//end the scanner object
		scan.close();

	}

}

/**
 * I used mainly for loops because it was faster and more efficient to code 
 * with since it doesn't use a variable I would need to account for throughout
 * the program. The only while loop is hooked up to a boolean value so as to 
 * stop the loop and kill the program since I find while loops are much more
 * useful with a loop that won't be repeated often if at all, while while loops
 * are excellent at going through data and processing data.
 */
