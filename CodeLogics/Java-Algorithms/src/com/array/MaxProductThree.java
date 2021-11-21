package com.array;

import com.utils.Utils;

class MaxProductThree {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4 };
        Utils.prt(maxProduct(arr));
    }

    // find the three largest numbers and two smallest numbers using
    public static int maxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE; 
        int max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : arr) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        System.out.printf("%s %s %s %s %s %s",max1,max2,max3,min1,min2);
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);

    }

}