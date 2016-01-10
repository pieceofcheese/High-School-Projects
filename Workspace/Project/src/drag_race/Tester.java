package drag_race;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Race test = new Race(1);
		
		test.setName(1, "Porsche");
		test.setTorque(1, 1200);
		test.setRPM(1, 8500);
		test.setMass(1, 3245);
		
		test.race();

	}

}
