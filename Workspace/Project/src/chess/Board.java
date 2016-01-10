package chess;

public class Board {
	
	public Board() {
		
	}
	
	public Board(int size, boolean blackRight) {
		
		if(size>0) {
			
			int[][] board = new int[size][size];
			
			if(blackRight) {
				
				for(int y=0; y<board.length; y++) {
					
					for(int x=0; x<board[y].length; x++) {
						
						if((x+y)%2==0) {
							
							board[y][x] = 1;
							
						}
						
					}
					
				}
				
			} else {
				
				for(int y=0; y<board.length; y++) {
					
					for(int x=0; x<board[y].length; x++) {
						
						if((x+y)%2!=0) {
							
							board[y][x] = 1;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		
	}
	
	public int getValue(int x, int y) {
		
		return board[y][x];
		
	}
	
	public void printBoard() {
		
		for(int y = 0; y<board.length; y++) {
			
			for(int x = 0; x<board[y].length; x++) {
				
				System.out.print(board[y][x]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	protected byte[][] board;

}
