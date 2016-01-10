package exercises;

import java.util.Scanner;

public class Lesson_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Blue Pelican Lesson 9 Exercises
		
		/**Exercise 14
		 * 
		 * Not Equal
		 */
		
		/**Exercise 15
		 * 
		 * Equal
		 */
		
		/**Exercise 16
		 * 
		 * j==20, m==201
		 */
		
		/**Exercise 17
		 * 
		 * boolean b = g==34
		 */
		
		//Exercise 18
		
		boolean b;
		int k=2;
		
		if (k % 2 ==0) {	
			b = true;
		} else {
			b = false;
		}
		
		//Exercise 19
		
		String password = "XRay", input;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your password");
		
		input = scan.next();
		
		if (input.equals(password)) {
			System.out.println("Password entered succesfully");
		} else {
			System.out.println("Incorrect password");
		}

	}

}
