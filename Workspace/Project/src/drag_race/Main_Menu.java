package drag_race;

import java.util.Scanner;

public class Main_Menu {
	
	public static void main(String[] args) {
		
		//Variable initializations, and declarations
		String quitMain = "null";
		
		//Scanner construction
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		//Generate the race object based on the number of cars
		System.out.println("How many cars do you want to race?");
		Race race = new Race(scan.nextInt());
		
		//Main menu do loop
		do {
			
			//Print out the options
			System.out.println("1. Start the race\n2. Configure vehicles\n3. Modify race settings\n4. Quit");
			
			//Take the input and decide on what to do
			switch(scan.nextInt()) {
			
			//Run the race
			case 1:	race.race();
					break;
			
			//Modify car loop
			case 2: boolean carQuit = false;
					do {
						
						//initialize a new variable
						int car;
						
						//ask which car
						System.out.println("For which car?");
						car = scan.nextInt();
						
						if((car)>race.getNumberOfCars()||car<=0) {
							
							System.out.println("Choose an existing car");
						} else {
						
							//do loop for modify car menu
							do {
								//print out options
								System.out.println("What would you like to change?");
								System.out.println("1. Name\n2. Torque\n3. Mass\n4. Quit");
					
								switch(scan.nextInt()) {
						
							
								case 1:	//Change the name of the car
									System.out.println("What would you like to call car # " + (car) + "?");
								
									String carName = scan1.nextLine();
								
									race.setName((car), carName);
									
									break;
						
								case 2: //Change the horsepower of the car
									System.out.println("How much torque does car " + race.getName(car) + " have?");
									
									double carTorque = scan.nextDouble();
						
									race.setTorque(car, carTorque);
									
									System.out.println("At what RPM?");
									
									double carRPM = scan.nextDouble();
									
									race .setRPM(car, carRPM);
									
									break;
						
									
								case 3: //Change the mass of the car
									System.out.println("How much does " + race.getName(car) + " weigh in pounds?");
									
									double carMass = scan.nextDouble();
						
									race.setMass(car, carMass);
									
									break;
								
								case 4: //quit car modification
									carQuit = true;
									break;
								
								default: System.out.println("Please choose from the list of options.");
								} 
							}while(carQuit!=true);
						}
						
					} while(carQuit!=true);
					break;
			
			case 3:	//modify track settings
					
					System.out.println("What do you want to change?\n1. Track length\n2. Number of cars");
					
					switch(scan.nextInt()) {
					
					case 1: //Change the length of track
							System.out.println("How many miles do you want the cars to race for?");
					
							race.setDistanceM(scan.nextDouble());
				
							break;
								
					case 2: //change the number of cars being raced
							System.out.println("How many cars do you want to race?");
					
							race.setNumberOfCars(scan.nextInt());
				
							break;
					}
					
					break;
					
			case 4: //quit program
					quitMain = "q";
					break;
				
			default:break;
			}
			
		} while(!quitMain.equalsIgnoreCase("q"));
		scan.close();
		scan1.close();
	}

}
