
public class Circle {

	//Constructor method
	public Circle(double r) {
		
		radius = r;
	}
	
	//Methods
	
	//area method
	public double area() {
		
		double a = Math.PI * radius * radius;
		return a;
	}
	
	//Circumference method
	public double circumference() {
		
		double c = 2 * Math.PI * radius;
		return c;
	}
	
	//diameter method
	public double diameter() {
		
		double d = 2 * radius;
		return d;	
	}
	
	//State Variables
	public double radius;

}
