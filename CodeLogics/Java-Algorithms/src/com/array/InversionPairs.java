package com.array;

/*
  Java program for
  Display inversions pairs in array
*/
public class InversionPairs {

    public static void main(String[] args) {
        int[] arr = { 1, 7, 6, 4, 5, 9, 8 };
        int size = arr.length;
        printInversionPair(arr, size);
    }

    // Print the all inversion pairs in given array
    public static void printInversionPair(int[] arr, int size) {
        if (size <= 1) {
            return;
        }
        // Outer loop
        for (int i = 0; i < size; ++i) {
            // Inner loop
            for (int j = i + 1; j < size; ++j) {
                if (arr[i] > arr[j]) {
                    // When element of i is greater than element of j
                    // Print inversion pair
                    System.out.println("(" + arr[i] +
                            "," + arr[j] + ")");
                }
            }
        }
    }
}
