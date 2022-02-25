package com.array.medium;

/*
  Java Program
  Find nth digit of number
  From right to left
*/
public class AlternativeArraySort {
  // Swap two element in array
  public void swap(int[] arr, int left, int right) {
    int auxiliary = arr[left];
    arr[left] = arr[right];
    arr[right] = auxiliary;
  }

  // Check array is form of max heap or not
  public int compare(int[] arr, int left, int right, int root, int size) {
    int location = -1;

    if (left < size && arr[left] > arr[root]) {

      if (right < size && arr[right] > arr[left]) {
        // swap array element
        swap(arr, right, root);
        location = right;
      } else {
        // swap array element
        swap(arr, left, root);
        location = left;
      }
    } else if (right < size && arr[right] > arr[root]) {
      // swap array element
      swap(arr, right, root);
      location = right;
    }
    return location;
  }

  public void heap(int[] arr, int size, int root) {
    // Get The Location
    int left = 2 * root + 1;
    int right = 2 * root + 2;

    // Check modification of array
    int next = compare(arr, left, right, root, size);

    if (next != -1) {
      // When array is not form of max heap then its converted
      heap(arr, size, next);
    }
  }

  public void print_data(int[] arr, int size) {
    System.out.print("\n");
    for (int i = 0; i < size; i++) {
      System.out.print(" " + arr[i]);
    }
  }

  // Sort the array element
  public void sort(int[] arr, int size) {

    for (int i = (size / 2) - 1; i >= 0; i--) {
      heap(arr, size, i);
    }
    // convert heap into sorted form
    for (int i = size - 1; i >= 0; i--) {
      swap(arr, 0, i);
      heap(arr, i, 0);
    }
  }

  // Convert array into min max form
  public void max_min(int[] arr, int size, int i, int location) {
    if (i <= size / 2 && location < size) {
      // Fetch min max data
      int min = arr[i];
      int max = arr[size - 1 - i];

      // Recursive call
      max_min(arr, size, i + 1, location + 2);

      if (size - 1 - i == i) {
        arr[location] = arr[i];
      } else {
        // Assign min max data
        arr[location] = max;
        arr[location + 1] = min;
      }
    }
  }

  public static void main(String[] args) {

    AlternativeArraySort obj = new AlternativeArraySort();
    // Define array
    int[] arr = { 1, 6, 9, 4, 3, 7, 8, 2, 10 };

    // Get the size of array elements
    int size = arr.length;

    obj.print_data(arr, size);

    obj.sort(arr, size);

    obj.max_min(arr, size, 0, 0);
    System.out.print("\n Max Min Form");
    obj.print_data(arr, size);
  }
}