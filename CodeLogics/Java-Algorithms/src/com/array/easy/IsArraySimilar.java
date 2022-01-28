package com.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

class IsArraySimilar {
    public static void main(String[] args) {
        int[] arr1 = { 4, 6, 3 };
        int[] arr2 = { 3, 4, 6 };
        System.out.println(areSimilar(arr1, arr2));
        System.out.println(areSimilar2(arr1, arr2));
    }

    static boolean areSimilar(int[] a1, int[] a2) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                ids.add(i);
            }
        }
        if (ids.size() == 0) {
            return true;
        }
        if (ids.size() != 2) {
            return false;
        }
        int id1 = ids.get(0);
        int id2 = ids.get(1);
        if (a1[id1] == a2[id2] && a1[id2] == a2[id1]) {
            return true;
        }
        return false;
    }

    static boolean areSimilar2(int[] a1, int[] a2) {
        if (a1.length != a2.length)
            return false;

        int countSwap = 0;
        int[] copyA = Arrays.copyOf(a1, a1.length);
        int[] copyB = Arrays.copyOf(a2, a2.length);

        // checking both contain the same elements...
        Arrays.sort(copyA);
        Arrays.sort(copyB);
        if (!Arrays.equals(copyA, copyB))
            return false;

        // checking for min 2 swaps using original arrays...
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                countSwap++;
        }

        return (countSwap == 2 || countSwap == 0);
    }

}
