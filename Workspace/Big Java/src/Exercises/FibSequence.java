package Exercises;

import java.util.Scanner;

public class FibSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//declaration
		int f1 = 1, f2 = 0, fnew, n;
		Scanner scan = new Scanner(System.in);
		
		//Ask for term, and take the input
		System.out.println("To what term of Fibonnaci's sequence do you want to solve for?");
		n = scan.nextInt();
		
		//finding the number
		for (int count = 0; count < n; count++){
			
			//adding the previous numbers
			fnew = f1 + f2;
			
			//reassigning variables
			f1 = f2;
			f2 = fnew;
			
		}
		
		//print answer
		System.out.println(f2);
		
		//end scanner
		scan.close();

	}

}
