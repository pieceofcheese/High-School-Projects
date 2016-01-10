package booking;

public class Seats {
	
	public Seats(int row, int column) {
		
		try {
			
			seats = new int[row][column];
		}
		
		catch(RuntimeException e) {
			
			throw e;
		}
	}
	
	public void book(int row, int column, boolean book) {
		
		if (book) {
			try {
				seats[row][column] = 1;
				System.out.println("The seat has been booked succesfully");
			}
			
			catch(RuntimeException e) {
				
				throw e;
			}
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
	
	private int[][] seats;

}
