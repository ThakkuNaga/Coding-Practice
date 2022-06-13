package com.assesments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class ReassignArray {
    public static void main(String[] args) {
        // int nums[] = { 1, 3, 7, 3, 1, 5, 6, 7, 3 };
        int nums[] = { 1, 3, 7, 3 };// { 2, 9, 3, 2, 3 };
        reassignArray(nums);
    }

    private static void reassignArray(int[] nums) {
        System.out.println("\n" + Arrays.toString(nums));
        HashSet<Integer> distinct = new HashSet<>();
        for (int n : nums)
            distinct.add(n);

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 1;
        for (int n : distinct)
            map.put(n, i++);

        System.out.println(map);

        int k = 0;
        for (int j : nums)
            nums[k++] = map.get(j);
        System.out.println("\n" + Arrays.toString(nums));
    }

}