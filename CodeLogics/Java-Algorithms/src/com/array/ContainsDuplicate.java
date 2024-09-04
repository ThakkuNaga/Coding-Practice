package com.array;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = { 7, 1, 5, 3, 1, 4 };
        // int[] nums2 = { 0, 1, 2, 3, 4, 5 };
        System.out.println("Contains Duplicate : " + containsDuplicate1(nums));

    }

    // Approach #1 Brute Force
    public static boolean containsDuplicate3(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Approach #2 (Sorting) [Accepted]
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }

        return false;
    }

    // Approach #3 (Hash Table) [Accepted]
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (!set.add(x))
                return true;
        }
        return false;
    }

}