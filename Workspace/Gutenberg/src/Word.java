
public class Word {
	
	public Word(String s) {
		word = s;
		count++;
		
	}
	
	public void addCount() {
		
		count++;
		
	}
	
	public String getWord() {
		
		return word;
		
	}
	
	public int getCount() {
		
		return count;
		
	}
	
	private String word = "";
	private int count=0;

}
