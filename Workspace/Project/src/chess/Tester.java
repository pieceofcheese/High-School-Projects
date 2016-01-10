package chess;

import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ChessBoard chess = new ChessBoard();
		
		System.out.println();
		chess.danger1();
		System.out.println();
		chess.danger2();
		System.out.println();
		
		set("a2", "a7", chess);
		
		move("a7", "b8", chess, scan);
		
		chess.printBoard();
		
		chess.danger1();
		System.out.println();
		chess.danger2();
	}
	
	public static void set(String from, String to, ChessBoard chess) {
		
		int start=0,end=0;
		
		try{
			
			start = ChessBoard.coordGrab(from);
			end = ChessBoard.coordGrab(to);
			
			chess.setPiece(start/10, start%10, end/10, end%10); 
		}
		
		catch(RuntimeException e) {
			
			
			
		}
		
	}
	
	public static void move(String from, String to, ChessBoard chess, Scanner scan) {
		
		int start=0,end=0;
		
		try{
			
			start = ChessBoard.coordGrab(from);
			end = ChessBoard.coordGrab(to);
			
			if(chess.capture(start/10, start%10, end/10, end%10, scan)) {
				
			} else {
				
				chess.printBoard();
				
				System.out.println("\nYou can't do that move");
				
			}
			
		}
		
		catch(RuntimeException e) {
			
			
			
		}
		
	}
	
}
