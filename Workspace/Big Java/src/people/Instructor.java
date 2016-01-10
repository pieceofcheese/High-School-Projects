package people;

public class Instructor implements Person {
	
	public Instructor(int birth, String name, double salary) {
		
		setName(name);
		setBirth(birth);
		setSalary(salary);
		
	}

	@Override
	public void setName(String x) {
		name = x;
		
	}

	@Override
	public void setBirth(int x) {
		birth = x;
		
	}
	
	public void setSalary(double x) {
		salary = x;
		
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public int getBirth() {
		
		return birth;
	}
	
	public double getSalary() {
		
		return salary;
	}
	
	int birth;
	String name;
	double salary;

}
