package exercises;

import java.util.Scanner;

public class Lesson_12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		int k = 0;
		int p = 0;
		double q = 0;
		int v = 2;
		
		//Blue Pelican Lesson 12 Exercises
		
		//Exercise 1
		
		while (x<y) 
		{
			
		}
		
		//Exercise 2
		
		do
		{
			
		}
		while (x>y);
		
		//Exercise 3
		int m = 97;
		while (m<=195) {
			k = k * k + 3 * m;
			p = p + m + 1;
			m++;
		}
		
		//Exercise 4
		
		do {
			k = k * k + 3 * v;
			q = Math.sqrt(q + v + 1);
			v*=3;
		} while (v<=195);
		
		/** Exercise 5
		 * 
		 * if(i<1)
		 */
		
		/**Exercise 6
		 * 
		 * The do has a semicolon on the end of it
		 */
		
		/**Exercise 7
		 * 
		 * An infinite number of times
		 */
		
		//Exercise 14
		
		//declarations
		
		int input, output;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("Enter an integer");
			input = scan.nextInt();
			
			if (input == 0) {
				break;
			} else {
				
				output = input^2;
				System.out.println("Your number squared is " + output);
			}
		} while (true);
		
		

	}

}
