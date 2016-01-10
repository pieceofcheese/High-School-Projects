package exercises;

public class Lesson_37 {
	
	public static void main(String[] args) {
		
		//Blue Pelican lesson 37 Exercises
		
		
		//Exercise 1
		if(amount>balance||amount<=0) {
			
			String s = "Can't withdraw more than the balance or less than 0";
			IllegalArgumentException e = new IllegalArgumentException(s);
			throw e;
			
		}
		
	}
	
	//Exercise 2
	public void setStudentScore(int score) {
	
		if(score<0|| score>100) {
			
			String s = "Student score is outside of acceptable values";
			IllegalArgumentException e = new IllegalArgumentException(s);
			throw e;
		}
		
	}
	
	/* Exercise 3
	 * We say the program threw an error.
	 */
	
	/*Exercise 4
	 * The two types of exceptions are checked, and unchecked.
	 */
	
	/*Exercise 5
	 * The checked exception requires handling
	 */
	
	/*Exercise 6
	 * You can handle a checked exception by throwing it up
	 * the process tree or using a try, catch, finally block 
	 */
	
	/*Exercise 7
	 * Yes but it's not good practice
	 */
	
	/*Exercise 8
	 * An example of a checked exception is an IOException.
	 * It can be caused from corrupted documents
	 */
	
	/*Exercise 9
	 * An example of an unchecked exception is an ArrayOutOfBoundsException
	 * This is caused by a programmer error in which the array
	 * is smaller than the index chosen
	 */
	
	/*Exercise 10
	 * public String car (int xs) throws ArithmeticException
	 * {
	 * }
	 */
	
	

}
