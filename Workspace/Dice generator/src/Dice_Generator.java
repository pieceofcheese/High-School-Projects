import java.util.Random;


public class Dice_Generator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variable initializations
		int max = 7;
		int []dice = new int [1000];
		
		//object construction
		Random roll = new Random();
		
		//rolling and saving the value
		for (int r = 0; r<dice.length; r++) {
			int rolled = roll.nextInt(max);
			if (rolled!=0) {
				dice[r] = roll.nextInt(max);
			}
		}
		
		//table header
		System.out.println("Number rolled:  Amount rolled:");
		
		for (int n = 0; n<6; n++) {
			
			//variable initialization
			int count = 0;
			
			//figure out how many of a number there was
			for (int r = 0; r<dice.length; r++) {
				if (dice[r] == (n+1)) {
					count++;
				}
			}
			
			//print out how many of a number there was
			System.out.println((n+1) + "\t\t" + count);
			
			//reset count
			count = 0;
		}

	}

}
