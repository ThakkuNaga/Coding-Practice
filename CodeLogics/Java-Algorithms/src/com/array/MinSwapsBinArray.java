package com.array;

import java.util.Arrays;

class MinSwapsBinArray {
    public static void main(String args[]) {
        int[] nums = { 0, 1, 1, 0, 1 };
        System.out.println("countSwaps: " + countSwaps(nums));
        System.out.println("minSwaps: " + minSwaps(nums, nums.length));
        sortBinaryArr1(nums);
        sortBinaryArr2(nums, nums.length);
    }

    public static void sortBinaryArr1(int... arr) {
        int n = arr.length;
        int zeros = 0;
        for (int i : arr) {
            if (i == 0) {
                zeros++;
            }
        }
        int ones = n - zeros;
        System.out.println(zeros + " " + ones);

        for (int i = 0; i < n; i++) {
            if (i < zeros)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void sortBinaryArr2(int a[], int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {

            // if number is smaller than 1
            // then swap it with j-th number
            if (a[i] == 0) {
                j++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        System.out.println(j);
        System.out.println(Arrays.toString(a));
    }

    public static int minSwaps(int arr[], int n) {
        int min_swaps1 = 0;
        int min_swaps2 = 0;
        int zeros = 0;
        int ones = 0;

        for (int i : arr) {
            if (i == 0) {
                zeros++;
                min_swaps1 += ones; // No. of steps to move the 0 to the left
            } else {
                ones++;
                min_swaps2 += zeros; // No. of steps to move the 1 to the left
            }
        }
        System.out.println(min_swaps1 + " " + min_swaps2);
        return Math.min(min_swaps1, min_swaps2);
    }

    static int countSwaps(int... a) {
        int n0 = 0, i0 = 0, n1 = 0, i1 = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 0)
                n0 += i - i0++; // No. of steps to move the 0 to the left
            else
                n1 += i - i1++; // No. of steps to move the 1 to the left
        }
        System.out.println(n0 + " " + n1);
        return Math.min(n0, n1); // Choose lowest no. of steps
    }
}