package exercises;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortingStuffs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int a[] = { 1, 5, 9, 7, 52, 46, 8799, 8, 76, 54, 16, 479, 784, 54 };
		bubbleSort(a);

		int b[] = { 1, 5, 9, 7, 52, 46, 8799, 8, 76, 54, 16, 479, 784, 54 };
		insertionSort(b);

		int c[] = { 1, 5, 9, 7, 52, 46, 8799, 8, 76, 54, 16, 479, 784, 54 };
		selectionSort(c);

		int d[] = { 1, 5, 9, 7, 52, 46, 8799, 8, 76, 54, 16, 479, 784, 54 };
		mergeSort(d, 0, d.length - 1);

		int e[] = { 1, 5, 9, 7, 52, 46, 8799, 8, 76, 54, 16, 479, 784, 54 };
		quickSort(e, 0, d.length - 1);

		for (int x = 0; x < a.length; x++) {

			System.out.print(a[x] + " ");

		}
		System.out.println();

		for (int x = 0; x < b.length; x++) {

			System.out.print(b[x]+ " ");

		}
		System.out.println();

		for (int x = 0; x < c.length; x++) {

			System.out.print(c[x]+ " ");

		}
		System.out.println();

		for (int x = 0; x < d.length; x++) {

			System.out.print(d[x]+ " ");

		}
		System.out.println();

		for (int x = 0; x < e.length; x++) {

			System.out.print(e[x]+ " ");

		}
		System.out.println();

	}

	public static void bubbleSort(int a[]) throws IOException {

		boolean loopMore;

		do {

			// boolean to check if loop should be redone
			loopMore = false;
			for (int j = 0; j < a.length; j++) {

				try {

					// check if a is after b
					if (a[j] > a[j + 1]) {

						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;

						// go and do merge again
						loopMore = true;

					}

				}

				catch (RuntimeException e) {

				}

			}

		} while (loopMore);

	}

	public static void insertionSort(int a[]) throws IOException {

		// on kth pass insert item into it's correct position among first k
		// items in array
		for (int k = 1; k < a.length; k++) {

			int itemToInsert = a[k];
			int j = k - 1;
			boolean keepGoing = true;

			// loop
			while ((j >= 0) && keepGoing) {

				// check if a is before b
				if (itemToInsert < a[j]) {

					// move array
					a[j + 1] = a[j];
					j--;

					// if there is nothing else to move
					if (j == -1) {
						a[0] = itemToInsert;
					}

					// found place to insert
				} else {

					keepGoing = false;
					a[j + 1] = itemToInsert;

				}

			}

		}

	}

	public static void selectionSort(int a[]) throws IOException {

		int minIndex;
		int min;

		// find min index
		for (int i = 0; i < a.length; i++) {

			min = a[i];
			minIndex = i;

			for (int j = i + 1; j < a.length; j++) {
				
				if (a[j] < min) {

					min = a[j];

					minIndex = j;

				}

			}

			// set min index
			a[minIndex] = a[i];
			a[i] = min;

		}
	}

	public static void mergeSort(int a[], int left, int right)
			throws IOException {

		// if there is one value
		if (right == left)
			return;

		// choose middle
		int middle = (left + right) / 2;

		// split more
		mergeSort(a, left, middle);
		mergeSort(a, middle + 1, right);

		// sort
		merge(a, left, middle, right);

	}

	private static void merge(int[] a, int left, int middle, int right) {

		// make values
		int tmpArray[] = new int[right - left + 1];

		int index1 = left;
		int index2 = middle + 1;
		int indx = 0;

		// sort based on indexes
		while (index1 <= middle && index2 <= right) {

			// for left side
			if (a[index1] < a[index2]) {

				tmpArray[indx] = a[index1];
				index1++;

				// for right side
			} else {

				tmpArray[indx] = a[index2];
				index2++;

			}

			indx++;

		}

		// fill rest of it
		while (index1 <= middle) {

			tmpArray[indx] = a[index1];
			index1++;
			indx++;
		}

		while (index2 <= right) {

			tmpArray[indx] = a[index2];
			index2++;
			indx++;

		}

		// fill array with sorted variables
		for (indx = 0; indx < tmpArray.length; indx++) {

			a[left + indx] = tmpArray[indx];

		}

	}

	public static void quickSort(int a[], int left, int right)
			throws IOException {

		// if one value
		if (left >= right)
			return;

		int k = left;
		int j = right;
		// choose pivot
		int pivotValue = a[left + (right - left) / 2];

		while (k < j) {

			// if a is in right side of pivot
			while (a[k] < pivotValue) {

				k++;

			}

			// if b is on right side of pivot
			while (pivotValue < a[j]) {

				j--;

			}

			// check to make sure they aren't past each other
			if (k <= j) {

				// switch
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k++;
				j--;

			}

		}

		// recursion
		quickSort(a, left, j);
		quickSort(a, k, right);

	}

}
