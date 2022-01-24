package com.array.easy;

import java.util.Arrays;

public class MakeConcecutive {

    public static void main(String... args) throws Exception {
        int[] a = { 6, 2, 3, 8 };
        System.out.println(makeConcecutive(a));
    }

    static int makeConcecutive(int[] a) {
        if (a.length <= 1)
            return 0;

        int min = a[0], max = a[0];

        for (int i : a) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        int len = (max - min) + 1;
        System.out.println(min + " " + max);
        System.out.println("len:" + len);

        return len - a.length;
    }

    static int makeConcecutive2(int[] a) {
        if (a.length <= 1)
            return 0;

        int min = a[0], max = a[0];

        for (int i : a) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        int len = (max - min) + 1;
        System.out.println(min + " " + max);
        System.out.println("len:" + len);
        int[] a2 = new int[len];

        for (int i = 0; i < len; i++) {
            a2[i] = min++;
        }

        System.out.println(Arrays.toString(a2));

        return a2.length - a.length;
    }

}