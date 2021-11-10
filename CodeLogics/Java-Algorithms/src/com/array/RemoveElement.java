package com.array;

import com.utils.Utils;

class RemoveElement {
    public static void main(String[] args) {

        int val = 2;
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        Utils.prtArr(nums);
        System.out.println(removeElement(nums, val));
        Utils.prtArr(nums);
        // System.out.println(removeElementFrmArr(nums, val));
        // Utils.prtArr(nums);

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    private static int removeElementFrmArr(int[] nums, int val) {

        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}