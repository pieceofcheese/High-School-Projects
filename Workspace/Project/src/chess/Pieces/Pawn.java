package chess.Pieces;

import java.util.Scanner;

public class Pawn implements Piece {

	
	
	@Override
	public boolean move(int startX, int startY, int endX, int endY, byte[][] board, byte[][] moved) {
		
		int side = board[startY][startX]/10;
		
		if(moved[startY][startX]==0) {
			
			if(side==1) {
				
				//if on white side (1)
				if(startX==endX&&startY-endY<=2&&startY-endY>0) {
					
					moved[startY][startX] = 1;
					
					return true;
					
				}
				
			} else {
				
				//if on black side	(2)
				if(startX==endX&&startY-endY>=-2&&startY-endY<0) {
					
					moved[startY][startX] = 1;
					
					return true;			
						
				}
				
			}
			
		}
		
		if(side==1) {
			
			//if on white side (1)
			if(startX==endX&&startY-endY==1) {
				
				moved[startY][startX] = 1;
				
				return true;
				
			}
			
		} else {
			
			//if on black side	(2)
			if(startX==endX&&startY-endY==-1) {
				
				moved[startY][startX] = 1;
				
				return true;			
					
			}
			
		}
		
		return false; 
		
	}

	@Override
	public boolean capture(int startX, int startY, int endX, int endY,
			byte[][] board, byte[][] moved) {
		
		//decide on side
		if(board[startY][startX]/10==1) {
			
			//if on White side (1)
			if(Math.abs(startX-endX)==1&&startY-endY==1) {
				
				moved[startY][startX] = 1;
				
				return true;
				
			}
			
		} else {
			
			//if on black side (2)
			if(Math.abs(startX-endX)==1&&startY-endY==-1) {
				
				moved[startY][startX] = 1;
				
				return true;
				
			}
			
		}
		
		return false;
	}

	@Override
	public void promote(int x, int y, byte[][] board, Scanner scan) {
		
		boolean chose = false;
		
		while(!chose) {
			

			//ask what to promote to
			System.out.println("What would you like to promote the pawn to?");
			System.out.println("Queen/Bishop/Knight/Rook");
			String in = scan.nextLine();
			
			//if you choose queen
			if(in.equalsIgnoreCase("Queen")||in.equalsIgnoreCase("q")) {
				
				board[y][x] = (byte) ((board[y][x]/10)*10 + 4);
				chose = true;
				
			} else {
				
				//Bishop
				if(in.equalsIgnoreCase("Bishop")||in.equalsIgnoreCase("b")) {
					
					board[y][x] = (byte) ((board[y][x]/10)*10 + 3);
					chose = true;
					
				} else {
					
					//knight (horse)
					if(in.equalsIgnoreCase("Knight")||in.equalsIgnoreCase("k")) {
						
						board[y][x] = (byte) ((board[y][x]/10)*10 + 2);
						chose = true;
						
					} else {
						
						//Rook (Castle)
						if(in.equalsIgnoreCase("Rook")||in.equalsIgnoreCase("r")) {
							
							board[y][x] = (byte) ((board[y][x]/10)*10 + 1);
							chose = true;
							
						} else {
							
							System.out.println("\nPlease use the selections\n\n");
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}

}
