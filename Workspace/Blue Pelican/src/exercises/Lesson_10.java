package exercises;

import java.util.Scanner;

public class Lesson_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Blue Pelican Lesson 10 exercise
		
		/**Exercise 1
		 * 
		 * Two permissible data types for a switch are int and char.
		 */
		
		/**Exercise 2
		 * 
		 * -4
		 */
		
		//Exercise 3
		
		char myChar;
		int y = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Write down a character");
		myChar = scan.next().charAt(0);
		
		switch(myChar) {
			case 'g':
			case 'G': ++y;
				break;
			
			case 'm':
			case 'M': --y;
				break;
			
			default: y+=100;
				break;
		}
		
		System.out.println("y is " + y);
		
		/**Exercise 4
		 * 
		 * The output of the code is 3
		 */
		
		/**Exercise 5
		 *
		 * char chr = 'z';
		 */
		
		/**Exercise 6
		 * 
		 * The first output is "The sum is 1012"
		 * The second output is "The sum is 22"
		 */
		
		//Exercise 7
		
		int speed = scan.nextInt();
		switch(speed) {
		
		case 75: System.out.println("Exceeding speed limit");
			break;
			
		case 70:
		case 69: System.out.println("Getting close");
			break;
			
		case 65: System.out.println("Cruising");
			break;
			
		default: System.out.println("Very slow");
			break;
		}
		
		/**Exercise 8
		 * 
		 * No, default is not a necessary part of a switch structure
		 */
		
		//Exercise 9
		
		String s = "x";
		char chr = s.charAt(0);

	}

}
