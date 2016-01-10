
import java.io.*;
import java.util.*;

public class GutenbergSort {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//initialize scanners
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		boolean quit = false;
		
		//ask in out
		System.out.print("enter location");
		String input = scan1.nextLine();
		System.out.print("enter output location");
		output = scan1.nextLine();
		
		//make dictionary
		fillDictionary(input);
		
		
		
		do{
			//ask for coice
			System.out.println("Please select your sort kind");
			System.out.println("1. Bubble sort");
			System.out.println("2. Insertion sort");
			System.out.println("3. Selection sort");
			System.out.println("4. Merge sort");
			System.out.println("5. Quick sort");
			System.out.println("6. Quit");
			
			try {
				
				//switch
				switch(scan.nextInt()) {
				
				case 1: bubbleSort();
						break;
						
				case 2: insertionSort();
						break;
						
				case 3: selectionSort();
						break;
				
				case 4: //initialize stuffs
						
						String[] text = getFromDictionary();
						FileWriter fw = new FileWriter(output + "\\file.txt");
						PrintWriter print = new PrintWriter(fw);	
						
						//start
						System.out.println("start");
						long startTime = System.nanoTime();
						
						//sort 
						text = mergeSort(text, 0, text.length-1);
						
						//export 
						for(int x = 0; x<text.length; x++) {
							
							print.println(text[x]);
							
						}
						
						//end
						System.out.println("end");

						long endTime = System.nanoTime();
						
						//print time
						System.out.println("Time taken: " + (endTime-startTime)/1000000 + "milliseconds");
						
						//close stuff
						print.close();
						fw.close();
						
						break;
						
				case 5: //initialize stuffs
						
						String[] text2 = getFromDictionary();
						FileWriter fw2 = new FileWriter(output + "\\file.txt");
						PrintWriter print2 = new PrintWriter(fw2);
						
						//start
						System.out.println("start");
						long startTime1 = System.nanoTime();
						
						//sort
						quickSort(text2, 0, text2.length-1);
						
						//export 
						for(int x = 0; x<text2.length; x++) {
							
							print2.println(text2[x]);
							
						}
						
						//end
						System.out.println("end");

						long endTime1 = System.nanoTime();
						
						//print time
						System.out.println("Time taken: " + (endTime1-startTime1)/1000000 + "milliseconds");
						
						//close stuff
						print2.close();
						fw2.close();
						
						break;
				
				case 6: quit = true;
						break;
							
				default: System.out.println("Choose from the selection");
				
				}
				
			}
			
			catch(IOException e) {
				System.out.println("array out");
			}
			
		}while(!quit);
		
		scan.close();
		
	}
	
	public static void fillDictionary(String txt) throws IOException {
		

		//scanner printwriter etc.
		Scanner scan = new Scanner(new File(txt));
		FileWriter fw = new FileWriter(output + "\\file.txt");
		PrintWriter print = new PrintWriter(fw);
		
		//go through book
		while(scan.hasNext()) {
			
			//go to lower case
			String s = scan.next().toLowerCase();

			//take away useless format
			s=removePointless(s);
			
			//check length 
			if(s.length()>=3) {
				
				//fill dictionary
				if(words.get(s) == null) {
					
					words.put(s, 1);
					total++;
				} else {
					
					words.put(s, words.get(s)+1);
					total++;
					
				}
			}
			
		}
		
		//make enumeration obj
		Enumeration<String> stuff = words.keys();
		print.println("total: " + total);
		
		//print/save words
		while(stuff.hasMoreElements()) {
			
			String key = stuff.nextElement();
			size++;
			print.println(key + ": count " + words.get(key));
			
		}
		
		//close stuff
		scan.close();
		print.close();
		fw.close();
	}
	
	public static String[] getFromDictionary() { 
		
		//make enumeration obj
		Enumeration<String> dictionary = words.keys();
		
		//count init
		int count = 0;
		
		//make string array obj
		String[] sorted = new String[size];
		
		//fill string array with enumeration
		while(dictionary.hasMoreElements()) {
			
			String word = dictionary.nextElement();
			sorted[count] = word;
			count++;
		}
		
		//return
		return sorted;
		
	}
	
	public static String removePointless(String text) {
		
		
		//get word
		char arrayInit[] = text.toCharArray();
		
		//make char array out
		ArrayList<Character> array = new ArrayList<Character>();
		
		//initialize return 
		String fin = "";
		
		//go through char array
		for(int x = 0; x<arrayInit.length; x++) {
	
			switch(arrayInit[x]) {
			
			case '.':  break;
			
			case '_': break;
			
			case '[': break;
			
			case ']': break;
			
			case '|': break;
			
			case '*': break;
			
			case ',': break;
			
			case ':': break;
			
			case '"': break;
			
			case '-': break;
			
			case '(': break;
			
			case ')': break;
			
			case '?': break;
			
			case ';': break;
	
			case '0': break;
	
			case '1': break;
	
			case '2': break;
	
			case '3': break;
	
			case '4': break;
	
			case '5': break;
	
			case '6': break;
	
			case '7': break;
	
			case '8': break;
	
			case '9': break;
	
			case '\'': break;
			
			case '!': break;
	
			default: array.add(arrayInit[x]);
						break;
			
			}
				
			
		}
		
		for(int x = 0; x<array.size(); x++) {
			
			fin += array.get(x);
			
		}
		
		return fin;
			
	}

	public static void bubbleSort() throws IOException {
		
		//initializ stuffs
		FileWriter fw = new FileWriter(output + "\\file.txt");
		PrintWriter print = new PrintWriter(fw);
		String[] text = getFromDictionary();
		boolean loopMore = false;
		
		//start
		System.out.println("Start");
		
		long startTime = System.nanoTime();
		
		
		//do sort
		do{
			
			//boolean to check if  loop should be redone
			loopMore = false;
			for(int j = 0; j<text.length; j++) {
				
				try {
					
					//check if a is after b
					if(text[j].compareTo(text[j+1])>0) {
						
						String temp = text[j];
						text[j] = text[j+1];
						text[j+1] = temp;
						
						//go and do merge again
						loopMore = true;
						
					}
					
				}
				
				catch (RuntimeException e) {
					
				}
				
			}
			
		}while(loopMore);
		
		//print out
		for(int x = 0; x<text.length; x++) {
			
			print.println(text[x]);
			
		}
		
		//finish stuff
		System.out.println("done");
		
		long endTime = System.nanoTime();
		
		System.out.println("Time taken: " + (endTime-startTime)/1000000 + "milliseconds");

		print.close();
		fw.close();
		
	}
	
	public static void insertionSort() throws IOException{
		
		//intialize stuff
		FileWriter fw = new FileWriter(output + "\\file.txt");
		PrintWriter print = new PrintWriter(fw);
		String[] text = getFromDictionary();
		
		//start
		System.out.println("start");
		
		long startTime = System.nanoTime();
		//on kth pass insert item into it's correct position among first k items in array
		for(int k = 1; k<text.length; k++) {
			
			String itemToInsert = text[k];
			int j = k-1;
			boolean keepGoing = true;
			
			//loop 
			while((j>=0)&&keepGoing) {
				
				//check if a is before b
				if(itemToInsert.compareTo(text[j])<0) {
					
					//move array
					text[j+1] = text[j];
					j--;
					
					//if there is nothing else to move
					if(j==-1) {
						text[0] = itemToInsert;
					}
					
				//found place to insert
				} else {
					
					keepGoing = false;
					text[j+1] = itemToInsert;
					
				}
				
			}
			
		}
		
		//finish stuff
		for(int x = 0; x<text.length; x++) {
			
			print.println(text[x]);
			
		}
		
		System.out.println("end");
		
		long endTime = System.nanoTime();
		
		System.out.println("Time taken: " + (endTime-startTime)/1000000 + "milliseconds");
		
		print.close();
		fw.close();
		
	}
	
	public static void selectionSort() throws IOException{
		
		//init stuff
		FileWriter fw = new FileWriter(output + "\\file.txt");
		PrintWriter print = new PrintWriter(fw);
		String[] text = getFromDictionary();
		
		//start
		System.out.println("start");
		
		long startTime = System.nanoTime();
		
		int minIndex;
		String min;
		
		//find min index
		for(int i = 0; i<text.length; i++) {
			
			min = text[i];
			minIndex = i;
			
			for(int j = i+1; j<text.length; j++) {	
				
				if(text[j].compareTo(min)<0) {
					
					min = text[j];
					
					minIndex = j;
					
				}
				
			}
			
			//set min index
			text[minIndex] = text[i];
			text[i] = min;
			
		}
		
		//finish stuff
		for(int x = 0; x<text.length; x++) {
			
			print.println(text[x]);
			
		}
		
		System.out.println("end");
		
		long endTime = System.nanoTime();
		
		System.out.println("Time taken: " + (endTime-startTime)/1000000 + "milliseconds");
		
		print.close();
		fw.close();
	}
	
	public static String[] mergeSort(String a[], int left, int right) throws IOException{
		
		//if one value
		if(!(right==left)) {
			
			//choose middle
			int middle = (left + right)/2;
			
			//split more
			sort(a, left, middle);
			sort(a, middle+1, right);
			
			//sort
			merge(a, left, middle, right);
			
		}
		
		return a;
		
	}
	
	public static void sort(String a[], int left, int right) throws IOException{
		
		//if there is one value
		if(right==left) return;
		
		//choose middle
		int middle = (left + right)/2;
		
		//split more
		sort(a, left, middle);
		sort(a, middle+1, right);
		
		//sort
		merge(a, left, middle, right);
		
	}
	
	private static void merge(String[] a, int left, int middle, int right) {
		
		//make values
		String tmpArray[] = new String[right-left+1];
		
		int index1 = left;
		int index2 = middle + 1;
		int indx = 0;
		
		//sort based on indexes
		while(index1 <= middle&&index2<=right) {
			
			//for left side
			if(a[index1].compareTo(a[index2])<0) {
				
				tmpArray[indx] = a[index1];
				index1++;
			
			//for right side
			} else {
				
				tmpArray[indx] = a[index2];
				index2++;
				
			}
			
			indx++;
			
		}
		
		//fill rest of it
		while(index1<=middle) {
			
			tmpArray[indx] = a[index1];
			index1++;
			indx++;
		}
		
		while(index2<=right){
			
			tmpArray[indx] = a[index2];
			index2++;
			indx++;
			
		}
		
		//fill array with sorted variables
		for(indx = 0; indx<tmpArray.length; indx++) {
			
			a[left+indx] = tmpArray[indx];
			
		}
		
	}

	public static void quickSort(String a[], int left, int right) throws IOException{
		
		//if one value
		if(left>=right) return;
		
		int k = left;
		int j = right;
		//choose pivot
		String pivotValue = a[left+(right-left)/2];
		
		while(k<j) {
			
			//if a is in right side of pivot
			while (a[k].compareTo(pivotValue)<0) {
				
				k++;
				
			}
			
			// if b is on right side of pivot
			while(pivotValue.compareTo(a[j])<0) {
				
				j--;
				
			}
			
			//check to make sure they aren't past each other
			if(k<=j) {
				
				//switch
				String temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k++;
				j--;
				
			}
			
		}
		
		//recursion
		quickSort(a, left, j);
		quickSort(a,k,right);
		
	}
	
	
	//class variables
	private static Dictionary<String, Integer> words = new Hashtable<String, Integer>();
	public static int total = 0;
	public static int size = 0;
	public static String output;
}
