package blue_pelican_lesson_2;

public class Name_that_Celebrity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//declaring variables
		String s1 = "Allan Alda";
		String s2 = "John Wayne";
		String s3 = "Gregory Peck";
		
		//printing variables
		System.out.println(name_changer(s1));
		System.out.println(name_changer(s2));
		System.out.println(name_changer(s3));

	}
	
	 	static String name_changer(String s) {
		
	 	//method variables
		String fin;
		int l;
		
		//operations
		l = s.length();
		fin = s.substring(2, l-3);
		
		//return value
		return fin;
		
		
	}

}
