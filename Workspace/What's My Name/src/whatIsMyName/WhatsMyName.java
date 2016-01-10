package whatIsMyName;

import java.util.Scanner;

public class WhatsMyName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//initialize variable
		String first, last, name;
		
		//initialize input scanner
		Scanner scan = new Scanner(System.in);
		
		//ask question
		System.out.println("What is your first name?_");
		
		//asking scanner to listen
		first = scan.next();
		
		//ask question
		System.out.println("What is your last name?_");
		
		//asking scanner to listen
		last = scan.next();
		
		//putting the first and last names together
		name = first + " " + last;
		
		//sending out the name
		System.out.println("Your full name is " + name);

	}

}
