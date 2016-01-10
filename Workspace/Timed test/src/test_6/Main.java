package test_6;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initialize variables
		Random sale = new Random();
		double topSalesP = 0, topValueC = 0;
		int topVolume = 0;
		int topCarS=0,topCarV=0,topPerson=0;
		int[][] sales = new int[4][5];
		double price[] = {10288.00, 1299.99, 18456.00, 20345.00, 45799.00};
		
		//print out table top
		System.out.println("\t\tModel 1\tModel 2\tModel 3\tModel 4\tModel 5");
		
		for(int x=0; x<4; x++) {
			
			//print out table sidebar
			System.out.print("SalesPerson" + (x+1) + "\t");
			
			//randomly fill and print sales of cars max 20
			for(int y=0; y<5; y++) {
				
				sales[x][y] = sale.nextInt(20);
				
				System.out.print(sales[x][y] + "\t");
				
			}
			//to look good
			System.out.print("\n");
			
		}
		
		//print out title
		System.out.println("\nTotal Sales and Value by SalesPerson:");
		
		//Salesperson loop
		for(int y=0; y<4; y++) {
			
			//values made for loop
			double valueSold = 0;
			int carsSold = 0;
			
			//calculate total value of all cars sold, and amount
			for(int x=0; x<5; x++) {
				
				valueSold += sales[y][x] * price[y];
				carsSold += sales[y][x];
				
			}
			
			//decide who made the most
			if(valueSold>topSalesP) {
				
				topSalesP = valueSold;
				topPerson = y+1;
			}
			
			//print out data
			System.out.println("SalesPerson " + (y+1) + "\t\t" + carsSold + " $" + valueSold);
			
		}
		
		//title for car Model
		System.out.println("\nTotal Sales by Model:");
		
		//Car Model loop
		for(int x=0; x<5; x++) {
			
			//variables
			double valueSold = 0;
			int carsSold = 0;
			
			//loop to calculate number of cars sold, and the money made from each model
			for(int y=0; y<4; y++) {
				
				valueSold += sales[y][x] * price[x];
				carsSold += sales[y][x];
			}
			
			//decisions to decide top of categories
			if(valueSold>topValueC) {
				
				topCarS = x+1;
				topValueC=valueSold;	
			}
			
			if(carsSold>topVolume) {
				
				topCarV = x+1;
				topVolume=carsSold;	
			}
			
			//Print out stuff
			System.out.println("Model: " + (x+1) + "\t\t" + carsSold + " $" + valueSold);
			
		}
		
		//print out top of all categories
		System.out.println("\nSalesman: " + topPerson + " has the highest sales of: $" + topSalesP);
		System.out.println("Model: " + topCarS + " has the highest value sales of: $" + topValueC);
		System.out.println("Model: " + topCarV + " has the highest volume of sales: " + topVolume);

	}

}
