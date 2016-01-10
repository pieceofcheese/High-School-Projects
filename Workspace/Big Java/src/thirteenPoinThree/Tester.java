package thirteenPoinThree;

import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Where is the center of the square?");
		System.out.println("(x y)");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		System.out.println("What is the side length of the square?");
		int side = scan.nextInt();
		
		Square sqr = new Square(x,y,side);
		
		System.out.println(sqr.toString());
		System.out.println(sqr.getArea());
		
	}

}
