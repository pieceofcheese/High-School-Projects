
public class AdvancedBubble {
	
	public static void main(String[] args) {
		
		//make int array
		int array[] = {2,6,4,8,10,12,89,68,45,37};
		
		//sort
		advancedBubble(array, array.length-1);
		
		//print
		for(int x = 0; x<array.length; x++) {
			
			System.out.println(array[x]);
			
		}
		
	}
	
	public static void advancedBubble(int a[], int right) {
		
		//if the array is done sorting
		if(right==0) return;
			
		//sort normal bubble but no loop more
			for(int j = 0; j<a.length; j++) {
				
				//tries just in case :P
				try {
					
					if(a[j]>a[j+1]) {
						
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
						
					}
					
				}
				
				catch (RuntimeException e) {
					
				}
				
			}
			
			//recursion
			advancedBubble(a, right-1);
			
	}

}
