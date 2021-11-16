package com.array;

import com.utils.Utils;

public class ProductOfArrayExceptSelf {

    // Product of Array Except Self
    // Given an integer array nums, return an array answer such that answer[i] is
    // equal to the product of all the elements of nums except nums[i].

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 5 };
        Utils.prtArr(productExceptSelf(nums));
    }
    /*
    Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array
    except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. 
    The product is left*right. We can get lefts and rights:
    
    Numbers:     2    3    4     5
    Lefts:       1    2  2*3 2*3*4
    Rights:  3*4*5  4*5    5     1
    */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        Utils.prtArr(res);
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        res[0] = 1;

        for (int i = 1; i < N; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }       

        int right = 1;
        for (int i = N - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

}