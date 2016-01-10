package chess.Exceptions;

public class Quad1Check extends RuntimeException {
	
	public Quad1Check() {
		
	}
	
	public Quad1Check(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	

}
