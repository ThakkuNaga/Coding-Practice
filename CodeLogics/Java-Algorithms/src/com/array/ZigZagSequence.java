package com.array;

import java.util.Arrays;

class ZigZagSequence {

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 1, 4 };
        int n = 5;
        findZigZagSequence(a, n);
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int mid = (n + 1) / 2 - 1;// find the correct middle
        System.out.println(mid);
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
        System.out.println(Arrays.toString(a));

        int st = mid + 1;
        int ed = n - 2; // start with the last element before the last
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;// decrease
        }
        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}