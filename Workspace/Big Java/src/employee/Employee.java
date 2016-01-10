package employee;

public class Employee {
	
	// Constructor Methods
	
	//Default Constructor
	public Employee() {
		
		name = "";
		
		salary = 0;
	}
	
	//Double argument constructor
	public Employee(String n, double s) {
		
		name = n;
		salary = s;
	}
	
	// Methods
	
	//Set the Employee's name method
	public void setName(String n) {
		
		name = n;
	}
	
	//Set the Employee's salary method
	public void setSalary(double s) {
		
		salary = s;
	}
	
	//Getting the name method
	public String getName() {
		
		return name;
	}
	
	//Getting the salary method
	public double getSalary() {
		
		return salary;
	}
	
	//Static variable
	
	private String name;
	
	private double salary;

}
