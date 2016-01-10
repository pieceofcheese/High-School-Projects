package test_2;

import java.util.Scanner;

public class GradeConverter {
	
	public static void main(String[] args) {
		
		//initialize variables
		String name, testName, grade;
		int test, testTotal, input;
		double percent;
		
		//construct objects
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		do {
			
			//ask what they want to do
			System.out.println("What would you like to do?\n1. Input data\n2. Quit");
			input = scan1.nextInt();
			if (input == 2) {
				break;
			}
			
			//ask for name of student, and store
			System.out.println("What is the name of the Student?:");
			name = scan.nextLine();
			
			//ask for name of test, and store
			System.out.println("What is the name of the test?:");
			testName = scan.nextLine();
			
			//ask for students mark, and store
			System.out.println("What did the student get on the test?:");
			test = scan1.nextInt();
			
			//ask for what the test was out of, and store
			System.out.println("What was the test out of?:");
			testTotal = scan1.nextInt();
			
			//solve for the percent the student got
			percent = ((double)test/(double)testTotal)*100;
			
			//giant decision block to choose for the letter grade
			//(can't convert an integer to boolean in a switch statement :( )
			if (percent>=90) {
				
				//grade is 90% or higher
				grade = "A*";
			} 
			else 
			{ 
				
				if (percent>=80) {
					
					//grade is 80% or higher
					grade = "A";
				} 
				else 
				{ 
					
					if (percent>=70) {	
						
						//grade is 70% or higher
						grade = "B";
					} 
					else 
					{ 
						
						if (percent>=60) {	
							
							//grade is 60% or higher
							grade = "C";
						} 
						else 
						{
							
							if (percent>=50) {
								
								//grade is 50% or higher
								grade = "D";
							} 
							else 
							{ 
								
								//grade is below 50%
								grade = "F";
							}
						}
					}
				}
			}
			
			//print out the information
			System.out.println("Name:             \t" + name);
			System.out.println("Test Name:        \t" + testName);
			System.out.println("Marks:");
			System.out.println("Test Score:       \t" + test);
			System.out.println("Test out of:      \t" + testTotal);
			System.out.println("Percentage score:\t" + String.format("%5.1f", percent) + "%");
			System.out.println("Grade Scored:     \t" + grade);
			
			
		} while(input!=2);
		
		scan.close();
		scan1.close();
	}

}
