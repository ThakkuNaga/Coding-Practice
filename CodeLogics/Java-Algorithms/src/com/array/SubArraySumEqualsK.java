package com.array;

import java.util.HashMap;

import com.utils.Utils;

class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k = 7;
        Utils.prt(subArraySumEqualsK(nums, k));
        // Utils.prt(subarraySum(nums, k));
    }

    public static int subArraySumEqualsK(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                // System.out.println(i + " " + j);
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}