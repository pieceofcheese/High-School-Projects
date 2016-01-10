package exercises;

public class Lesson_18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Blue Pelican Lesson 18 exercises
		
		//Exercise 1
		
		double []sgt = new double [800];
		
		/**Exercise 2
		 * 
		 * 21 is printed
		 */
		
		//Exercise 3
		
		for (int j = 0; j<sgt.length; j++) {
			
			sgt[j] = Math.sqrt(sgt[j]);
		}
		
		/**Exercise 4
		 * 
		 * There are parentheses at the end of length which are unneeded
		 */
		
		/**Exercise 5
		 * 
		 * cr.length is 4
		 */
		
		//Exercise 7
		
		int []ref = {1, 2, 3, 4};
		
		for (int j = 0; j<ref.length; j++) {
			
			int sum = 0;
			
			sum = ref[j]^2;
		}
		
		/**Exercise 8
		 * 
		 * The code will try to fill more slots in an array than were
		 * allotted to the array causing a java error
		 */
		
		/**Exercise 10
		 * 
		 * The value of adc[1] is 56
		 */
		
		/**Exercise 11
		 * 
		 * The value would be 23
		 */
		
		/**Exercise 12
		 * 
		 * It would be null and throw a java ArrayIndexOutOfBoundsException
		 * if you tried accessing adc[5]
		 */
		
		/**Exercise 13
		 * 
		 * The following code segment takes an element of b[j] and solves for
		 * the absolute value of it, and setting that as the element
		 */
		
		/**Exercise 14
		 * 
		 * >>>1234
		 */
		
		//Exercise 15
		
		int indx;
		int []pg = {1, 2, 3, -1, -2, -3};
		
		for (indx = 0; indx<pg.length; indx++) {
			
			if (pg[indx]<0) {
				
				indx = pg[indx];
				
				break;	
			} 
			
		}
		
		/**Exercise 16
		 * 
		 * The system will print
		 * Wh
		 * ping crane
		 */

	}

}
