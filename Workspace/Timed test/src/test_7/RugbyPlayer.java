package test_7;

import java.util.ArrayList;

public class RugbyPlayer {
	
	//constructor
	public RugbyPlayer(int number, String first, String last, boolean injured, int points) {
		
		studentNumber=number;
		firstName=first;
		lastName=last;
		injury=injured;
		
		pointsScored = points;
		
	}
	
	//get methods
	public int getNumber() {
		
		return studentNumber;
		
	}

	public int getPointsGame(int x) {
		
		return pointsScored.get(x-1);
		
	}
	
	//add points
	public void addPoints(int points) {
		
		pointsScored.add(points);
		
	}
	
	//set points
	public void setPoints(int points, int game) {
		
		try {
			
			pointsScored.set(game-1, points);
			
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
	
	//set injury state (true for injured)
	public void setInjured(boolean injured) {
		
		injury=injured;
		
	}
	
	private int studentNumber;
	private ArrayList<Integer> pointsScored = new ArrayList<Integer>();
	
	private String firstName;
	private String lastName;
	
	private boolean injury;

}
