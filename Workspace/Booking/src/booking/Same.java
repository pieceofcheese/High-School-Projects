package booking;

import java.util.Scanner;

public class Same {

	public static void main(String[] args) {
		
		//initiate variables
		int rows = 0,columns = 0;
		boolean a = true, b = true;
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		
		//loop for number of rows
		while(a) {
			
			System.out.println("How many rows are there?");
			
			//try block
			try {
				rows = scan.nextInt();
				if (rows>0) {
					//to end the loop
					a = false;
				} else {
					System.out.println("Please choose a positive integer");
				}
			}
			
			//if the input isn't an integer
			catch(RuntimeException e) {
				String err = scan.nextLine();
				System.out.println("Please enter an integer.");
			}
		}
		
		//loop for number of columns
		while(b) {
			
			System.out.println("How many columns are there?");
			
			//try block
			try {
				columns = scan.nextInt();
				
				if (columns>0) {
					//to end the loop
					b = false;
				} else {
					System.out.println("Please choose a positive integer");
				}
				
			}
			
			//if the input isn't an integer
			catch(RuntimeException e) {
				String err = scan.nextLine();
				System.out.println("Please enter an integer.");
			}
		}
		
		//build seats for booking
		Seats seat = new Seats(rows, columns);
		
		//menu loop
		while(run) {
			
			int input = 0;
			
			//ask what to do
			System.out.println("What would you like to do?");
			System.out.println("1. Book\n2. See booked seats\n3. Quit");
				
			try {
				
				input = scan.nextInt();
			}
			
			catch(RuntimeException e) {
				String err = scan.nextLine();
			}
			if(input==1) {
				//book a seat
				boolean r = true;
				int row, column;
					
				//loop for menu
				while(r) {	
							
					try{
						
						//ask for row to be booked
						System.out.println("What row would you like to book?");
						System.out.println("type q if you would like to stop");
						
						row = scan.nextInt();
						
						//check if the program should quit
						if (row>0) {
							
							//ask for column to be booked
							System.out.println("What column would you like to book?");
							System.out.println("type q if you would like to stop");
								
							column = scan.nextInt();
							
							//check if program should quit
							if (column>0) {
								
								//book seat
								seat.book(row, column);
							}
						}
						
					}
					
					//to catch an array out of bound error
					catch(RuntimeException e) {
						
						String err = scan.nextLine();
						//end loop
						r = false;
					}
							
				}
				
			//print out the seats
			} else {
				if(input==2) {
						
					//print seats
					seat.printSeats();
				
				//end menu loop
				} else {
					if(input==3) {
						
						run = false;
						
					//ask for a proper selection
					} else {
						System.out.println("Please choose from one of the selections");
						
					}
				}
			}
		}
		scan.close();
	}
}