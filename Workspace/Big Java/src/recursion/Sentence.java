package recursion;

public class Sentence {

	//class values
	private String object;
	
	//object constructor statement
	public Sentence(String s) {
		object = s;
	}
	
	//method call
	public boolean find(String s) {
		
		return findString(s, 0);
		
	}
	
	//recursive
	public boolean findString(String find, int start) {
		
		//if word doesn't have find string
		if(object.length()<start+find.length()) return false;
		
		// check a substring
		if(object.substring(start, start+find.length()).equalsIgnoreCase(find)){
		return true;
		}
		
		//throw back
		return findString(find, start+1);
	}
	
}
