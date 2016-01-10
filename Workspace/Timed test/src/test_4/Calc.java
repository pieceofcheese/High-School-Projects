package test_4;

public class Calc {
	
	//constructer class
	public Calc(double x) {
		
		benchmark = x;
		
	}
	
	//processing for traffic light
	public void traffic_Light(double x) {
		
		if ((benchmark + 10)<=x) {
			
			System.out.println("Green!!: the student has scored 10% above the benchmark.");
		} else {
			
			if((benchmark-10)<=x) {
				System.out.println("Amber!!: the student has scored within 10% of the benchmark.");
			} else {
				
				System.out.println("Red!!: the student has scored less than 10% of the benchmark.");
			}
			
		}
	}
	
	//static variables
	private double benchmark;

}
