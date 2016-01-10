package chess.Exceptions;

public class RightCheck extends RuntimeException {
	
	public RightCheck() {
		
	}
	
	public RightCheck(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	
	

}
