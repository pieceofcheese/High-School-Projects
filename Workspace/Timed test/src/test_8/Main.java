package test_8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int topNumber=0, lowNumber = 0;
		double topPoints=0, lowestPoints=9999999;
		String topFirst=null, topLast=null;
		String lowFirst=null, lowLast=null;

		
		boolean end = false, tie = false;
		
		ArrayList<RugbyPlayer> csTeam = new ArrayList<RugbyPlayer>();
		
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Create the team");
		
		//fill team loop
		do {
					
			int number;
			String first, last;
			boolean status;
			
			ArrayList<Integer> points = new ArrayList<Integer>();
					
			try {
						
				//get player number
				System.out.println("What is the number of the new Player?\nPress Q to quit");
				number=scan.nextInt();
						
				//get player name
				System.out.println("What is the Player's Name?\n(First Last)\nPress Q to quit");
				first = scan.next();
				last = scan.next();
						
				//get whether the player is injured
				System.out.println("What is the players Status?\n(injured or uninjured)");
				System.out.println("Press Q to quit");
						
				//decision on status
				if(scan.next().equalsIgnoreCase("injured")) {
							
					status=true;
							
				} else {
							
					status = false;
							
				}
				
				int z=1;
				boolean end2 = false;
				
				while(!end2) {
					try {
						System.out.println("How many points did the player score for game " + z + "?");
						System.out.println("Press Q to stop adding scores");
						points.add(scan.nextInt());
						z++;
					}
					
					catch(RuntimeException e) {
						
						if(scan.next().equalsIgnoreCase("q")) {
							
							end2=true;
									
						}
						
					}
					
				}
						
				//make and add to arraylist
				RugbyPlayer play = new RugbyPlayer(number, first, last, status, points);
				csTeam.add(play);
						
			}
					
			catch(RuntimeException e) {
						
				if(scan.next().equalsIgnoreCase("q")) {
							
					end=true;
							
				}
						
			}
					
		}while(!end);
		
		end = false;
		
		//loop for updating every game;
		
		System.out.println("Updating player data for a game");
		for(int x = 0; x<csTeam.size(); x++) {
			
			
			while(!end) {
				
				RugbyPlayer temp = csTeam.get(x);
				
				boolean status;
				
				//try to add points
				try{
					
					System.out.println("How many points did player number " + temp.getNumber() + " get?");
					temp.addPoints(scan.nextInt());
					
					System.out.println("Did the player get injured this game?\n(y/n)");
					//decision on status
					if(scan.next().equalsIgnoreCase("y")) {
								
						status=true;
								
					} else {
								
						status = false;
								
					}
					temp.setInjured(status);
					
					end = true;
				}
				catch(RuntimeException e) {
					
					String bug = scan1.nextLine();
					
				}
				
			}
			
			end = false;
			
		}
		
		//ask if you want to remove a player
		System.out.println("Would you like to remove a player?\n(y/n)");
		
		//if you want to remove someone
		if(scan.next().equalsIgnoreCase("y")) {
			
			System.out.println("Who would you like to remove?");
			
			while(!end) {
				
				System.out.println("(Player Number please)");
				
				try {
					
					for(int x = 0; x<csTeam.size(); x++) {
						
						RugbyPlayer temp = csTeam.get(0);
						
						if(temp.getNumber()== scan.nextInt()) {
							
							csTeam.remove(x);
							
						}
						
					}
					
					end = true;
					
				}
				
				catch(RuntimeException e) {
					
					String bug = scan1.nextLine();
					
				}
				
			}
			
			end = false;
			
		}
		
		while(!end) {
			
			System.out.println("Would you like to add a player?\n(y/n)");
			
			String in = scan.next();
			
			//if you want to remove someone
			if(in.equalsIgnoreCase("y")) {
				int number;
				String first, last;
				boolean status;
				
				ArrayList<Integer> points = new ArrayList<Integer>();
						
				try {
							
					//get player number
					System.out.println("What is the number of the new Player?");
					number=scan.nextInt();
							
					//get player name
					System.out.println("What is the Player's Name?\n(First Last)");
					first = scan.next();
					last = scan.next();
							
					//get whether the player is injured
					System.out.println("What is the players Status?\n(injured or uninjured)");
							
					//decision on status
					if(scan.next().equalsIgnoreCase("injured")) {
								
						status=true;
								
					} else {
								
						status = false;
								
					}
					
					int z=1;
					boolean end2 = false;
					
					while(!end2) {
						try {
							System.out.println("How many points did the player score for game " + z + "?");
							System.out.println("Press q to quit");
							points.add(scan.nextInt());
							z++;
						}
						
						catch(RuntimeException e) {
							
							if(scan.next().equalsIgnoreCase("q")) {
								
								end2=true;
										
							}
							
						}
						
					}
							
					//make and add to arraylist
					RugbyPlayer play = new RugbyPlayer(number, first, last, status, points);
					csTeam.add(play);
					
				}
				
				catch(RuntimeException e) {
					
					String bug = scan.nextLine();
					
				}
				
			} else {
				
				if(in.equalsIgnoreCase("n")) {
					
					end=true;
					
				}
				
			}
			
		}
		
		end = false;
		
		//check for greatest average points
		for(int x = 0; x<csTeam.size(); x++) {
			
			RugbyPlayer temp = csTeam.get(x);
			
			double averagePoints = (double) temp.getTotalPoints()/ (double) temp.getGamesPlayed();
			
			//if points is greater
			if(averagePoints>topPoints) {
				
				topPoints=averagePoints;
				topNumber=temp.getNumber();
				topFirst=temp.getFirstName();
				topLast=temp.getLastName();
				
				tie = false;
				
			//if a tie exists
			} else {
				
				if(averagePoints==topPoints) {
					
					tie = true;
					
				}
				
			}
			
		}
		
		//decide what to print
		//If it's a tie
		if(tie) {
			
			System.out.println("It's a tie");
			
		//if someone has the greatest points
		} else {
			
			System.out.println("Player " + topFirst + " " + topLast + " Number " + topNumber + " Scored the most Points!");
			System.out.println("He scored " + (int) topPoints + " points!");
			System.out.println();
			
		}
		
		//check for lowest average points
		for(int x = 0; x<csTeam.size(); x++) {
					
			RugbyPlayer temp = csTeam.get(x);
					
			double averagePoints = (double) temp.getTotalPoints()/ (double) temp.getGamesPlayed();
					
			//if points is greater
			if(averagePoints<lowestPoints) {
						
				lowestPoints=averagePoints;
				lowNumber=temp.getNumber();
				lowFirst=temp.getFirstName();
				lowLast=temp.getLastName();
						
				tie = false;
						
				//if a tie exists
			} else {
						
				if(averagePoints==lowestPoints) {
							
					tie = true;
							
				}
						
			}
					
		}
		
		//decide what to print
		//If it's a tie
		if(tie) {
					
			System.out.println("It's a tie");
					
			//if someone has the greatest points
		} else {
					
			System.out.println("Player " + lowFirst + " " + lowLast + " Number " + lowNumber + " Scored the least average Points!");
			System.out.println("He scored " + (int) lowestPoints + " points!");
			System.out.println();
					
		}
		
		System.out.println("\t\t\tScore per Game");
		
		//loop to print out uninjured
		for(int x = 0; x<csTeam.size(); x++) {
			
			RugbyPlayer temp = csTeam.get(x);
			
			System.out.print(temp.getFirstName() + " " + temp.getLastName() + "\t");
			
			for(int s = 0; s<temp.getGamesPlayed(); s++) {
				
				System.out.print(temp.getPointsGame(s) + " ");
				
			}
			
			System.out.println("");
			
		}
		
		scan.close();
		scan1.close();
				
	}
				
}
		
