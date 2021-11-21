package com.sort;

import java.util.Arrays;

class BubbleSortRev {

    public static void main(String args[]) {
        int[] array = { 8, 22, 7, 9, 31, 5, 13 };
        int size = array.length - 1;

        //int cnt = 0;
        for (int i = 0; i < size; i++) {
            //cnt++;
            for (int j = 0; j < size - i; j++) {
                //cnt++;
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        //System.out.println(cnt);
        System.out.println(Arrays.toString(array));
    }
}