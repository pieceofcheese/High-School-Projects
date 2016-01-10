package test_11;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	static LinkedList<Actor> list;
	
	
	public static void main(String[] args) throws IOException  {

		
		//make list
		list = new LinkedList<Actor>();
		//set up scanner
		Scanner scan1 = new Scanner(new File(source));
		//set up dummy actor
		Actor act = null;
		
		//fill dummy actor
		while(scan1.hasNext()) {
			
			//decision on whether add money or new actor
			if(scan1.hasNextFloat()) {
				
				act.addRevenue(scan1.nextFloat());
				
			} else {
				String s = scan1.next() + " " + scan1.next();
				
				if(act==null) {
					act = new Actor(s);
				} else {
					
					list.add(act);
					act = new Actor(s);
					
				}
				
			}
			
		}
		
		list.add(act);
		
		//close scanner
		scan1.close();
		for(int i = 0; i<list.size(); i++) {
			
			System.out.println(list.get(i).name);
			
		}
			
		
		//set up for menu
		boolean quit = false;
		while(quit==false) {
			Scanner scan9 = new Scanner(System.in);
			//print block
			System.out.println("What would you like to do?");
			System.out.println("1. Add an actor");
			System.out.println("2. Add revenue");
			System.out.println("3. Remove an actor");
			System.out.println("4. Get the statistics for an actor");
			System.out.println("5. Print all statistics");
			System.out.println("6. Who is the best?");
			System.out.println("7. Save");
			System.out.println("Type \"Q\" to quit");
			
			
			
			
			String s = scan9.next();
			try{
				
				switch(Integer.parseInt(s)) {
				
				//adding an actor
				case 1:addAct();
				break;
				
				//adding revenue to an actor
				case 2:addRevAct();
				break;
				
				//removing an actor
				case 3:remove();
				break;
				
				//get stats 
				case 4:getAct();
				break;
				
				//get all stats
				case 5:getAll();
				break;
				
				//who is best?
				case 6:best();
				break;
			
				//save
				case 7:save();
				break;
				}
			
			}
			
			catch(RuntimeException e) {
				
				if(s.equalsIgnoreCase("q")) {
					
					quit = true;
					
				} else {
					System.out.println("Please choose from the input provided");
				}
				
			}
		}
	}
	
	public static void save() throws IOException {
		FileWriter fw = new FileWriter(source);
		PrintWriter out = new PrintWriter(fw);
		
		for(int i = 0; i<=list.size(); i++) {
			
			Actor temp = list.get(i);
			
			out.print(temp.name + " ");
			for(int x = 0; x<=temp.revenue.size(); x++) {
				
				out.print(temp.revenue.get(x) + " ");
				
			}
			
			out.println("");
			
		}
		
		out.close();
		fw.close();
	}
	
	public static void best() {
		
		System.out.println("\nIt's all an opinion so it is not calculable.\n\n");
		
	}
	
	private static void getAct() {
		//Scanner scan = new Scanner(System.in);
		System.out.println("");
		int i = checkNames();

		System.out.println("lol");
		System.out.println("Total revenue: " + list.get(i).getrevenue());
		System.out.println("Average revenue: " + list.get(i).avgRevenue());
		System.out.println("");
		//scan.close();
		
	}
	
	public static void getAll() {
		System.out.println("");
		for(int i = 0; i<=list.size(); i++) {
			System.out.println(list.get(i).name);
			System.out.println("Total revenue: " + list.get(i).getrevenue());
			System.out.println("Average revenue: " + list.get(i).avgRevenue());
			System.out.println("");
			
		}
		
	}

	public static void addAct() {
		System.out.println("");
		String s = null;
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		
		do{
			
			try{
				System.out.println("What is his name?");
				s = scan.nextLine();
				boolean exists = false;
				for(int x = 0; x<=list.size(); x++) {
					
					if(s.equals(list.get(x).name)) {
						
						System.out.println("This person already exists");
						
						exists = true;
					}
				}
				
				if(exists==false) {
					
					quit = true;
					
				}
			}	
			catch(RuntimeException e) {
					
			}
			
		} while(quit = false);
		
		
		Actor act = new Actor(s);
		
		quit = false;
		
		while(quit==false) {
			
			System.out.println("How much do you want to add? (Type \"Q\" to quit)");
			
			String ss = scan.next();
			
			try{
				
				int rev = Integer.parseInt(ss);
				act.addRevenue(rev);
				
			}
			
			catch(RuntimeException e) {
				
				if(ss.equalsIgnoreCase("q")) {
					quit = true;
				}
			}
			
		}
		
		list.add(act);
		
		//scan.close();
		
	}
	
	public static void addRevAct() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		int i = checkNames();
		System.out.println("st");
		Actor temp = list.get(i);
		boolean quit = false;
		
		while(quit==false) {
			
			System.out.println("How much do you want to add? (Type \"Q\" to quit)");
			
			String s = scan.next();
			
			try{
				
				int rev = Integer.parseInt(s);
				temp.addRevenue(rev);
				
			}
			
			catch(RuntimeException e) {
				
				if(s.equalsIgnoreCase("q")) {
					quit = true;
				}
			}
			
		}
		
		list.remove(i);
		
		list.add(temp);
		
		
	}
	
	public static int checkNames() {
		
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		int index= -1;
		while(quit==false) {
			
			System.out.println("Choose an actor from below");
			for(int x = 0; x<list.size(); x++) {
				
				System.out.println(list.get(x).name);
				
			}
			
			String s = "Jason Statham";
			
			for(int x = 0; x<list.size(); x++) {
				
				if(s.equals(list.get(x).name)) {
					
					
					index = x;
					quit = true;
					
				}
				
			}
			
			if(index==-1) {
				
				System.out.println("Please print the name exactly");
				
			}
			
		}
		
		
		return index;
		
	}
	
	public static void remove() {
		
		int i = checkNames();
		
		list.remove(i);
		
		
	}
	
	static String source = "H:\\actorData.txt";

}
