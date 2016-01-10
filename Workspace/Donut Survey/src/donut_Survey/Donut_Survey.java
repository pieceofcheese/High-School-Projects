package donut_Survey;

import java.util.Scanner;

public class Donut_Survey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variable initialization
		int [][]rsp;
		int studentsLength, denominator, s = 0;
		
		//scanner construction
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		//asking for # of donuts and input value as a length
		System.out.println("How many donut types are there?");
		String []donut = new String [scan.nextInt()];
		
		//ask what each donut is and put into an array
		for (int d = 0; d<donut.length; d++) {
			
			System.out.println("What is donut number " + (d+1));
			donut[d] = scan1.nextLine();
		}
		
		//ask how many students surveyed and make that the length of an array
		System.out.println("How many students did you survey?");
		studentsLength = scan1.nextInt();
		denominator = studentsLength;
		rsp = new int[donut.length][studentsLength];
		
		//the donut counter for the array
		for (int d = 0; d<donut.length; d++) {
			
			//the student counter for the array
			while (s<studentsLength) {
				
				//local variable declaration
				int input;
				
				//ask for d donut what s student had ranked it
				System.out.println("What is the rank of the " + donut[d] + " donut for person " + (s+1) + "?");
				input = scan.nextInt();
				
				//so that people input the right ranking
				if (input>4 || input<1) {
					//this sends the loop back without any data being saved
					System.out.println("Please rank within 1-4 (1 is best, 4 is worst)");
				} else {
					//this saves the rank into the array and continues the loop
					rsp[d][s] = input;
					s++;
				}
				
			}
			//set s as 0 again
			s = 0;
		}
		
		//print out header
		System.out.println("Donut\tPercent");
		
		for (int d = 0; d<donut.length; d++) {
			
			//print out what kind of donut the first table will be
			System.out.println(donut[d] + " ");
			
			//count for all 4 ranks
			for (int r = 0; r<4; r++) {
				
				//initialize a variable
				int count = 0;
				
				//loop that checks for if the value is the same and then adds to count
				for (int x = 0; x<studentsLength; x++) {
					if ((rsp[d][x]) == (r+1)) {
						count++;
					}
				}
				
				//solve for percent
				double percent = (((double)count/(double)denominator) * 100);
				
				//print out percentage and the rank
				System.out.println((r+1) + "\t" + String.format("%5.2f",percent));
				
			}
		}

	}

}
