package chess.Pieces;

import java.util.Scanner;

public class Bishop implements Piece {
	
	public Bishop() {
		
	}

	@Override
	public boolean move(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		boolean check = true;
		 
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
			
			check=false;
			
		}
		
		if(startX-endX==0||startY-endY==0) {
			
			check=false;
			
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
			
			check = false;
			
		}
		
		if(startX-endX==0||startY-endY==0) {
			
			check=false;
			
		}

		if(check) {
			
			moved[startY][startX] = 1;
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public void promote(int x, int y, byte[][] board, Scanner Scan) {
		// TODO Auto-generated method stub
		
	}

}
