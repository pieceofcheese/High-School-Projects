package chess.Pieces;

import java.util.Scanner;

public class Queen implements Piece {
	
	public Queen() {
		
	}

	@Override
	public boolean move(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		boolean check = true;
		 
		//check if end position is diagonal
		if(Math.abs(startX-endX)==Math.abs(startY-endY)) {
			
			//quadrant 4 if piece is center
			if(startX-endX<0&&startY-endY<0) {
				
				int y = startY+1;
				
				for(int x = startX+1; x<=endX; x++) {
						
					if(!(board[y][x]==0||board[y][x]==1)) {
							
						check = false;
							
					}
					
					y++;
						
				}
				
			} else {
				
				//quadrant 3
				if(startX-endX>0&&startY-endY<0) {
					
					int y = startY+1;
					
					for(int x = startX-1; x>=endX; x--) {
							
						if(!(board[y][x]==0||board[y][x]==1)) {
								
							check = false;
								
						}
						
						y++;
						
					}
					
				} else {
					
					//quadrant 2
					if(startX-endX>0&&startY-endY>0) {

						int y = startY-1;
						
						for(int x = startX-1; x>=endX; x--) {
								
							if(!(board[y][x]==0||board[y][x]==1)) {
									
								check = false;
									
							}
							
							y--;
								
						}
					
					} else {
						
						//quadrant 1
						if(startX-endX<0&&startY-endY>0) {
							
							int y = startY-1;
							
							for(int x = startX+1; x<=endX; x++) {
									
								if(!(board[y][x]==0||board[y][x]==1)) {
										
									check = false;
										
								}
									
								y--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
		} else {
			
			//if moving vertically
			if(startX-endX==0) {
				
				//if moving up
				if(startY-endY>0) {
					
					for(int y = startY-1; y>=endY; y--) {
						
						if(!(board[y][endX]==0||board[y][endX]==1)) {
							
							check = false;
							
						}
						
					}
					
				} else {
					
					//if moving down
					if(startY-endY<0) {
						
						for(int y = startY+1; y<=endY; y++) {
							
							if(!(board[y][endX]==0||board[y][endX]==1)) {
								
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
								
								check = false;
								
							}
						
						}
						
					} else {
						
						//if moving right
						if(startX-endX<0) {
							
							for(int x = startX+1; x<=endX; x++) {
								
								if(!(board[startY][x]==0||board[startY][x]==1)) {
									
									check = false;
									
								}
							
							}
							
						}
						
					}
					
				} else {
					
					check = false;
					
				}
				
			}
			
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
		 
		//check if end position is diagonal
		if(Math.abs(startX-endX)==Math.abs(startY-endY)) {
			
			//quadrant 4 if piece is center
			if(startX-endX<0&&startY-endY<0) {
				
				int y = startY+1;
				
				for(int x = startX+1; x<endX; x++) {
						
					if(!(board[y][x]==0||board[y][x]==1)) {
							
						check = false;
							
					}
					
					y++;
						
				}
				
			} else {
				
				//quadrant 3
				if(startX-endX>0&&startY-endY<0) {
					
					int y = startY+1;
					
					for(int x = startX-1; x>endX; x--) {
							
						if(!(board[y][x]==0||board[y][x]==1)) {
								
							check = false;
								
						}
						
						y++;
						
					}
					
				} else {
					
					//quadrant 2
					if(startX-endX>0&&startY-endY>0) {

						int y = startY-1;
						
						for(int x = startX-1; x>endX; x--) {
								
							if(!(board[y][x]==0||board[y][x]==1)) {
									
								check = false;
									
							}
							
							y--;
								
						}
					
					} else {
						
						//quadrant 1
						if(startX-endX<0&&startY-endY>0) {
							
							int y = startY-1;
							
							for(int x = startX+1; x<endX; x++) {
									
								if(!(board[y][x]==0||board[y][x]==1)) {
										
									check = false;
										
								}
									
								y--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
		} else {
			
			//if moving vertically
			if(startX-endX==0) {
				
				//if moving up
				if(startY-endY>0) {
					
					for(int y = startY-1; y>endY; y--) {
						
						if(!(board[y][endX]==0||board[y][endX]==1)) {
							
							check = false;
							
						}
						
					}
					
				} else {
					
					//if moving down
					if(startY-endY<0) {
						
						for(int y = startY+1; y<endY; y++) {
							
							if(!(board[y][endX]==0||board[y][endX]==1)) {
								
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
								
								check = false;
								
							}
						
						}
						
					} else {
						
						//if moving right
						if(startX-endX<0) {
							
							for(int x = startX+1; x<endX; x++) {
								
								if(!(board[startY][x]==0||board[startY][x]==1)) {
									
									check = false;
									
								}
							
							}
							
						}
						
					}
					
				} else {
					
					check = false;
					
				}
				
			}
			
		}
		
		if(check) {
			
			moved[startY][startX] = 1;
			
			return true;
			
		}
		
		return false;
	}
	@Override
	public void promote(int x, int y, byte[][] board, Scanner scan) {
		
	}
	
}
