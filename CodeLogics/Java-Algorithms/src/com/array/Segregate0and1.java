package com.array;

import com.utils.Utils;

public class Segregate0and1 {
    public static void main(String[] args) {       
        int a[] = { 1, 1, 0, 0, 0, 0, 1, 1 };
        segregate(a, a.length);
        Utils.prtArr(a);
    }

    static void segregate(int a[], int n) {       
        int left = 0;       
        for (int i = 0; i < a.length; ++i) {      
            if (a[i] == 0) {
                int temp = a[left];
                a[left] = a[i];
                a[i] = temp;
                ++left;
            }
        }
    }

    static void segregate2(int arr[], int n) {
        int count = 0; // counts the no of zeros in arr

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }

        // loop fills the arr with 0 until count
        for (int i = 0; i < count; i++)
            arr[i] = 0;

        // loop fills remaining arr space with 1
        for (int i = count; i < n; i++)
            arr[i] = 1;
    }

}