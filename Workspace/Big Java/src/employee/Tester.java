package employee;

public class Tester {
	
	public static void main(String[] args) {
		
		Employee p1 = new Employee();
		Employee p2 = new Employee("Bob", 5000);
		
		p1.setName("Joseph");
		p1.setSalary(6870);
		
		System.out.println("Person 1 is " + p1.getName() + "and makes $" + p1.getSalary());
		System.out.println("Person 2 is " + p2.getName() + "and makes $" + p2.getSalary());
	}

}
