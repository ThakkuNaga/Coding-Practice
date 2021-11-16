package com.array;

import com.utils.Utils;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Utils.prtLn(removeDuplicates(nums));
        Utils.prtArr(nums);
    }

    // Approach #1 (2 pointers) [Accepted]
    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int insIdx = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[insIdx] = nums[j];
                insIdx++;
            }
        }

        return insIdx;
    }

}