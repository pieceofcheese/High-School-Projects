package test_11;

import java.util.ArrayList;

public class Actor {
	
	public Actor(String names){
		
		name=names;
		
	}
	
	public void addRevenue(float f) {
		
		revenue.add(f);
		
	}
	
	public float avgRevenue() {
		
		float total=0;
		
		for(int x=0; x<revenue.size(); x++) {
			
			total+=revenue.get(x);
			
		}
		
		return total/revenue.size();
		
	}
	
	public float getrevenue(){
		float total=0;
		
		for(int x=0; x<revenue.size(); x++) {
			
			total+=revenue.get(x);
			
		}
		
		
		return total;
	}
	
	public String name;
	public ArrayList<Float> revenue = new ArrayList<Float>();
	

}