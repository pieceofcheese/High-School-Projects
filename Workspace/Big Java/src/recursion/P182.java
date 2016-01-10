package recursion;

public class P182 {
	
	public static void main(String[] args) {
		
		//String to be flipped
		String greeting = "Hello!";
		
		//string to put flipped in
		String sen;
		
		//flip
		sen = reverse(greeting,0,greeting.length());
		
		//Print flipped
		System.out.println(sen);
		
	}
	
	public static String reverse(String s,int start, int end) {
		
		//check if it's just one character
		if(start==end||end-start<=1) return s;
		
		//calc middle value
		int middle = (start+end)/2;
		
		//sub string into part 1
		String sub1 = s.substring(start, middle);
		
		// run method again
		String sub3 = reverse(sub1, 0, sub1.length());
		

		//sub part 2
		String sub2 = s.substring(middle, end);
		
		//run method with part2
		String sub4 = reverse(sub2, 0, sub2.length());
		
		//return the helper string
		return helper(sub3, sub4);
	}
	
	public static String helper(String suba, String subb) {
		
		String orig;
		
		//add part 1 onto part 2 to make ba from ab
		orig = subb.concat(suba);
		
		return orig;
		
	}

}
