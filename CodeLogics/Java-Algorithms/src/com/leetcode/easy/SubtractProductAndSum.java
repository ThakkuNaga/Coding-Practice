package com.leetcode.easy;

class SubtractProductAndSum {
    /*
     * 1281. Subtract the Product and Sum of Digits of an Integer
     * 
     * Given an integer number n, return the difference between the product of its
     * digits and the sum of its digits.
     * 
     * Example 1:
     * 
     * Input: n = 234
     * Output: 15
     * Product of digits = 2 * 3 * 4 = 24
     * Sum of digits = 2 + 3 + 4 = 9
     * Result = 24 - 9 = 15
     * 
     */

    public static void main(String[] args) {
        int n = 234;
        System.out.println(subtractProductAndSum(n));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int prd = 1;

        while (n > 0) {
            int pop = n % 10;
            sum += pop;
            prd *= pop;
            n = n / 10;
        }
        System.out.println("Product " + prd + " sum " + sum);
        return prd - sum;
    }
}