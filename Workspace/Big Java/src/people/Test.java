package people;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		//create bob and dave
		Student bob = new Student(1997, "Bob", "Computer Science");
		Instructor dave = new Instructor(1976, "Dave", 5000);
		
		//print bob's info
		System.out.println(bob.getBirth());
		System.out.println(bob.getName());
		System.out.println(bob.getMajor());
		
		//print dave's info
		System.out.println(dave.getBirth());
		System.out.println(dave.getName());
		System.out.println(dave.getSalary());
		
		//change bob
		bob.setBirth(1987);
		bob.setMajor("Medicine");
		bob.setName("Sam");
		
		//change dave
		dave.setBirth(1959);
		dave.setName("Hal");
		dave.setSalary(10000);
		
		//print bob's info
		System.out.println(bob.getBirth());
		System.out.println(bob.getName());
		System.out.println(bob.getMajor());
		
		//print dave's info
		System.out.println(dave.getBirth());
		System.out.println(dave.getName());
		System.out.println(dave.getSalary());

	}

}
