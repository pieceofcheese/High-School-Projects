package exercises;

import java.io.*;
import java.util.*;

public class Lesson_25 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(new File("H:\\ComSci\\NumData.txt"));
		int maxIndx = -1;
		
		String text[] = new String[100];
		while(scan.hasNext()) {
			
			maxIndx++;
			text[maxIndx] = scan.nextLine();
			//System.out.println(text[maxIndx]);
			
		}
		
		scan.close();
		
		String answer = "";
		int sum;
		
		for(int j = 0; j <=maxIndx; j++) {
			
			Scanner scan1 = new Scanner(text[j]);
			sum = 0;
			answer = "";
			
			int d = scan1.nextInt();
			answer = answer + d;
			sum = sum +d;
			
			while(scan1.hasNext()) {
				
				int i = scan1.nextInt();
				answer = answer + " + " +i;
				sum = sum +i;
				
			}
			answer = answer + "=" + sum;
			System.out.println(answer);
			
		}
		
	}

}
