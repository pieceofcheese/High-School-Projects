import java.util.Scanner;


public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//declaration
		int input;
		Scanner scan = new Scanner(System.in);
		
		//ask question
		System.out.println("Enter an integer:");
		
		//set the variable
		input = scan.nextInt();
		
		//decision on whether or not it's even
		if (input % 2 == 0) {
			System.out.println("The integer " + input + " is even");
		} else {
			System.out.println("The integer " + input + " is odd");
		}

	}

}
