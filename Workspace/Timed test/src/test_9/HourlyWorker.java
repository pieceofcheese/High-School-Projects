package test_9;

public class HourlyWorker extends Worker {
	
	//constructor
	public HourlyWorker(String name, float wage) {
		
		super(name,wage);
		
	}
	
	//compute pay method
	public void computePay(int hour) {
		
		setHours(hour);
		
		if(getHours()>40) {
			
			setPayEarned(getWage()*40 + (getHours()-40)*getWage()/2);
			
		} else {

			setPayEarned(getHours()*getWage());
			
		}
		
	}

}
