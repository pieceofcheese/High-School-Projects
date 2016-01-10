package chess.Exceptions;

public class Quad4Check extends RuntimeException {
	
	public Quad4Check() {
		
	}
	
	public Quad4Check(int pieceX, int pieceY) {
		
		x = pieceX;
		y = pieceY;
		
		
	}
	
	public int x=0;
	public int y=0;
	

}
