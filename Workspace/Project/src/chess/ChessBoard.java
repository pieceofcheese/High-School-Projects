package chess;

import java.util.ArrayList;
import java.util.Scanner;

import chess.Pieces.Bishop;
import chess.Pieces.King;
import chess.Pieces.Knight;
import chess.Pieces.Pawn;
import chess.Pieces.Piece;
import chess.Pieces.Queen;
import chess.Pieces.Rook;

public class ChessBoard extends Board {
	
	//constructor
	public ChessBoard() {
		
		//generate chessboard
		super();
		super.board = new byte[][] { {21, 22, 23, 24, 25, 23, 22, 21}, 
									{20, 20, 20, 20, 20, 20, 20, 20},
									{0, 1, 0, 1, 0, 1, 0, 1},
									{1, 0, 1, 0, 1, 0, 1, 0},
									{0, 1, 0, 1, 0, 1, 0, 1},
									{1, 0, 1, 0, 1, 0, 1, 0},
									{10, 10, 10, 10, 10, 10, 10, 10},
									{11, 12, 13, 14, 15, 13, 12, 11} }; 
		
		//build arrays
		moved = new byte[8][8];
		
		//fill arrayList
		Pawn p = new Pawn();
		pieces.add(p);
		
		Rook r = new Rook();
		pieces.add(r);
		
		Knight k = new Knight();
		pieces.add(k);
		
		Bishop b = new Bishop();
		pieces.add(b);
		
		Queen q = new Queen();
		pieces.add(q);
		
		King K = new King();
		pieces.add(K);
		
		for(int x = 0; x<8; x++) {
			
			for(int y = 2; y<6; y++) {
				
				moved[y][x] = 1;
				
			}
			
		}
		
		//initialize class which handles checking
		check = new Check(pieces);
		
		setDangerAll();
		
		lastMovedY = -1;
		lastMovedX= -1;
		
	}
	
	//move decision
	public boolean move(int startX, int startY, int endX, int endY, Scanner scan) {
				
		int side = board[startY][startX]/10;
		int piece = board[startY][startX]%10;
		
		//check if there is a piece there
		if (side>0) {
							
			//check if the space is clear
			if(board[endY][endX]==0||board[endY][endX]==1) {
				
				//move check
				if(pieceMove(pieces.get(piece), startX, startY, endX, endY)) {
					
					
					if(tempMove(startX, startY, endX, endY, side)) {
						
						//actually move the piece
						movePieces(startX, startY, endX, endY);
						
						//if block for promotion
						if(side==1) {
							
							if(!check.checkKing(2, board)) {
								
								System.out.println("The black king is in check!");
								
							}
							
							if(endY==0) {
								
								piecePromote(pieces.get(piece), scan);
												
							} 
											
						} else {
							
							if(!check.checkKing(1, board)) {
								
								System.out.println("The white king is in check!");
								
							}
							
							if(endY==7) {
												
								piecePromote(pieces.get(piece), scan);
												
							}
											
						}
						
						return true;
						
					}
							
				}
								
			}	
					
		} else {
					
			System.out.println("There is no piece there");
					
		}
		
		return false;
				
	}
	
	//method to capture
	public boolean capture(int startX, int startY, int endX, int endY, Scanner scan) {
		
		//check if it's in array size
		if(endX<8&&endX>=0) {
			
			if(endY<8&&endY>=0) {
				
				if(startX<8&&startX>=0) {
							
					if(startY<8&&startY>=0) {
						
						int side = board[startY][startX]/10;
						int piece = board[startY][startX]%10;
						
						//for not pawns
						if(piece!=0&&side>0) {
							
							//check if there is a piece there
							if (side==2) {
										
								//check if the space has an opponent
								if(board[endY][endX]/10==1) {
											
									if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
										
										if(tempMove(startX, startY, endX, endY, side)) {
											
											movePieces(startX, startY, endX, endY);
											
											if(!check.checkKing(2, board)) {
												
												System.out.println("The black king is in check!");
												
											}
											
											return true;
											
										}
										
									}
											
								} else {
									
									return move(startX, startY, endX, endY, scan);
									
								}
								
							} else {
								
								if(side==1) {
									
									//check if the space has an opponent
									if(board[endY][endX]/10==2) {
										
										//do the movement check for the piece
										if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
											
											if(tempMove(startX, startY, endX, endY, side)) {
												
												movePieces(startX, startY, endX, endY);
												
												if(!check.checkKing(2, board)) {
													
													System.out.println("The white king is in check!");
													
												}
												
												return true;
												
											}
											
										}
												
									} else {
										
										return move(startX, startY, endX, endY, scan);
										
									}	
									
								} 
								
							}
							
						} else {
							
							//for pawns
							return enPassant(startX, startY, endX, endY, side, piece, scan);
							
						}
						
					}
						
				}
						
			}
					
		}
		
		return false;
		
	}
	
	//method to print the board in an easy to see fashion
	public void printBoard() {
		
		System.out.println("    a " + " b " + " c " + " d " + " e " + " f " + " g " + " h \n");
		
		for(int y = 0; y<board.length; y++) {
			
			System.out.print(Math.abs(y-8) + "   ");
			
			for(int x = 0; x<board[y].length; x++) {
				
				//initialize some variables
				int side = board[y][x]/10;
				int piece = board[y][x]%10;
				
				//if white piece
				if(side==1) {
					
					System.out.print("W" + numToChar(piece) + " " );
					
				} else {
					
					//if black piece
					if(side==2) {
						
						System.out.print("B" + numToChar(piece) + " " );
					
					//if empty space
					} else {
						
						System.out.print(" " + board[y][x] + " ");
						
					}
					
				}
				
			}
			
			System.out.print("   " + Math.abs(y-8));
			
			System.out.println();
			
		}
		
		System.out.println("\n    a " + " b " + " c " + " d " + " e " + " f " + " g " + " h ");
		
	}

	//unboxing to get movement method
	private boolean pieceMove(Piece x,int startX, int startY, int endX, int endY) {
		
		if(x.move(startX, startY, endX, endY, board, moved)) {
		
			return true;
			
		}
		
		return false;
		
	}

	private boolean tempMove(int startX, int startY, int endX, int endY, int side) {
		
		byte[][] tempBoard = new byte[8][8];
		
		for(int x = 0; x<8; x++) {
			
			for(int y = 0; y<8; y++) {
				
				tempBoard[y][x] = board[y][x];
				
			}
			
		}
		
		clearDangerAll();
		
		//move temp
		tempBoard[endY][endX] = tempBoard[startY][startX];
		
		//fill space
		if((startX+startY)%2!=0) {
			
			tempBoard[startY][startX] = 1;
			
		} else {
			
			tempBoard[startY][startX] = 0;
			
		}
		
		//set danger
		for(int x = 0; x<8; x++) {
			
			for(int y = 0; y<8; y++) {
				
				if(tempBoard[y][x]>1) {
					
					check.dangerSet(x,y,tempBoard);
					
				}
				
			}
			
		}
		
		//king checks
		if(check.checkKing(side, tempBoard)) {
			
			return true;
			
		} else {
			
			//reset with real board
			clearDangerAll();
			setDangerAll();
			
		}
		
		System.out.println("You cannot move there, your king will be in check");
		
		return false;
		
	}

	private void setDangerAll() {
		
		for(int x = 0; x<8; x++) {
			
			for(int y = 0; y<8; y++) {
				
				if(board[y][x]>1) {
					
					check.dangerSet(x,y,board);
					
				}
				
			}
			
		}
		
	}

	private void clearDangerAll() {
		
		for(int x = 0; x<8; x++) {
			
			for(int y = 0; y<8; y++) {
				
				if(board[y][x]>1) {
					
					check.dangerClear(x,y,board);
					
				}
				
			}
			
		}
		
	}

	//unboxing to do capture method
	private boolean pieceCapture(Piece x,int startX, int startY, int endX, int endY) {
		
		if(x.capture(startX, startY, endX, endY, board, moved)) {
			
			return true;
			
		}
		
		
		return false;
	
	}
	
	//unboxing for promotion method
	private void piecePromote(Piece x, Scanner scan) {
		
		x.promote(lastMovedX, lastMovedY, board, scan);
		
	}
	
	//method to make the capture method look nicer
	private boolean enPassant(int startX, int startY, int endX, int endY, int side, 
			int piece, Scanner scan) {
		
		//for pawns
		try {
			
			//check if en passant is do able
			if(board[lastMovedY][lastMovedX]%10==0&& Math.abs(endX-lastMovedX)==1) {
				
				if(board[endY][endX]<=1) {
					
					if(side==1) {
							
						//check if piece is in reach
						if(lastMovedY-endY==0&&lastMovedY-startY==0) {
								
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
								
								if(tempMove(startX, startY, endX, endY, side)) {
									
									emptySpace(lastMovedX, lastMovedY);
									
									movePieces(startX, startY, endX, endY);
										
									if(endY==0) {
												
										piecePromote(pieces.get(piece), scan);
												
									}
									
									if(!check.checkKing(2, board)) {
										
										System.out.println("The black king is in check!");
										
									}
									
									return true;
									
								}
									
							}
								
						}
							
					} else {
							
						//check if piece is in reach
						if(lastMovedY-endY==-1&&lastMovedY-endY<=0) {
								
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
								
								if(tempMove(startX, startY, endX, endY, side)) {
									
									emptySpace(lastMovedX, lastMovedY);
									
									movePieces(startX, startY, endX, endY);
											
									if(endY==7) {
												
										piecePromote(pieces.get(piece), scan);
												
									}
									
									if(!check.checkKing(1, board)) {
										
										System.out.println("The white king is in check!");
										
									}
									
									return true;
									
								}
								
							}
								
						}
							
					}
						
				}
				
			}
			
		}
		
		
		catch(ArrayIndexOutOfBoundsException e) {
			
			return move(startX, startY, endX, endY, scan);
			
		}
		
		return pawnCap(startX, startY, endX, endY, side, piece, scan);
			
	}
	
	private boolean pawnCap(int startX, int startY, int endX, int endY, 
			int side, int piece, Scanner scan) {
		
		if(side==1) {
			
			if(board[endY][endX]/10==2) {
				
				if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
					
					if(tempMove(startX, startY, endX, endY, side)) {
						
						movePieces(startX, startY, endX, endY);
						
						if(endY==0) {
									
							piecePromote(pieces.get(piece), scan);
									
						}
						
						if(!check.checkKing(2, board)) {
							
							System.out.println("The black king is in check!");
							
						}
						
						return true;
						
					}
						
				}
				
			} else {
				
				return move(startX, startY, endX, endY, scan);
				
			}
			
		} else {
			
			if(board[endY][endX]/10==1) {
				
				if(pieceCapture(pieces.get(piece), startX, startY, endX, endY)) {
					
					if(tempMove(startX, startY, endX, endY, side)) {

						movePieces(startX, startY, endX, endY);
							
						if(endY==7) {
									
							piecePromote(pieces.get(piece), scan);
									
						}
						
						if(!check.checkKing(1, board)) {
							
							System.out.println("The white king is in check!");
							
						}
						
						return true;
								
					}
					
				}
				
			} else {
				
				return move(startX, startY, endX, endY, scan);
				
			}
				
		}
		
		return false;
		
	}
	
	//method that changes coordinates
	private void movePieces(int startX, int startY, int endX, int endY) {
		
		//do normal movement check
		board[endY][endX] = board[startY][startX];
		moved[startY][startX] = 1;
		lastMovedX=endX;
		lastMovedY=endY;
		
		emptySpace(startX, startY);
		
	}
	
	//method which fills empty space
	private void emptySpace(int startX, int startY) {
		
		if((startX+startY)%2!=0) {
			
			board[startY][startX] = 1;
			
		} else {
			
			board[startY][startX] = 0;
			
		}
		
	}
	
	//interpreter for printing
	private String numToChar(int piece) {
		
		switch(piece) {
		
		case 0:
			
			return "P";
			
		case 1:
			
			return "R";
			
		case 2:
			
			return "N";
			
		case 3:
			
			return "B";
			
		case 4:
			
			return "Q";
			
		case 5:
			
			return "K";
			
		default:
			
			System.out.println("Something wrong has happened");
		
		}
		
		return null;
		
	}
	
	public int getSide(int x, int y) {
		
		return board[y][x]/10;
		
	}
	
	//interpreter for coordinates
	public static int coordGrab(String x) {
		
		int coordX=0, coordY=0;
		
		try {
		
			coordX = Character.toLowerCase(x.charAt(0));
			coordY = x.charAt(1);
			
		}
		
		catch(IllegalArgumentException e) {
			
			return -1;
			
		}
		
		coordY = coordY-49;
		coordX = coordX-97;
		coordY = Math.abs(7-coordY);
		
		int coord = coordX*10 + coordY;
		
		
		return coord;
		
	}
	
	public boolean check() {
		
		return false;
	}

	public boolean checkmate() {
		
		return false;
	}
	
	public void setPiece(int startX, int startY, int endX, int endY) {
		
		clearDangerAll();
		
		movePieces(startX, startY, endX, endY);
		
		setDangerAll();
		
	}

	public void danger1() {
		
		check.printDanger1();
		
	}
	
	public void danger2() {
		
		check.printDanger2();
		
	}
	
	public void castle(int side, String castle) {
		
		//check side
		if(side==1) {
			
			//check if king hasn't moved
			if(moved[7][4]==0) {
				
				//choose which castle
				if (castle.equalsIgnoreCase("Left")) {
					
					//check if castle hasn't moved
					if(moved[7][0]==0) {
						
						boolean check = true;
						
						//check if empty between
						for(int x=1; x<4; x++) {
							
							if(board[7][x]>1){
								
								check = false;
								
							}
							
						}
						
						//actual move
						if(check) {
							
							clearDangerAll();
							
							movePieces(4, 7, 2, 7);
							
							movePieces(0, 7, 3, 7);
							
							setDangerAll();
							
							if(check.checkKing(1,board)) {
								
								if(check.checkKing(2, board)!) {
									
									System.out.println("The black king is in check");
									
								}
								
								
							} else {
								
								movePieces(2, 7, 4, 7);
								movePieces(3, 7, 0, 7);
								
							}
							
						}
						
					}
					
				} else {
					
					if(castle.equalsIgnoreCase("right")) {
						
						if(moved[7][7]==0) {
							
							boolean check = true;
							
							//check if empty between
							for(int x=6; x>4; x--) {
								
								if(board[0][x]>1){
									
									check = false;
									
								}
								
							}
							
							//actual move
							if(check) {
								
								clearDangerAll();
								
								movePieces(4, 7, 6, 7);
								
								movePieces(7, 7, 5, 7);
								
								setDangerAll();
								
								if(check.checkKing(1,board)) {
									
									if(check.checkKing(2, board)!) {
										
										System.out.println("The black king is in check");
										
									}
									
								} else {
									
									movePieces(6, 7, 4, 7);
									movePieces(5, 7, 7, 7);
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		} else {
			
			
			
		}
		
	}
	
	//extra variables
	private Check check;
	private byte[][] moved;
	private ArrayList<Piece> pieces =new ArrayList<Piece>();
	private int lastMovedX, lastMovedY;
	
}
