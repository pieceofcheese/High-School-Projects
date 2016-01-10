package chess.Exceptions;

public class DownCheck extends RuntimeException {
	
	public DownCheck() {
		
	}
	
	public DownCheck(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	
	
}
