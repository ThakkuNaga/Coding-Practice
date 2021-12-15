package com.array;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String... args) throws Exception {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(missingInteger(A));
    }

    public static int missingInteger(int[] A) {

        int N = A.length, res = 1;
        boolean found = false;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1 && !found; i++) {
            if (!set.contains(i)) {
                res = i;
                found = true;
            }
        }
        return res;

    }

}