package trees;

public class Objects {
	
	public static void main(String args[]) {
		
		Integer i[] = {-7,15,21,22,43,49,51,67,78,81,84,89,95,97};
		System.out.println(binarySearch(i,22));
		System.out.println(binarySearch(i,89));
		System.out.println(binarySearch(i,-100));
		System.out.println(binarySearch(i,72));
		System.out.println(binarySearch(i,102));
		
		
	}
	
	//Look for srchVal in the a[] array and return the index of where it's found
	//Return -1 if not found
	private static int binarySearch(Comparable a[], Comparable srchVal) {
		
		int lb = 0;
		int ub = a.length-1;
		
		while(lb<=ub) {
			
			int mid = (lb + ub)/2;
			if(a[mid].compareTo(srchVal)==0) {
				
				return mid;
				
			} else if (srchVal.compareTo(a[mid])>0) {
				lb = mid+1;
			} else {
				
				ub=mid-1;
				
			}
			
		}
		
		return -1;
		
	}

}
