package elevenPointOne;

public class Tester {
	
	public static void main(String[] args) {
		
		DataSet data = new DataSet();
		Die die = new Die(6);
		
		for(int x=0; x<6; x++) {
			
			data.add(die);
			
		}
		
		System.out.println(data.getAverage());
		
	}

}
