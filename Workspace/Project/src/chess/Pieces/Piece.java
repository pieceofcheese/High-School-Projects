package chess.Pieces;

import java.util.Scanner;

public interface Piece {
	
	public boolean move(int startX, int startY, int endX, int endY, byte[][] board, byte[][] moved);
	public boolean capture(int startX, int startY, int endX, int endY, byte[][] board, byte[][] moved);
	public void promote(int x, int y, byte[][] board, Scanner scan);

}
