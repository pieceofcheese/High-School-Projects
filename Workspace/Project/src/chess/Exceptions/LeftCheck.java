package chess.Exceptions;

public class LeftCheck extends RuntimeException{
	
	public LeftCheck() {
		
	}
	
	public LeftCheck(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;

}
