package test;

public class Object {
	
	public Object() {
		
		x = 4;
		cars = new int[x][x];
	}

	public Object(int c) {
		
		x = 3;
		cars = new int [c][x];
		
	}
	
	public void method() {
		
		x = 2+1;
	}
	
	public int getLength() {
		
		return cars.length;
	}
	
	private int x;
	private int [][]cars;

}
