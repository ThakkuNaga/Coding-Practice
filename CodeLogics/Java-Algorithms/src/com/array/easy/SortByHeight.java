package com.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntergerSum2 {

    public static void main(String[] args) {
        int[] a = { -1, 150, 190, 170, -1, -1, 160, 180 };
        System.out.println(Arrays.toString(sortByHeight(a)));
    }

    static int[] sortByHeight(int[] a) {
        int[] arr2 = a.clone();

        Arrays.sort(a);
        List<Integer> list = new ArrayList<Integer>();
        for (int n : a) {
            if (n != -1)
                list.add(n);
        }
        for (int i = 0, j = 0; i < arr2.length; i++) {

            if (arr2[i] != -1) {
                arr2[i] = list.get(j);
                j++;
            }
        }
        return arr2;
    }
}