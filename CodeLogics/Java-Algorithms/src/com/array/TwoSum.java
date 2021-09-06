package com.array;

import java.util.HashMap;
import java.util.Map;

import com.utils.Utils;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        // 0 1 2 3
        Utils.prtArr(twoSum(nums, 9));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

}