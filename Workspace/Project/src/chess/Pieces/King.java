package chess.Pieces;

import java.util.Scanner;

public class King implements Piece {
	
	public King() {
		
	}

	@Override
	public boolean move(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		//decide if the move is do able
		if(Math.abs(startX-endX)<=1&&Math.abs(startY-endY)<=1) {
			
			moved[startY][startX] = 1;
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public boolean capture(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		if(Math.abs(startX-endX)<=1&&Math.abs(startY-endY)<=1) {
			
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
