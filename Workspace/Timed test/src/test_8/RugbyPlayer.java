package test_8;

import java.util.ArrayList;

public class RugbyPlayer {
	
	//constructor
		public RugbyPlayer(int number, String first, String last, boolean injured, ArrayList<Integer> points) {
			
			studentNumber=number;
			firstName=first;
			lastName=last;
			injury=injured;
			
			pointsScored = points;
			
			for(int x = 0; x<pointsScored.size(); x++) {
				
				totalPoints+=pointsScored.get(x);
				
			}
			
		}
		
		//get methods
		public int getNumber() {
			
			return studentNumber;
			
		}

		public int getPointsGame(int x) {
			
			return pointsScored.get(x);
			
		}
		
		public int getTotalPoints() {
			
			return totalPoints;
			
		}
		
		//add points
		public void addPoints(int points) {
			
			pointsScored.add(points);
			
		}
		
		//set points
		public void setPoints(int points, int game) {
			
			try {
				
				pointsScored.set(game, points);
				
			}
			
			catch(RuntimeException e) {
				
			}
			
		}
		
		//more get methods
		public String getFirstName() {
			
			return firstName;
			
		}
		
		public String getLastName() {
			
			return lastName;
			
		}
		
		public boolean getInjured() {
			
			return injury;
			
		}
		
		public int getGamesPlayed(){
			
			return pointsScored.size();
			
		}
		
		//set injury state (true for injured)
		public void setInjured(boolean injured) {
			
			injury=injured;
			
		}
		
		private int studentNumber, totalPoints=0;
		private ArrayList<Integer> pointsScored = new ArrayList<Integer>();
		
		private String firstName;
		private String lastName;
		
		private boolean injury;

	}
