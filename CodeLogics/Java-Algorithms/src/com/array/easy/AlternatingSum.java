package com.array.easy;

import java.util.Arrays;

class AlternatingSum {

    public static void main(String... args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        int[] rtn = alternatingSum(a);
        System.out.println(Arrays.toString(rtn));
    }

    private static int[] alternatingSum(int[] a) {
        if (a.length == 0 || a.length == 2)
            return a;
        int[] rtn = new int[] { a[0], 0 };
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 0) {
                rtn[0] += a[i];
            } else {
                rtn[1] += a[i];
            }
        }
        // System.out.println(oddSum + " " + evenSum);
        return rtn;
    }

}