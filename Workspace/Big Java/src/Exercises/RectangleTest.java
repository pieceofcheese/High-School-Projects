package Exercises;

import java.awt.Rectangle;

public class RectangleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variable declarations
		double area;
		
		//object construction
		Rectangle rect1 = new Rectangle(5, 10, 20, 30);
		
		//calculation
		area = rect1.getWidth() * rect1.getHeight();
		
		//print results
		System.out.println("The area of the rectangle is " + area); 

	}

}
