package com.math;

public class MinMaxSum {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 1, 2 };
        minMaxSum(arr);
        //minMaxSum1(arr);
    }

    public static void minMaxSum(int[] arr) {

        int minElement = arr[0];
        int maxElement = minElement;
        int sum = minElement;

        for (int i = 1; i < arr.length; i++) {

            // calculate the sum of
            // array elements
            sum += arr[i];

            // Keep updating the
            // minimum element
            if (arr[i] < minElement) {
                minElement = arr[i];
            }

            // Keep updating the
            // maximum element
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        System.out.println((sum - maxElement) + " " + (sum - minElement));
    }

    public static void minMaxSum1(int[] arr) {

        long max = 0;
        long min = 0;
        int n = arr.length;

        for (int i = 0, j = n - 1; i < n - 1; i++, j--) {

            // System.out.println(i + " " + j);
            // All elements except
            // rightmost will be added
            min += arr[i];

            // All elements except
            // leftmost will be added
            max += arr[j];
        }

        // Output: min_value and max_value
        System.out.println(min + " " + max);
    }

}