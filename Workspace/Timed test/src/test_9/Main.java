package test_9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//variables
		boolean quit = false;
		
		//object constructor
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		ArrayList<Worker> list = new ArrayList<Worker>();
		
		while(!quit) {
			
			//print out menu
			System.out.println("What would you like to do?");
			System.out.println("1. Add workers\n2. Change worked hours");
			System.out.println("3. Print out wages to be paid");
			System.out.println("4. Remove workers\n5. Quit");
			
			//try block in case of errors
			try {
				
				//switch for menu
				switch(scan.nextInt()){
						
						//Block which creates workers
						//ask for name of new worker
				case 1: System.out.println("\nWhat is the name of the person you would like to add?");
						String name = scan1.nextLine();
						
						//ask for wage
						System.out.println("\nWhat is their wage?\n($/h)");
						float wage = scan.nextFloat();
						
						//block which asks for how they're paid
						System.out.println("\nAre they paid hourly?\nY/N");
						String type = scan.next();
						
						//if its an hourly worker
						if(type.equalsIgnoreCase("Y")) {
							
							HourlyWorker a = new HourlyWorker(name, wage);
							
							list.add(a);
							
						} else {
							
							//ask for confirmation if they are a salary worker
							System.out.println("\nAre they on a salary?\nY/N");
							String type2 = scan.next();
							
							if(type2.equalsIgnoreCase("Y")) {
								
								//create salary worker, and add pay
								SalariedWorker s = new SalariedWorker(name, wage);
								s.computePay(0);
								list.add(s);
								
							} else {
								
								System.out.println("Cannot make that worker");
								
							}
							
						}
						
						break;
						
						//block for adding hours worked
				case 2:	System.out.println("\nTo all or just one?\n(one/all)");
						String all = scan.next();
						
						//to go through all workers
						if(all.equalsIgnoreCase("all")) {
							
							//add hours, and compute pay
							for(int x = 0; x<list.size(); x++) {
								
								Worker temp = list.get(x);
								
								System.out.println("\nHow many hours has " + temp.getName() + " worked?");
								temp.computePay(scan.nextInt());
								
							}
							
						} else {
							
							//to find one
							System.out.println("\nWhat is the name of the worker?");
							String nameCheck = scan1.nextLine();
							
							for(int x = 0; x<list.size(); x++) {
								
								Worker temp = list.get(x);
								
								//check name
								if(temp.getName().equalsIgnoreCase(nameCheck)) {
									
									//add hours, and compute pay
									System.out.println("\nHow many hours have they worked?");
									temp.computePay(scan.nextInt());
									break;
								}
								
							}
							
						}
						
						break;
						
						//block which prints out data
				case 3:	System.out.println("Name\tHours\tWage");
						
						float total = 0;
				
						for(int x = 0; x<list.size(); x++) {
							
							Worker temp = list.get(x);
							
							System.out.print("\n" + temp.getName()+"\t");
							
							System.out.print(temp.getHours()+"\t");
							
							System.out.print(String.format("%9.2f",temp.getPayEarned()));
							
							System.out.println();
							
							total += temp.getPayEarned();
						
						}
						
						System.out.println("\nThe company has to pay $" + String.format("%9.2f", total) + ".\n");
						break;
				
						//block which removes workers
						//asks for worker name
				case 4:	System.out.println("\nWhat is the name of the worker?");
						String nameCheck = scan1.nextLine();
						
						//search array
						for(int x = 0; x<list.size(); x++) {
					
							Worker temp = list.get(x);
							
							//check name
							if(temp.getName().equalsIgnoreCase(nameCheck)) {
								
								//remove worker
								list.remove(x);
								
								System.out.println("\nThe worker has succesfully been removed\n");
							
							}
					
						}
						
						break;
						
						//quit block
				case 5: quit = true;
						break;
				
						//default
				default:System.out.println("Thats not a selection!");
				
				}
				
			}
			
			//catch runtime error and report
			catch(RuntimeException e) {
				
				String error = scan.nextLine();
				
				System.out.println("The program cannot interpret " + error + ".\n");
				
			}
			
		}
		
		scan.close();
		scan1.close();
		
	}

}
