package chess.Exceptions;

public class Quad3Check extends RuntimeException {
	
	public Quad3Check() {
		
	}
	
	public Quad3Check(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	

}
