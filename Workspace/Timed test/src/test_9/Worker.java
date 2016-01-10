package test_9;

public class Worker {
	
	//constructor
	public Worker(String named, float wages) {
		
		name = named;
		setWage(wages);
		
	}
	
	//methods
	
	//compute pay
	public void computePay(int hour) {
		
		setHours(hour);
		
		setPayEarned(getWage()*getHours());
		
	}
	
	//get setters
	public String getName() {
		
		return name;
		
	}
	
	public int getHours() {
		
		return hours;
		
	}
	
	public float getPay() {
		
		return getPayEarned();
		
	}
	
	public float getWage() {
		return wage;
	}

	public void setWage(float wage) {
		this.wage = wage;
	}

	public float getPayEarned() {
		return payEarned;
	}

	public void setPayEarned(float payEarned) {
		this.payEarned = payEarned;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	//state variables
	public String name;
	
	private int hours;
	
	private float payEarned, wage;

}
