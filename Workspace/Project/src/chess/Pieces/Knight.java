package chess.Pieces;

import java.util.Scanner;

public class Knight implements Piece {
	
	public Knight() {
		
	}

	@Override
	public boolean move(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		//if horse goes horizontally 2
		if(Math.abs(startX-endX)==2) {
			
			if(Math.abs(startY-endY)==1) {
				
				moved[startY][startX] = 1;
				
				return true;
				
			}
			
		} else {
			
			//if horse goes horizontally 1
			if(Math.abs(startX-endX)==1) {
				
				if(Math.abs(startY-endY)==2) {
					
					moved[startY][startX] = 1;
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
	}

	@Override
	public boolean capture(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		//if horse goes horizontally 2
		if(Math.abs(startX-endX)==2) {
					
			if(Math.abs(startY-endY)==1) {
				
				moved[startY][startX] = 1;
				
				return true;
						
			}
					
		} else {
					
			//if horse goes horizontally 1
			if(Math.abs(startX-endX)==1) {
						
				if(Math.abs(startY-endY)==2) {
					
					moved[startY][startX] = 1;
					
					return true;
							
				}
						
			}
					
		}	
		
		return false;
	}

	@Override
	public void promote(int x, int y, byte[][] board, Scanner scan) {
		// TODO Auto-generated method stub
		
	}

}
