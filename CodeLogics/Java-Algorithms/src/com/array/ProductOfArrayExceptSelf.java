package com.array;

import com.utils.Utils;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = { 1,2,3,4 };
                    // 0 1 2 3
        Utils.prtArr(prodOfArrExptSelf(nums));

    }

    public static int[] prodOfArrExptSelf(int[] nums) {
        int N = nums.length;
        int[] outArray = new int[N];

        outArray[0] = 1;

        for (int i = 1; i < N; i++) {
            outArray[i] = outArray[i-1] * nums[i-1];
        }

        int R = 1;
        for (int i = N-1; i >= 0; i--) {
            outArray[i] = outArray[i] * R;
            R = R * nums[i]; 
        }

        return outArray;
    }

    

}