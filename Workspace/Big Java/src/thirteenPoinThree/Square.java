package thirteenPoinThree;

import java.awt.Rectangle;

public class Square extends Rectangle {
	
	//constructor
	public Square (int x, int y, int length) {
		
		//run superclass instructor
		super();
		
		//set dimensions, and location
		super.setLocation(x, y);
		super.setSize(length, length);
		
	}
	
	//method to get area
	public int getArea() {
		
		int a = super.height*super.height;
		
		return a;
	}


}
