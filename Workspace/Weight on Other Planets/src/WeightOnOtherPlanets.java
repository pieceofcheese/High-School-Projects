import java.util.Scanner;


public class WeightOnOtherPlanets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Declaration
		int selection;
		double earth, planet;
		Scanner scan = new Scanner(System.in);
		
		//ask the question and store the weight
		System.out.println("What is your weight on the Earth?");
		earth = scan.nextDouble();
		
		//ask for what planet you want and store the answer
		System.out.println("1. Voltar\n2. Krypton\n3. Fertos\n4. Servontos");
		System.out.println("\t Selection?");
		selection = scan.nextInt();
		
		//Switch to determine your weight based on the selection
		switch (selection) {
		
			case 1: planet = earth*0.091;
					System.out.println("Your weight on Voltor would be " + planet);
					break;
				
			case 2: planet = earth*0.720;
					System.out.println("Your weight on Krypton would be " + planet);
					break;
			
			case 3: planet = earth*0.865;
					System.out.println("Your weight on Fertos would be " + planet);
					break;
				
			case 4: planet = earth*4.612;
					System.out.println("Your weight on Servontos would be " + planet);
					break;
			
			default: System.out.println("Choose a selection from the list");
		}

	}

}
