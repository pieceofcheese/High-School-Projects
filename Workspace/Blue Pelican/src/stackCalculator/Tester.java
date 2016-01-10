package stackCalculator;

import java.util.Scanner;

public class Tester {
	
	static StackLL stack;
	
	public static void main(String[] args) {
		
		//initialize variables
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		stack = new StackLL();
		
		//menu loop
		while(!quit) {
			
			System.out.println("Enter Number, math operation(+,-,*, or /), or Q to quit");
			
			String scanned = scan.next();
			
			//go through what to do
			switch(scanned.charAt(0)) {
				
			case 'Q' : quit = true;
			break;
			
			case '+' : add();
			break;
			
			case '-' : subtract();
			break;
			
			case '*' : multiply();
			break;
			
			case '/' : divide();
			break;
			
			default: stack.push(Double.parseDouble(scanned));
				
			}
			
		}
		
		//print answer
		System.out.println("The answer is " + stack.pop());
		
	}

	//divide method
	private static void divide() {
		double one = stack.pop();
		double two = stack.pop();
		
		double fin = two / one;
		stack.push(fin);
	}

	//multiply method
	private static void multiply() {
		double one = stack.pop();
		double two = stack.pop();
		
		double fin = two * one;
		stack.push(fin);
	}

	//subtract method
	private static void subtract() {
		double one = stack.pop();
		double two = stack.pop();
		
		double fin = two - one;
		stack.push(fin);
		
	}

	//addition method
	private static void add() {
		
		double one = stack.pop();
		double two = stack.pop();
		
		double fin = two + one;
		stack.push(fin);
		
	}

}
