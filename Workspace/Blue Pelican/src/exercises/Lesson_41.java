package exercises;

import java.io.*;
import java.util.*;

public class Lesson_41 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please select your sort kind");
		System.out.println("1. Bubble sort");
		System.out.println("2. Insertion sort");
		System.out.println("3. Selection sort");
		System.out.println("4. Merge sort");
		System.out.println("5. Quick sort");
		
		try {
			
			switch(scan.nextInt()) {
			
			case 1: bubbleSort();
					break;
					
			case 2: insertionSort();
					break;
					
			case 3: selectionSort();
					break;
			
			case 4: mergeSort();
					break;
					
			case 5: quickSort();
					break;
						
			default: System.out.println("Choose from the selection");
			
			}
			
		}
		
		catch(NullPointerException e) {
			
		}
		
	}
	
	public static void bubbleSort() throws IOException {
		
		Scanner text = new Scanner(new File("H:\\ComSci\\text\\gutenberg2"));
		
		
	}
	
	public static void insertionSort() {
		
	}
	
	public static void selectionSort() {
		
	}
	
	public static void mergeSort() {
		
	}
	
	public static void quickSort() {
		
	}

}
