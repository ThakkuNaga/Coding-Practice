package com.array.easy;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate_II {

    public static void main(String... args) {
        int[] a = { 1, 2, 3, 1, 2, 3 };
        boolean rtn = containsDuplicate(a, 2);
        System.out.println(rtn);
    }

    public static boolean containsDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

}