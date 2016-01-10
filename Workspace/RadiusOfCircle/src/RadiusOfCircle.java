import java.util.Scanner;


public class RadiusOfCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//initialize variable
		double area, radius;
		
		//initialize scanner
		Scanner scan = new Scanner(System.in);
		
		//asking the question
		System.out.println("What is the area?_");
		
		//asking scanner to listen and interpret as double
		area = scan.nextDouble();
		
		//declaring radius
		radius = Math.sqrt(area/Math.PI);
		
		//printing answer
		System.out.println("Radius of your circle is" + radius);
		
	}
	
}
