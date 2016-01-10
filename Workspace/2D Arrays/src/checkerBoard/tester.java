package checkerBoard;

import java.util.Scanner;

public class tester {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		CheckerBoard check = new CheckerBoard(10, true, true);
		
		check.printBoard();
		
		check.move(2, 1, 6, 0, 5);
		
		check.printBoard();
		
		check.move(2, 0, 5, 1, 4);
		
		check.printBoard();
		
		check.capturePiece(3, 2, 2, 3, 0, 5, 1, 4);
		
		check.printBoard();
		
		check.resetBoard();
		
		check.printBoard();
		
		scan.nextInt();
		
		try {
			check.configBoard(7, false, false);
			check.printBoard();
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Board has impossible dimensions");
		}

	}

}
