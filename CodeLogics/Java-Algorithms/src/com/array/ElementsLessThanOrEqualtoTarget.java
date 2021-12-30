package com.array;
// Count smaller or equal elements in sorted array.

class ElementsLessThanOrEqualtoTarget {

	// A binary search function. It returns number of elements
	// less than of equal to given key

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 5, 8, 10 };
		int key = 1;
		int n = arr.length;
		System.out.print(binarySearchCount(arr, n, key));
	}
	static int binarySearchCount(int arr[], int n, int key) {
		int left = 0;
		int right = n - 1;
		int count = 0;

		while (left <= right) {
			int mid = (right + left) / 2;

			// Check if middle element is
			// less than or equal to key
			if (arr[mid] <= key) {

				// At least (mid + 1) elements are there
				// whose values are less than or equal to key
				count = mid + 1;
				left = mid + 1;
			}else 
			// If key is smaller, ignore right half
				right = mid - 1;
		}
		return count;
	}

}
