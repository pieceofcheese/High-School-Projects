package chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean winner = false;
		
		ChessBoard chess = new ChessBoard();
		
		Scanner scan = new Scanner(System.in);
		
		
		
		while(!winner) {
			
			boolean white = true;
			boolean black = true;
			
			System.out.println();
			chess.danger1();
			System.out.println();
			chess.danger2();
			System.out.println();
			
			chess.printBoard();
			
			while(white) {
				
				//get which piece to move
				System.out.println("\nIt's White player's turn to move\n");
				System.out.println("What piece would you like to move?");
				
				String from = scan.nextLine();
				
				if(from.equalsIgnoreCase("castle")) {
					
					castle(1, scan, chess);
					
				} else {
					
					//get where to move piece
					System.out.println("Where would you like to move it?");
					String to = scan.nextLine();
					
					white = move(from, to, chess, 1, scan);
					
					
				}
				
			}
			
			if(chess.check()) {
				
				if(chess.checkmate()) {
					
					winner = true;	
					
					
				}
				
			}
			
			if(!winner) {
				
				System.out.println();
				chess.danger1();
				System.out.println();
				chess.danger2();
				System.out.println();
				
				chess.printBoard();
				
				while(black) {
					
					//get which piece to move
					System.out.println("\nIt's Black player's turn to move\n");
					System.out.println("What piece would you like to move?");
					
					String from = scan.nextLine();
					
					if(from.equalsIgnoreCase("castle")) {
						
						castle(2, scan, chess);
						
					}
					
					//get where to move piece
					System.out.println("Where would you like to move it?");
					String to = scan.nextLine();
					
					black = move(from, to, chess, 2, scan);
					
				}
				
			}
			
			if(chess.check()) {
				
				chess.checkmate();
				
				winner = true;	
				
			}
			
		}
		
		scan.close();
		
	}
	
	private static void castle(int side, Scanner scan, ChessBoard chess) {
		
		System.out.println("With which castle?");
		System.out.println("(left or right)");
		String castle = scan.next();
		
		chess.castle(side, castle);
		
	}

	public static boolean move(String from, String to, ChessBoard chess, int side, Scanner scan) {
		
		int start=0,end=0;
		
		try{
			
			start = ChessBoard.coordGrab(from);
			end = ChessBoard.coordGrab(to);
			if(chess.getSide(start/10, start%10)==side) {
				
				if(chess.capture(start/10, start%10, end/10, end%10, scan)) {
					
					return false;
					
					
				} else {
					
					chess.printBoard();
					
					System.out.println("\nYou can't do that move");
					
				}
				
			} else {
				
				System.out.println("That's not your piece!");
				
			}
			
		}
		
		catch(RuntimeException e) {
			
			System.out.println("MAJOR ERROR");
			
		}
		
		return true;
		
	}
	
}
