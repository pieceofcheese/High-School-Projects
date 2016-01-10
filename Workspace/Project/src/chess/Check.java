package chess;

import java.util.ArrayList;

import chess.Pieces.Piece;

public class Check {
	
	public Check(ArrayList<Piece> x) {
		
		pieces = x;
		
		danger1 = new byte[8][8];
		danger2 = new byte[8][8];
		moved = new byte[8][8];
		
	}
	
	public void dangerSet(int x, int y, byte[][] board) {
		
		int piece = board[y][x]%10;
		int side = board[y][x]/10;
		
		checkUp(x, y, board, piece, side, x, y-1, true);
		checkDown(x, y, board, piece, side, x, y+1, true);
		checkLeft(x, y, board, piece, side, x-1, y, true);
		checkRight(x,y, board, piece, side, x+1, y, true);
		checkQuad1(x, y, board, piece, side, x+1, y-1, true);
		checkQuad2(x, y, board, piece, side, x-1, y-1, true);
		checkQuad3(x, y, board, piece, side, x-1, y+1, true);
		checkQuad4(x, y, board, piece, side, x+1, y+1, true);
		checkKnight(x,y, board, piece, side, true);
	}
	
	public void dangerClear(int x, int y, byte[][] board) {
		
		int piece = board[y][x]%10;
		int side = board[y][x]/10;
		
		checkUp(x, y, board, piece, side, x, y-1, false);
		checkDown(x, y, board, piece, side, x, y+1, false);
		checkLeft(x, y, board, piece, side, x-1, y, false);
		checkRight(x,y, board, piece, side, x+1, y, false);
		checkQuad1(x, y, board, piece, side, x+1, y-1, false);
		checkQuad2(x, y, board, piece, side, x-1, y-1, false);
		checkQuad3(x, y, board, piece, side, x-1, y+1, false);
		checkQuad4(x, y, board, piece, side, x+1, y+1, false);
		checkKnight(x,y, board, piece, side, false);
		
	}

	public boolean checkKing(int side, byte[][] board) {
		
		//check side
		if(side==1) {
			
			//find king
			int kingY=0;
			int kingX=0;
			
			for(int x = 0; x<8; x++) {
				
				for(int y = 0; y<8; y++){
					
					if(board[y][x]/10==1&&board[y][x]%10==5) {
						
						kingY = y;
						kingX = x;
						
					}
					
				}
				
			}
			
			//if king is safe
			if(danger1[kingY][kingX]==0) {

				return true;
				
			}
			
		} else {
			
			int kingY=0;
			int kingX=0;
			
			for(int x = 0; x<8; x++) {
				
				for(int y = 0; y<8; y++){
					
					if(board[y][x]/10==2&&board[y][x]%10==5) {
						
						kingY = y;
						kingX = x;
						
					}
					
				}
				
			}
			
			if(danger2[kingY][kingX]==0) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public void printDanger1() {
		
		for(int y = 0;y<8; y++) {
			
			for(int x = 0; x<8; x++) {
				
				System.out.print(danger1[y][x]);
				
			}
			System.out.println();
			
		}
		
	}
	
	public void printDanger2() {
		
		for(int y = 0;y<8; y++) {
			
			for(int x = 0; x<8; x++) {
				
				System.out.print(danger2[y][x]);
				
			}
			System.out.println();
			
		}
		
	}

	private void checkUp(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		//add to possible attackers
		if(add) {
			
			//try block in case of array out of bounds
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					//if empty space
					if(board[endY][endX]<=1) {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							//do again
							checkUp(startX, startY, board, piece, side, endX, endY-1, true);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						//if it's empty space
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								//start from top
								checkUp(startX, startY, board, piece, side, endX, endY-1, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		//Remove possible attackers	
		} else {
			//try block in case of array out of bounds
			try {
				//add to array which lists danger for the black side
				if(side==1) {
					
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							//loop again
							checkUp(startX, startY, board, piece, side, endX, endY-1, false);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					//add to array which lists danger for white side
					if(side==2) {
						
						//if it's empty space
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								//loop again
								checkUp(startX, startY, board, piece, side, endX, endY-1, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}
	
	private void checkDown(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		
		if(add) {
			//add to possible attackers
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkDown(startX, startY, board, piece, side, endX, endY+1, true);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkDown(startX, startY, board, piece, side, endX, endY+1, true);
								
							}
							
						}  else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
						
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
		
		// for clearing danger
		} else {
			
			try {
				
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkDown(startX, startY, board, piece, side, endX, endY+1, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkDown(startX, startY, board, piece, side, endX, endY+1, false);
								
							}
							
						}  else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}

	private void checkLeft(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		
		if(add) {
			//add to possible attackers
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkLeft(startX, startY, board, piece, side, endX-1, endY, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkLeft(startX, startY, board, piece, side, endX-1, endY, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
			}
			
		} else {
			
			try {
				
				if(side==1) {
					
					if(board[endY][endX]<=1||board[endY][endX]/10==2) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkLeft(startX, startY, board, piece, side, endX-1, endY, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkLeft(startX, startY, board, piece, side, endX-1, endY, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}
	
	private void checkRight(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		
		if(add) {
			//add to possible attackers
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkRight(startX, startY, board, piece, side, endX+1, endY, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkRight(startX, startY, board, piece, side, endX+1, endY, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		} else {
			
			try {
				
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkRight(startX, startY, board, piece, side, endX+1, endY, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkRight(startX, startY, board, piece, side, endX+1, endY, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}
	
	private void checkQuad1(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		//add to possible attackers
		if(add) {
			
			//try block in case of array out of bounds
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkQuad1(startX, startY, board, piece, side, endX+1, endY-1, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkQuad1(startX, startY, board, piece, side, endX+1, endY-1, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		//Remove possible attackers	
		} else {
			//try block in case of array out of bounds
			try {
				
				if(side==1) {
					
					//add to array which lists danger for the black side
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkQuad1(startX, startY, board, piece, side, endX+1, endY-1, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkQuad1(startX, startY, board, piece, side, endX+1, endY-1, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}

	private void checkQuad2(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		//add to possible attackers
		if(add) {
			
			//try block in case of array out of bounds
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkQuad2(startX, startY, board, piece, side, endX-1, endY-1, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkQuad2(startX, startY, board, piece, side, endX-1, endY-1, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		//Remove possible attackers	
		} else {
			//try block in case of array out of bounds
			try {
				
				if(side==1) {
					
					//add to array which lists danger for the black side
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkQuad2(startX, startY, board, piece, side, endX-1, endY-1, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkQuad2(startX, startY, board, piece, side, endX-1, endY-1, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}

	private void checkQuad3(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		//add to possible attackers
		if(add) {
			
			//try block in case of array out of bounds
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkQuad3(startX, startY, board, piece, side, endX-1, endY+1, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkQuad3(startX, startY, board, piece, side, endX-1, endY+1, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		//Remove possible attackers	
		} else {
			//try block in case of array out of bounds
			try {
				
				if(side==1) {
					
					//add to array which lists danger for the black side
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkQuad3(startX, startY, board, piece, side, endX-1, endY+1, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkQuad3(startX, startY, board, piece, side, endX-1, endY+1, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}

	private void checkQuad4(int startX, int startY, byte[][] board, int piece,
			int side, int endX, int endY, boolean add) {
		//add to possible attackers
		if(add) {
			
			//try block in case of array out of bounds
			try {
				
				//add to array which lists danger for the black side
				if(side==1) {
					
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]++;
							
							checkQuad4(startX, startY, board, piece, side, endX+1, endY+1, true);
							
						}
						
					} else {

						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]++;
							
						}
						
					}
					
				} else {
					
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]++;
								
								checkQuad4(startX, startY, board, piece, side, endX+1, endY+1, true);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]++;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		//Remove possible attackers	
		} else {
			//try block in case of array out of bounds
			try {
				
				if(side==1) {
					
					//add to array which lists danger for the black side
					if(board[endY][endX]<=1) {
						
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
							
							danger2[endY][endX]--;
							
							checkQuad4(startX, startY, board, piece, side, endX+1, endY+1, false);
							
						}
						
					} else {
						
						//check with move set
						if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

							danger2[endY][endX]--;
							
						}
						
					}
					
				} else {
					//add to array which lists danger for white side
					if(side==2) {
						
						if(board[endY][endX]<=1) {
							
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {
								
								danger1[endY][endX]--;
								
								checkQuad4(startX, startY, board, piece, side, endX+1, endY+1, false);
								
							}
							
						} else {
							
							//check with move set
							if(pieceCapture(pieces.get(piece), startX, startY, endX, endY, board)) {

								danger1[endY][endX]--;
								
							}
							
						}
						
					}
					
				}
				
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				
				
				
			}
			
		}
		
	}
	
	private void checkKnight(int x, int y, byte[][] board, int piece,
			int side, boolean add) {
		
		//make sure piece is a knight
		if(piece == 2) {
			
			//to add to danger
			if(add) {
				
				if(side == 1) {
					
					//whole bunch of try/catchs in case of array out of bounds
					try{
						
						danger2[y+1][x+2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-1][x+2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+1][x-2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-1][x-2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+2][x+1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-2][x+1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+2][x-1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-2][x-1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
				} else {
					
					//whole bunch of try/catchs in case of array out of bounds
					try{
						
						danger1[y+1][x+2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-1][x+2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+1][x-2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-1][x-2]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+2][x+1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-2][x+1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+2][x-1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-2][x-1]++;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
				}
				
			} else {
				
				if(side == 1) {
					
					//whole bunch of try/catchs in case of array out of bounds
					try{
						
						danger2[y+1][x+2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-1][x+2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+1][x-2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-1][x-2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+2][x+1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-2][x+1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y+2][x-1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger2[y-2][x-1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
				} else {
					
					//whole bunch of try/catchs in case of array out of bounds
					try{
						
						danger1[y+1][x+2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-1][x+2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+1][x-2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-1][x-2]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+2][x+1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-2][x+1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y+2][x-1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
					try{
						
						danger1[y-2][x-1]--;
						
					}
					
					catch(RuntimeException e) {
						
					}
					
				}
				
			}
			
		}
		
	}
	
	//unboxing to do capture method
	private boolean pieceCapture(Piece x,int startX, int startY, int endX,
			int endY, byte[][]board) {
			
		if(x.capture(startX, startY, endX, endY, board, moved)) {
				
			return true;
				
		}
			
			
		return false;
		
	}
	
	private ArrayList<Piece> pieces;
	
	private byte[][] moved;
	private byte[][] danger1;
	private byte[][] danger2;
	
}
