package chess.Pieces;

import java.util.Scanner;

public class Rook implements Piece {
	
	public Rook() {
		
	}

	@Override
	public boolean move(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		boolean check = true;
		
		//if moving vertically
		if(startX-endX==0) {
			
			//if moving up
			if(startY>endY) {
				
				for(int y = startY-1; y>=endY; y--) {
					
					if(board[y][endX]==0||board[y][endX]==1) {
						
					} else {
						

						System.out.println("A piece is in the way");
						check = false;
						
					}
					
				}
				
			} else {
				
				//if moving down
				if(startY<endY) {
					
					for(int y = startY+1; y<=endY; y++) {
						
						if(!(board[y][endX]==0||board[y][endX]==1)) {
							
							System.out.println("A piece is in the way");
							check = false;
							
						}
					
					}
					
				}
				
			}
			
		} else {
			
			//if moving horizontally
			if(startY-endY==0) {
				
				//if moving left
				if(startX-endX>0) {
					
					for(int x = startX-1; x>=endX; x--) {
						
						if(!(board[startY][x]==0||board[startY][x]==1)) {
							
							System.out.println("A piece is in the way");
							check = false;
							
						}
					
					}
					
				} else {
					
					//if moving right
					if(startX-endX<0) {
						
						for(int x = startX+1; x<=endX; x++) {
							
							if(!(board[startY][x]==0||board[startY][x]==1)) {
								
								System.out.println("A piece is in the way");
								check = false;
								
							}
						
						}
						
					}
					
				}
				
			} else {
				
				check = false;
				
			}
			
		} 
		
		if(Math.abs(startX-endX)==Math.abs(startY-endY)) {
			
			check = false;
			
		}
		
		if(check) {
			
			moved[startY][startX] = 1;
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public boolean capture(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		boolean check = true;
		
		//if moving vertically
		if(startX-endX==0) {
			
			//if moving up
			if(startY-endY>0) {
				
				for(int y = startY-1; y>endY; y--) {
					
					if(!(board[y][endX]==0||board[y][endX]==1)) {
						
						System.out.println("A piece is in the way");
						check = false;
						
					}
					
				}
				
			} else {
				
				//if moving down
				if(startY-endY<0) {
					
					for(int y = startY+1; y<endY; y++) {
						
						if(!(board[y][endX]==0||board[y][endX]==1)) {
							
							System.out.println("A piece is in the way");
							check = false;
							
						}
					
					}
					
				}
				
			}
			
		} else {
			
			//if moving horizontally
			if(startY-endY==0) {
				
				//if moving left
				if(startX-endX>0) {
					
					for(int x = startX-1; x>endX; x--) {
						
						if(!(board[startY][x]==0||board[startY][x]==1)) {
							
							System.out.println("A piece is in the way");
							check = false;
							
						}
					
					}
					
				} else {
					
					//if moving right
					if(startX-endX<0) {
						
						for(int x = startX+1; x<endX; x++) {
							
							if(!(board[startY][x]==0||board[startY][x]==1)) {
								
								System.out.println("A piece is in the way");
								check = false;
								
							}
						
						}
						
					}
					
				}
				
			} else {
				
				check = false;
				
			}
			
		}
		
		if(Math.abs(startX-endX)==Math.abs(startY-endY)) {
			
			check = false;
			
		}
		
		if(check) {
			
			moved[startY][startX] = 1;
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public void promote(int x, int y, byte[][] board, Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	
	

}
