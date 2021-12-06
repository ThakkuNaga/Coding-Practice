package com.array;

import java.util.HashMap;
import java.util.Map;

class ConsecutiveSubArrays {

    public static void main(String[] args) {
        int[] a = { 3, 2, 0, 1 };
        /*
         * 3, 2, 1, 0, 3 2, 2 1, 1 0, 3 2 1, 2 1 0, 3 2 1 0
         */
       
        printSubArray(a);
        consecvArrays(a);
        // printSubArray(a, 0);
    }

    private static void printSubArray(int[] a) {
        int n = a.length;
        int cur = 0;

        while (cur < n) {
            String result = "";
            for (int i = cur; i < n; i++) {
                result += a[i];
                System.out.print("[" + result + "] ");
            }
            cur++;
        }

        long sum = 0;
      
        // computing sum of subarray using formula
        for (int i=0; i<n; i++)
            sum += (a[i] * (i+1) * (n-i));
       
        System.out.println("\nSum of all: "+sum);
    }

    public static void printSubArray(int[] a, int currIndex) {

        if (currIndex == a.length)
            return;

        String result = "";
        for (int i = currIndex; i < a.length; i++) {
            result += a[i];
            System.out.print("[" + result + "] ");
        }
        printSubArray(a, currIndex + 1);
    }

    private static void consecvArrays(int[] a) {
        int res = 0;
        int i = 0;
        int n = a.length;

        for (int j = 0; j < n; j++) {

            if (j > 0 && a[j] < a[j - 1]) {
                res += j - i + 1;
            } else {
                res += 1;
                i = j;
            }
        }
        System.out.println(res);
    }

}