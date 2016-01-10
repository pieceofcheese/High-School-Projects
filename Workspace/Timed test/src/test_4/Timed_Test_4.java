package test_4;

import java.util.Scanner;

public class Timed_Test_4 {
	
	public static void main(String[] args) {
		
		//variable initialization
		String cont = "yes";
		int count = 0;
		double average, marks = 0;
		double[] mark = new double[count];
		
		//scanner construction
		Scanner scan = new Scanner(System.in);
		
		//ask for the benchmark
		System.out.println("Enter the Benchmark value:");
		
		//construct class using benchmark
		Calc calc = new Calc(scan.nextDouble());
		
		//loop for adding marks
		do {
			//adding to student count
			++count;
			
			//make a new temp array
			double[] markTemp = new double[count];
			
			//fill temp array with actual array variables
			for(int x = 0; x<(count-1); x++) {
				
				markTemp[x] = mark[x];
			}			
			
			//make actual array larger
			mark = new double[count];
			
			//refill actual array
			for(int x = 0; x<count; x++){
				
				mark[x] = markTemp[x];				
			}
			
			//ask for student mark
			System.out.println("Enter student mark:");			
			mark[(count-1)] = scan.nextDouble();
			
			//send the mark to the calc class to process
			calc.traffic_Light(mark[(count-1)]);
			
			//ask if you'd like to add marks for another student
			System.out.println("Do you have another student to enter marks for? (type yes to continue)");
			cont = scan.next();
			
		//check if they wan to continue
		} while(cont.equalsIgnoreCase("yes"));
		
		//add the marks together
		for(int x = 0; x<count; x++) {
			
			marks += mark[x];
			
		}
		
		//get the average of the marks
		average = (marks/(double)(count*100))*100;
		
		//print the average for the class
		System.out.println("The average mark for the 5 students is: " + String.format("%5.0f", average) + "%");
		
		scan.close();
		
	}

}
