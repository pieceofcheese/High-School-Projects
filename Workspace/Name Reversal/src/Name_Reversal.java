import java.util.Scanner;


public class Name_Reversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Declarations
		String input, output = "";
		int length, remaining;
		
		//class object initialization
		Scanner scan = new Scanner(System.in);
		
		//ask question and store input
		System.out.println("Please enter your name.");
		input = scan.nextLine();
		
		//find the length of input and set as variables
		length = input.length();
		remaining = input.length();
		
		//counting down the necessary number of operations
		for (int count = 0; count<length; count++) {
			
			//reducing the charAt value
			--remaining;
			
			//adding the char to the string
			output += input.charAt(remaining);
		}
		
		//print out reversed name
		System.out.println(output.toLowerCase());

	}

}
