package exercises;

import java.io.*;
import java.util.*;

public class AlphNames {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(new File("H:\\ComSci\\StudentScores.txt"));
		int max = -1;
		
		String text[] = new String[100];
		
		while (scan.hasNext()) {
			
			max++;
			text[max] = scan.nextLine();
		}
		
		scan.close();
		
		String texts = "";
		float sum, count;
		
		for(int j = 0; j <=max; j++) {
			
			Scanner scan1 = new Scanner(text[j]);
			sum = 0;
			count = 0;
			
			texts = "";
			
			texts = scan1.next() + "; average =";
			
			while(scan1.hasNext()) {
				
				int i = scan1.nextInt();
				sum = sum +i;
				count++;
				
			}
			
			System.out.println(texts + String.format("%5.0f", (sum/count)));
			
		}
		
	}

}
