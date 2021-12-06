package com.array;

import java.util.Arrays;

class MinSwaps {
    public static int minswaps(int arr[], int n) {
        // Arrays.sort(arr);
        int count = 0;
        int num_unplaced_zeros = 0;

        for (int index = n - 1; index >= 0; index--) {
            if (arr[index] == 0)
                num_unplaced_zeros += 1;
            else
                count += num_unplaced_zeros;
        }
        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 0, 1, 0, 1 };
        System.out.println(minswaps(arr, 8));
    }
}