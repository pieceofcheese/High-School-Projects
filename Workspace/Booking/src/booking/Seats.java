package booking;

public class Seats {
	
	public Seats (int rows, int columns) {
		
		try {
			
			seats = new int[rows][columns];
		}
		
		catch(RuntimeException e) {
			
			throw e;
			
		}
		
	}
	
	public void book(int row, int column) {
		
		try {
			
		if(seats[seats.length-row][column-1] != 1) {
			
			seats[seats.length-row][column-1] = 1;
			System.out.println("The seat " + row + "," + column + " has been succesfully booked");
			
		} else {
			
			System.out.println("The seat has already been booked");
		
		    }
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("That seat doesn't exist");
			
			throw e;
		}
	}
	
	public void printSeats() {
			
		for(int row = 0; row<seats.length; row++) {
				
			for(int c = 0; c<seats[row].length; c++) {
					
				System.out.print(seats[row][c]);
			}
				
			System.out.println();
		}
		
	}
	
	public int[][] seats;

}
