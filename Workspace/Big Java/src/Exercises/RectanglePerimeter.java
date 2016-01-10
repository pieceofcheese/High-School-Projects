package Exercises;

import java.awt.Rectangle;

public class RectanglePerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variable declaration
		double perimeter;
		
		//object construction
		Rectangle r1 = new Rectangle(5, 10, 20, 30);
		
		//calculation
		perimeter = 2*r1.getWidth() + 2*r1.getHeight();
		
		//print out
		System.out.println("The perimeter of the rectangle is " + perimeter);

	}

}
