package hashset;

import java.util.*;

public class Union {
	
	public static void main(String[] args) {
		
		Set<String> s1 = new HashSet<String>();
		s1.add("Bill");
		s1.add("Larry");
		s1.add("Adolph");
		s1.add("Regina");
		s1.add("Susie");
		
		Set<String> s2 = new HashSet<String>();
		s2.add("Larry");
		s2.add("Jack");
		s2.add("Alice");
		s2.add("June");
		s2.add("Benny");
		s2.add("Susie");
		
		//build the union set, s3
		Set<String> s3 = s1;
		s3.addAll(s2);
		
		//print the intersection set
		Iterator<String> iter1 = s3.iterator();
		while(iter1.hasNext()) {
			
			System.out.println(iter1.next());
			
		}
		
	}

}
