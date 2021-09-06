package com.math;

import com.utils.Utils;

public class PlusOne {
    public static void main(String[] args) {

        int[] digits = { 1, 2, 3 };
        Utils.prtArr(plusOne(digits));
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[n + 1];
        digits[0] = 1;

        return digits;
    }

}