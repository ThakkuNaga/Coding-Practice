package com.array;

public class FindMaxConsecutiveOnes {
    public static void main(String... args) throws Exception {
        int[] A = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(A));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
                max = Math.max(ones, max);
            } else {
                ones = 0;
            }
        }

        return max;
    }

}