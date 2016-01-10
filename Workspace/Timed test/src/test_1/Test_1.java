package test_1;

import java.util.Scanner;

public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//declarations
		String student1, student2;
		float attendance1, attendance2, attendanceTotal;
		float test11, test12, test21, test22, test1T, test2T;
		float attendancePercent1, test1Percent1, test2Percent1;
		float attendancePercent2, test1Percent2, test2Percent2;
		Scanner scan = new Scanner(System.in);
		
		//ask and input students name
		System.out.println("What is the first student's name?");
		student1 = scan.next();
		
		System.out.println("What is the second student's name?");
		student2 = scan.next();
		
		//ask and input students attendance
		System.out.println("What was the total number of Math Club Sessions that " + student1 + " attended?");
		attendance1 = scan.nextInt();
		
		System.out.println("What was the total number of Math Club Sessions that " + student2 + " attended?");
		attendance2 = scan.nextInt();
		
		//ask and input total number of attendances
		System.out.println("How many Math Club sessions in total were there");
		attendanceTotal = scan.nextInt();
		
		//ask and input student 1's test marks
		System.out.println("What was the first test score for " + student1 + "?");
		test11 = scan.nextFloat();
		
		System.out.println("What was the second test score for " + student1 + "?");
		test21 = scan.nextFloat();
		
		//ask and input student 2's test marks
		System.out.println("What was the first test score for " + student2 + "?");
		test12 = scan.nextFloat();
		
		System.out.println("What was the second test score for " + student2 + "?");
		test22 = scan.nextFloat();
		
		//ask and input test total
		System.out.println("What was the first test out of?");
		test1T = scan.nextFloat();
		
		System.out.println("What was the second test out of?");
		test2T = scan.nextFloat();
		
		//calculate student 1's percentages
		attendancePercent1 = (attendance1/attendanceTotal)*100;
		test1Percent1 = (test11/test1T)*100;
		test2Percent1 = (test21/test2T)*100;
		 
		//calculate student 2's percentages
		attendancePercent2 = (attendance2/attendanceTotal)*100;
		test1Percent2 = (test12/test1T)*100;
		test2Percent2 = (test22/test2T)*100;
		
		//Print out the percentages for review
		System.out.println("Math Report:\n");
		System.out.println("Name: Test1 %:    Test2 %:    Attendance %:");
		System.out.println(student1 + " " + String.format("%5.2f",test1Percent1) + "%    " + String.format("%5.2f", test2Percent1) + "%    " + String.format("%5.2f", attendancePercent1) + "%");
		System.out.println(student2 + " " + String.format("%5.2f", test1Percent2) + "%    " + String.format("%5.2f", test2Percent2) + "%    " + String.format("%5.2f", attendancePercent2) + "%");


	}

}

/**I used string for the student names because a charSequence would be un-yieldy, and string offers convenience.
 * I used float for eveverything else because they needed to turn into a percent with decimal value, and you can't do that with an integer value.
 * 
 */
