package com.array;

import com.utils.Utils;

class MaxSubArrayProduct {
    public static void main(String[] args) {
        int[] arr = { -2, 3, -4 }; 
        int n = arr.length;
        Utils.prt(maxProduct(arr));
        subArrayCount(arr, n);
    }

    public static int maxProduct(int[] arr) {
        int prod = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            prod = prod * arr[i];
            result = Math.max(prod, result);
            if (prod == 0) {
                prod = 1;
            }
        }
        prod = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            prod = prod * arr[i];
            result = Math.max(prod, result);
            if (prod == 0) {
                prod = 1;
            }
        }
        return result;
    }

    public static void subArrayCount(int[] arr, int n) {

        int max = arr[0], min = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * arr[i], min * arr[i]), arr[i]);
            min = Math.min(Math.min(temp * arr[i], min * arr[i]), arr[i]);
            if (max > result) {
                result = max;
            }
        }
        System.out.println(result);
    }

}