package com.array.easy;

public class MaxProduct {

    public static void main(String... args) throws Exception {
        int[] a = //{ 3, 6, -2, -5, 7, 3 };
                  {-23, 4, -3, 8, -12};
        System.out.println(adjacentElementsProduct(a));
    }

    private static int adjacentElementsProduct(int[] a) {

        int prd = a[0];
        int maxPrd = Integer.MIN_VALUE;

        int j = 1;
        for (int i = 0; i < a.length; i++) {
            if (j > a.length - 1)
                return maxPrd;
            prd = a[i] * a[j++];
            maxPrd = Math.max(prd, maxPrd);
        }

        return -1;
    }

}