package com.array;

import java.util.Arrays;

public class RemoveDuplicates2 {

    public static void main(String... args) throws Exception {
        int[] arr = { 1, 2, 2, 3, 4, 5, 5 };
        removeDuplicates(arr);
    }

    // Remove Duplicates from sorted Array with Xtra Space
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {

            if (arr[i] != arr[i + 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[n - 1];
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }

        return j + 1;
    }

    // Remove Duplicates from sorted Array without Xtra Space
    public static int removeDuplicates2(int[] arr) {

        int n = arr.length;
        int[] rstArr = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {

            if (arr[i] != arr[i + 1]) {
                rstArr[j] = arr[i];
                j++;
            }
        }
        rstArr[j] = arr[n - 1];
        System.out.println(Arrays.toString(rstArr));

        return j + 1;
    }

}