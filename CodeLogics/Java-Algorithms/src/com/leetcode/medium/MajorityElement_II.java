package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MajorityElement_II {
    /*
     * 229. Majority Element II
     * 
     * Given an integer array of size n, find all elements that appear more than ⌊
     * n/3 ⌋ times.
     * 
     */

    public static void main(String[] args) {

        int[] nums = { 3, 2, 3 };
        //int[] nums = { 1, 2 };
        System.out.println("Inp: "+Arrays.toString(nums));

        System.out.println("Out: "+majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == major1) {
                count1++;
            } else if (num == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                major2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == major1)
                count1++;
            else if (num == major2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3)
            result.add(major1);
        if (count2 > nums.length / 3)
            result.add(major2);

        return result;
    }

}