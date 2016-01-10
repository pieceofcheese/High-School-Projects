import java.util.LinkedList;
import java.util.Scanner;


public class P202 {

	public static void main(String[] args) {
		
		
		LinkedList<String> staffs = new LinkedList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		boolean cont = true;
		
		while(cont) {
			
			System.out.println("Type a string or type exit");
			
			String temp = scan.next();
			
			if(temp.equalsIgnoreCase("exit")) {
				
				cont = false;
				
			} else {
				
				staffs.add(temp);
				
			}
			
		}
		
		
		reverse(staffs);
		
		for(String name : staffs) {
			
			System.out.println(name);
			
		}
		
	}
	
	public static void reverse(LinkedList<String> staff) {
		
		int index = staff.size();
		
		for(int x = 1; x<=staff.size(); x++) {
			
			String s = staff.remove();
			staff.add(staff.size()-x+1, s);
			System.out.println(s);
			
			
		}
		
	}
	
}
