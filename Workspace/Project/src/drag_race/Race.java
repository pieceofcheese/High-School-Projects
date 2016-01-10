package drag_race;

public class Race {
	
	public Race(int x) {
		
		//initialize arrays
		names = new String[x];
		torque = new double[x];
		mass = new double[x];
		RPM = new double[x];
		ratio = new double[x];
		wheel = new double[x];
		
		//initialize variable
		distanceFeet = 1320;
		
		//fill in array with hocus
		for (int y = 0; y<mass.length; y++) {
			
			names[y] = "null";
			torque[y] = 150;
			mass[y] = 1000;
			RPM[y] = 5000;
			ratio[y] = 3.54;
			wheel[y] = (1.08333333);
		}
		
	}
	
	//return the number of cars
	public int getNumberOfCars() {
		
		return names.length;
	}
	
	//change the number of cars 
	public void setNumberOfCars(int x) {
		
		//create temp arrays
		String[] tempNames = new String[x];
		double[] tempTorque = new double[x];
		double[] tempMass = new double[x];
		double[] tempRPM = new double[x];
		double[] tempRatio = new double[x];
		double[] tempWheel = new double[x];
		
		//decide whether you're making more or less cars
		if (x<names.length) {
			
			//fill temp array for less cars
			for (int c = 0; c<x; c++) {
				
				tempNames[c] = names[c];
				tempTorque[c] = torque[c];
				tempMass[c] = mass[c];
				tempRPM[c] = RPM[c];
				tempRatio[c] = ratio[c];
				tempWheel[c] = wheel[c];
			}
			
		//fill temp array for more cars
		} else {
			
			for(int c = 0; c<names.length; c++) {
				
				tempNames[c] = names[c];
				tempTorque[c] = torque[c];
				tempMass[c] = mass[c];
				tempRPM[c] = RPM[c];
				tempRatio[c] = ratio[c];
				tempWheel[c] = wheel[c];
			}
		}
		
		
		
		//change original arrays to new size
		names = new String[x];
		torque = new double[x];
		mass = new double[x];
		RPM = new double[x];
		ratio= new double[x];
		wheel= new double[x];
		
		//fill in array with hocus
		for (int y = 0; y<mass.length; y++) {
					
			names[y] = "null";
			torque[y] = 150;
			mass[y] = 1000;
			RPM[y] = 5000;
			ratio[y] = 3.54;
			wheel[y] = (1.08333333);
		}
		
		//fill original arrays again
		for (int y = 0; y<mass.length; y++) {
			
			names[y] = tempNames[y];
			torque[y] = tempTorque[y];
			mass[y] = tempMass[y];
			RPM[y] = tempRPM[y];
			ratio[y] = tempRatio[y];
			wheel[y] = tempWheel[y];
			
		}
	}
	
	//return the name of a car
	public String getName(int x) {
		
		--x;
		return names[x];
	}
	
	//change a car's name
	public void setName(int x, String y) {
		--x;
		names[x] = y;
	}
	
	//return the horsepower of a car
	public double getTorque(int x) {
		
		--x;
		return torque[x];
	}
	
	//change the horsepower of a car
	public void setTorque(int x, double y) {
		
		--x;
		torque[x] = y;
	}
	
	//return the mass of a car
	public double getMass(int x) {
		
		--x;
		return mass[x];
	}
	
	//change the mass of a car
	public void setMass(int x, double y) {
		
		--x;
		mass[x] = y;
	}
	
	//return the distance the cars will travel
	public double getDistance() {
		
		return distanceFeet;
	}
	
	//change the cars distance using Miles
	public void setDistanceM(double x) {
		
		//convert to feet
		distanceFeet = x * 5280;
	}
	
	//return the RPM at peak torque
	public double getRPM(int x) {
		
		return RPM[--x];
	}
	
	//change the RPM at peak torque
	public void setRPM(int x, double y) {
		
		RPM[--x] = y;
	}
	
	//return the wheel size
	public double getWheelSize(int x) {
		
		return wheel[--x];
	}
	
	//change the wheel size
	public void setWheelSize(int x, double y) {
		
		wheel[--x] = y;
	}
	
	//does final calculations and then prints the results
	public void race() {
		
		//initialize variables and arrays
		double[] acceleration = new double[names.length];
		double[] velocityFinal = new double[names.length];
		double[] velocityAverage = new double[names.length];
		double[] time = new double[names.length];
		int bestCarNumber = 0;
		double bestTime = 0;
		
		for (int c = 0; c<names.length; c++) {
			
			double force = torque[c]/ratio[c];
			
			//fill arrays with calculations
			acceleration[c] = (torque[c]*ratio[c]/wheel[c])/mass[c];
			time[c] = Math.sqrt(((2*distanceFeet)/acceleration[c]))/10;
			velocityFinal[c] = (distanceFeet + ((0.5*acceleration[c]*(time[c]*time[c]))))/time[c];
			velocityAverage[c] = distanceFeet/time[c];
		}
		
		//comparisons for best time, and set the value
		for (int c = 0; c<names.length; c++) {
			
			if (bestTime == 0) {
				
				bestTime = time[0];
			} 
			
			if (time[c]<bestTime) {
				
				bestCarNumber = c;
				bestTime = time[c];
			}
		}
		
		//printing out the table
		System.out.println("The fastest car is the " + names[bestCarNumber] + " with a time of " + String.format("%5.2f",bestTime) + "s");
		System.out.println("");
		System.out.println("Car:\t\tFinal Velocity:\tAverage Velocity:\tHorsepower:\tTime:");
		
		for (int c = 0; c<names.length; c++) {
			
			//converts the values to Miles per hour
			double velocityFinalMPH = (velocityFinal[c]/5280)*3600;
			double velocityAverageMPH = (velocityAverage[c]/5280)*3600;
			
			System.out.println(names[c] + "\t" + String.format("%5.2f", velocityFinalMPH) + "M/h\t" + String.format("%5.2f", velocityAverageMPH) + "M/h\t\t" + String.format("%5.0f", ((torque[c]*RPM[c])/5252)) + "HP \t" + String.format("%5.2f",time[c]) + "s");
		}
		
		//to make the output prettier
		System.out.println("\n\n");
	}
	
	//static variables
	private String[] names;
	private double[] torque;
	private double[] mass;
	private double[] RPM;
	private double[] ratio;
	private double[] wheel;
	private double distanceFeet;

}
