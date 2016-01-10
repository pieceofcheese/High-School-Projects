package test_5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//initialize variables
		int[] chuck = new int[5];
		int[] steven = new int[5];
		int chuckTotal = 0, stevenTotal = 0;
		int chuckAverage, stevenAverage;
		
		//construct scanner object
		Scanner scan = new Scanner(System.in);
		
		//ask for amount made
		for(int x = 0; x<5; x++) {
			
			System.out.println("Please enter the amount Chuck made in his movie number " + (x+1));
			chuck[x] = scan.nextInt();
			
			System.out.println("Please enter the amount Steven made in his movie number " + (x+1));
			steven[x] = scan.nextInt();
			
		}
		
		//sort arrays
		Arrays.sort(chuck);
		Arrays.sort(steven);
		
		//calculate average earned
		chuckAverage = (chuck[0] + chuck[1] + chuck[2] + chuck[3] + chuck[4])/5;
		stevenAverage = (steven[0] + steven[1] + steven[2] + steven[3] + steven[4])/5;
		
		//print out headers
		System.out.println("REPORT:");
		System.out.println("Chuck Movies\tSteven Movies");
		
		//print out each movie's profit and add to total
		for(int x = 0; x<5; x++) {
			
			//print out profit
			System.out.println(chuck[x] + "\t" + steven[x]);
			
			//add to total
			chuckTotal += chuck[x];
			stevenTotal += steven[x];
		}
		
		//Print out average and, total
		System.out.println("Average amount earned for Chuck : $" + chuckAverage);
		System.out.println("Average amount earned for Steven : $" + stevenAverage);
		System.out.println("Total amount earned for Chuck : $" + chuckTotal);
		System.out.println("Total amount earned for Steven : $" + stevenTotal);
		
		//decide on who wins
		if (chuckTotal>stevenTotal) {
			
			//chuck wins
			System.out.println("The greatest of them all is: Chuck Norris");
		} else {
			
			if(stevenTotal>chuckTotal) {
				
				//steven wins
				System.out.println("The greatest of them all is: Steven Seagal");
			} else {
				
				//tie
				System.out.println("The greates of them all is: Chuck Testa! It's a tie!");
			}
		}
		scan.close();
	}

}
