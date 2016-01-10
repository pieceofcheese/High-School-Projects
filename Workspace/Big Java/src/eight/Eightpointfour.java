package eight;

import java.util.ArrayList;
import java.util.Scanner;

public class Eightpointfour {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aryList = new ArrayList<String>();
		
		for (int l = 0; l<10; l++) {
			
			aryList.add(scan.nextLine());
			
		}
		
		for (int l = 9; l>=0; l--) {
			
			System.out.println(aryList.get(l));
			
		}
		
	}

}
