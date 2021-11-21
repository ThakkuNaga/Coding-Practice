package com.sort;

import com.utils.Utils;

class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 10, 4, 3, 50, 50, 23, 90 };

        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        Utils.prtArr(arr);
    }
}