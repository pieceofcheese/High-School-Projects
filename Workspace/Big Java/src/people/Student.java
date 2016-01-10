package people;

public class Student implements Person {
	
	public Student(int birth, String name, String majors) {
		
		setName(name);
		setBirth(birth);
		major = majors;
		
	}

	@Override
	public void setName(String x) {
		name = x;
		
	}

	@Override
	public void setBirth(int x) {
		birth=x;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getBirth() {
		// TODO Auto-generated method stub
		return birth;
	}
	
	public void setMajor(String x) {
		major = x;
		
	}
	
	public String getMajor() {
		
		return major;
	}
	
	public int birth;
	public String name;
	public String major;

}
