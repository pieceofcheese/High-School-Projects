package matrix_Multiplication;

public class Multiplication {
	
	public static void main(String[] args) {
		
		int[][] array1;
		int[][] array2;
		int[][] array3;
		
		array1 = new int[][] { {1,2,3},
							   {4,5,6},
							   {7,8,9} };
		
		array2 = new int[][] { {9,8,7},
							   {6,5,4},
							   {3,2,1} };
		
		array3 = new int[array1.length][array2[0].length];
		
		if(array1[0].length==array2.length) {
			
			for(int x = 0; x<array1.length; x++) {
				
				for(int z = 0; z<array2[x].length; z++) {
				
				int add = 0;	
					
					for(int y = 0; y<array2.length; y++) {
						
						add += array1[x][y]*array2[y][z];
						
					}
					
				array3[x][z] = add;	
					
				}
				
			}
			
		}
	
		for(int x = 0; x<array3.length; x++) {
			
			for(int y = 0; y<array3[x].length; y++) {
				
				System.out.print(array3[x][y] + " ");
				
			}
		
		System.out.println("");
			
		}
	}
}
