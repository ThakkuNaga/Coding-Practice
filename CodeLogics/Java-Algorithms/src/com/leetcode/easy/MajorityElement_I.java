package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MajorityElement_I {
    /*
     * 169. Majority Element
     * 
     * Given an array nums of size n, return the majority element.
     * 
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You
     * may assume that the majority element always exists in the array.
     */

    public static void main(String[] args) {

        int[] nums = { -1, 1, 1, 1, 2, 1 };
        int[] nums1 = { 3, 2, 3 };
        System.out.println(Arrays.toString(nums1));

        System.out.println(majorityElement(nums));
        // System.out.println(majorityElement5(nums1));

    }

    public static int majorityElement(int[] nums) {
        int cnt = 0;
        int major = 0;

        for (int num : nums) {
            if (cnt == 0)
                major = num;

            if (major == num)
                cnt++;
            else
                cnt--;
        }

        return major;
    }

    // Sorting
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Hashmap
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rtn = 0;
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
            if (map.get(num) > nums.length / 2) {
                rtn = num;
                break;
            }
        }
        return rtn;
    }

    // Moore voting algorithm
    public static int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // Bit manipulation
    public static int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }

    public static int majorityElement5(int[] nums) {

        int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else
                count--;

        }
        return major;
    }

}