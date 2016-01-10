package hashset;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class NoFinal {
	
	public static void main(String[] args) throws IOException {
		
		//make scanner and set
		Scanner scan = new Scanner(new File("H:\\ComSci\\text\\msInformed.txt"));
		Set<String> pass = new HashSet<String>();
		
		//make size modifiers
		int marks;
		int discipline;
		
		//fill them
		marks = scan.nextInt();
		discipline = scan.nextInt();
		
		//loop to check if any of their marks are below 89
		for(int x = 0; x<marks; x++) {
			
			String name = scan.next();
			String course = scan.next();
			
			//check if they are below 89
			if(scan.nextInt()<89) {
				
				//remove them from list
				pass.remove(name);
				
				//put them in list if above.
			} else {
				
				pass.add(name);
				
			}
			
		}
		
		//check if they have been disciplined
		for(int x = 0; x<discipline; x++) {
			
			String name = scan.next();
			String date = scan.next();
			String number = scan.next();
			
			//remove the name
			pass.remove(name);
			
		}
		
		//print remaining
		Iterator<String> iter = pass.iterator();
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
			
		}
		
		scan.close();
		
	}

}
