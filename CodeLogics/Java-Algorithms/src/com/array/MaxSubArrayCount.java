package com.array;

class MaxSubArrayCount {

    // Print the number of subarrays having negative sums.
    public static void main(String[] args) {
        int[] arr = { 1, -2 };
        int n = arr.length;
        subArrayCount(arr, n);
    }

    public static void subArrayCount(int[] arr, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}