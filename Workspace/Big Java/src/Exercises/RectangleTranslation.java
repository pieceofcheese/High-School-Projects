package Exercises;

import java.awt.Rectangle;

public class RectangleTranslation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variable declarations
		int x, y;
		 
		//object construction
		Rectangle r = new Rectangle(0, 0, 10 ,20);
		
		//print out rectangle
		System.out.println(r);
		
		//translation calculation
		x = (int) r.getWidth();
		y = (int) (r.getHeight() * 0);
		
		//translation
		r.translate(x, y);
		
		//print out rectangle
		System.out.println(r);
		
		//translation calculation
		x = (int) (r.getWidth() * 0);
		y = (int) (r.getHeight());
		
		//translation
		r.translate(x, y);
		
		//print out rectangle
		System.out.println(r);
		
		//translation calculation
		x = (int) (r.getWidth()*-1);
		y = (int) (r.getHeight() * 0);
		
		//translation
		r.translate(x, y);
		
		//print out rectangle
		System.out.println(r);

	}

}
