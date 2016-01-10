import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class P206 {

	public static void main(String[] args) {
		
		currentSize = 0;
		list = new LinkedList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		boolean quit = false;
		
		while(!quit) {
			
			System.out.println("Type object name or exit to quit");
			
			String text = scan.next();
			
			if(text.equalsIgnoreCase("exit")) {
				
				quit = true;
				
			} else {

				list.add(text);
				currentSize++;
				
			}
			
		}
		
		quit = false;
		
		while(!quit) {
			
			System.out.println("What do you want to do?");
			System.out.println("Add");
			System.out.println("Remove");
			System.out.println("See elements");
			System.out.println("Get size");
			System.out.println("Quit");
			
			switch(scan.next().charAt(0)) {
			
			case('A'): System.out.println("What do you want to add");
						add(scan.next());
						break;
			
			case('R'): System.out.println("What do you want to remove?");
						remove(scan.next());
						break;
			
			case('S'): printElements();
			break;
			
			case('G'): size();
			break;
				
			case('Q'): quit = true;
			break;
			
			default: System.out.println("Please type the first character of one of the selections");
			}
			
		}
		scan.close();
		
	}
	
	public static void add(String s) {
		
		list.add(s);
		currentSize++;
		
	}
	
	public static void remove(String s) {
		
		list.remove(s);
		currentSize--;
		
	}
	
	public static void size() {
		
		System.out.println(currentSize);
		
	}
	public static void printElements() {
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
			
		}
		
		System.out.println("");
		
	}
	
	static LinkedList<String> list;
	public static int currentSize;
	
}
