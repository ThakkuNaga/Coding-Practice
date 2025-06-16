package com.array;

import java.util.Arrays;
import com.utils.Utils;

public class LongestConsecutiveSeq {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        int[] nums3 = { 1, 0, 1, 2 };

        Utils.prt(longestConsecutiveSeq(nums));
        Utils.prt(longestConsecutiveSeq(nums2));
        Utils.prt(longestConsecutiveSeq(nums3));
    }

    public static int longestConsecutiveSeq(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                max = Math.max(max, count);
                count = 1;
            }

        }
        return Math.max(max, count);
    }

}