package exercises;

public class Lesson_37A {

	//Blue Pelican Lesson 36 Exercise (A), 1-13
	
	/*Exercise 1 & 3
	 * The base or super class is Green 
	 * 
	 */
	
	/*Exercise 2 & 4
	 * The Derived or Subclass is Red
	 */
	
	/*Exercise 5
	 * This would be legal because red is a subclass of green
	 * which the method resides in.
	 */
	
	/*Exercise 6
	 * Yes this is legal because the method blue resides in red, and returns
	 * a integer value
	 */
	
	//Exercise 7
	public int blue(double x) {
	int asd = (int) x;
	
	System.out.println(x);
	
	return asd;
	}
	
	Red.blue(Red.getMM());
	
	//Exercise 8
	public int blue(double x) {
		
		System.out.println(x);
		
		return (int) x;
	}
	
	Red.blue((double) Red.xx);
	
	
	
	//Exercise 9
	super(32000);
	
	/*Exercise 10
	 * Yes the peabody method is being overriden
	 */
	
	//Exercise 11
	super.peabody(11);
	
	/*Exercise 12
	 * This code is legal because Red is a subclass of Green
	 * s is also a value in red, and the Green constructor is
	 * run as well.
	 */
	
	/*Exercise 13
	 * b. this(x,y)
	 * d. this.z
	 * a. super(j)
	 * c. super.calc()
	 */

}
