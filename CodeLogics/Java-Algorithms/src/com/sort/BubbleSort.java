package com.sort;

import com.utils.Utils;

class BubbleSort {

    public static void main(String[] args) {
        int[] arr = { 10, 4, 3, 50, 50, 23, 90 };

        bubbleSort(arr);
        Utils.prtArr(arr);

        bubbleSort2(arr);
        Utils.prtArr(arr);
    }

    static void bubbleSort(int[] arr) {
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

    }

    static void bubbleSort2(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)

            for (int j = 0; j < n - i - 1; j++)

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}