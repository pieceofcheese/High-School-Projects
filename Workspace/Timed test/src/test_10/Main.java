package test_10;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		//initialize variables
		int count = 0;

		//Input
		Scanner scan = new Scanner(new File("H:\\ComSci\\worldTop30ConsumptionOil_Raw.in"));
		
		//:P DICTIONARIEES
		Dictionary<Integer,String> country = new Hashtable<Integer,String>();
		Dictionary<Integer,Float> production = new Hashtable<Integer,Float>();
		Dictionary<Integer,Float> consumption = new Hashtable<Integer,Float>();
		Dictionary<Integer,Float> productionHigh = new Hashtable<Integer,Float>();
		Dictionary<Integer,Float> productionLow = new Hashtable<Integer,Float>();
		Dictionary<Integer,Float> consumptionHigh = new Hashtable<Integer,Float>();
		Dictionary<Integer,Float> consumptionLow = new Hashtable<Integer,Float>();
		
		//Output
		FileWriter fw = new FileWriter("H:\\ComSci\\oilOut.txt");
		PrintWriter print = new PrintWriter(fw);
		
		//scan and put in data
		while(scan.hasNext()) {
			
			//count increment
			count++;
			
			//boolean for later
			boolean zero = false;
			
			//get name
			country.put(count, scan.next());
			
			for(int x = 0; x<15; x++) {
				
				float con = scan.nextFloat();
				
				if(con == 0) {
					
					zero = true;
					
				}
				
				try {
					
					if(consumptionLow.get(count)>con) {
						
						consumptionLow.put(count, con);
						
					}
					
				}
				
				catch (NullPointerException e) {
					
					consumptionLow.put(count, con);
					
				}
				
				try {
					
					if(consumptionHigh.get(count)<con) {
						
						consumptionHigh.put(count, con);
						
					}
					
				}
				
				catch (NullPointerException e) {
					
					consumptionHigh.put(count, con);
					
				}
				
				
				try {
					
					float avg = consumption.get(count) + con/15;
						
					consumption.put(count, avg);
					
				}
				
				catch (NullPointerException e) {
					
					consumption.put(count, con/15);
					
				}
				
				
			}
			
			if(zero) {
				 
				consumption.put(count, (float) 0);
				
			}
			
		}
		scan.close();
		
		//scan data
		Scanner scan1 = new Scanner(new File("H:\\ComSci\\worldTop30ProductionOil_Raw.in"));
		
		while(scan1.hasNext()) {
			
			count++;
			boolean zero = false;
			
			country.put(count, scan1.next());
			
			for(int x = 0; x<15; x++) {
				
				float con = scan1.nextFloat();
				
				if(con == 0) {
					
					zero = true;
					
				}
				
				try {
					
					if(productionLow.get(count)>con) {
						
						productionLow.put(count, con);
						
					}
					
				}
				
				catch (NullPointerException e) {
					
					productionLow.put(count, con);
					
				}
				
				try {
					
					if(productionHigh.get(count)<con) {
						
						productionHigh.put(count, con);
						
					}
					
				}
				
				catch (NullPointerException e) {
					
					productionHigh.put(count, con);
					
				}
				
				try {
						
					float avg = production.get(count) + con/15;
						
					production.put(count, avg);
					
				}
				
				catch (NullPointerException e) {
					
					production.put(count, con/15);
					
				}
				
				
			}
			
			if(zero) {
				 
				production.put(count, (float) 0);
				
			}
			
		}
		
		//initialize variables
		int[] top = {0,0,0};
		int[] bot = {0,0,0};
		
		for(int x = 1; x<=60; x++) { 
			
			if(x<=30) {
				
				if(consumption.get(x)>bot[0]) {
					bot[2] = bot[1];
					bot[1] = bot[0];
					bot[0] = x;
					
				} else {
					
					if(consumption.get(x)>bot[1]) {
						
						bot[2] = bot[1];
						bot[1] = x;
						
					}else {
						
						if(consumption.get(x)>bot[2]) {
							
							bot[2] = x;
							
						}
						
					}
					
				 }
				
			} else {
				
				int counts = x;
				if(production.get(counts)>top[0]) {
					
					top[2] = top[1];
					top[1] = top[0];
					top[0] = counts;
					
				} else {
					
					if(production.get(counts)>top[1]) {
						
						top[2] = top[1];
						
						top[1] = counts;
						
					}else {
						
						if(production.get(counts)>top[2]) {
							
							top[2] = counts;
							
						}
						
					}
					
				 }
				
			}
			
		}
		scan1.close();
		
		//console print
		for(int x = 0; x<3; x++) {
			
			System.out.println(country.get(top[x]) + " " + production.get(top[x]) + " production");
			
		}
		
		for(int x = 0; x<3; x++) {
			
			System.out.println(country.get(bot[x]) + " " + consumption.get(bot[x]) + " consumption");
			
		}
		
		for(int x = 1; x<=60; x++) {
			
			if(x<=30) {
				
				print.println(country.get(x) + " " + consumption.get(x) + " OilConsumption" + " High " + consumptionHigh.get(x) + " Low " + consumptionLow.get(x));
				
			} else {
				
				print.println(country.get(x) + " " + production.get(x) + " OilProduction" + " High " + productionHigh.get(x) + " Low " + productionLow.get(x));
				
			}
			
		}
		
		print.close();
		fw.close();
	}

}
