package test_9;

public class SalariedWorker extends Worker {
	
	//constructor
	public SalariedWorker(String name, float wage) {
		
		super(name, wage);
		
	}
	
	//compute pay method
	public void computePay(int hour) {
		
		setHours(hour);
		
		setPayEarned(getWage()*40);
		
	}
	
}
