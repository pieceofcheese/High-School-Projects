package chess.Exceptions;

public class Quad2Check extends RuntimeException {
	
	public Quad2Check() {
		
	}
	
	public Quad2Check(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	

}
