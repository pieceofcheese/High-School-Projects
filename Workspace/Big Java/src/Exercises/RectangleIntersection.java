package Exercises;

import java.awt.Rectangle;

public class RectangleIntersection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(0, 0, 10, 20);
		Rectangle r2 = new Rectangle(0, 0, 20, 10);
		Rectangle r3 = r1.intersection(r2);
		
		System.out.println(r1 +"\n" + r2 + "\n" + r3);

	}

}
