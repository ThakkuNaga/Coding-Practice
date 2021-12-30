package com.array;

public class FindMaxConsecutiveOnes2 {

    public static void main(String... args) throws Exception {
        int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int K = 2;
        System.out.println(findMaxConsecutiveOnes(A, K));

        /*
         * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
         * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
         */
    }

    public static int findMaxConsecutiveOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0)
                K--;
            if (K < 0 && A[i++] == 0)
                K++;
        }
        return j - i;
    }

}