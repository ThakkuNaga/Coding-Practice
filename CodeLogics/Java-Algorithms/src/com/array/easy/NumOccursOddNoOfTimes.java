package com.array.easy;

import java.util.HashMap;
import java.util.Map;

class NumOccursOddNoOfTimes {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 3, 2, 1, 2, 2, 2, 4 };
        numOccursOddNoOfTimes(a);
        numOccursOddNoOfTimes2(a);
    }

    // Time O(n) Space O(1)
    private static void numOccursOddNoOfTimes(int[] a) {

        int num = a[0];
        for (int i = 1; i < a.length; i++) {
            num = num ^ a[i];
        }
        System.out.println(num);
    }

    // Time O(n) Space O(n)
    private static void numOccursOddNoOfTimes2(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int k : map.keySet())
            if (map.get(k) % 2 != 0)
                System.out.println(k);

        System.out.println(map);

    }

}