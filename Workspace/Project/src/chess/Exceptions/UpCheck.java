package chess.Exceptions;

public class UpCheck extends RuntimeException {
	
	public UpCheck() {
		
	}
	
	public UpCheck(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	
}
