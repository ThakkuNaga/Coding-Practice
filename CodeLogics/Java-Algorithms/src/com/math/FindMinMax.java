package com.math;

class FindMinMax {

    public static void main(String[] args) {
        int[] arr = { 20, 10, 20, 4, 100 };

        int min = arr[0];
        int max = min;
        for (int val : arr) {

            if (val > max) {
                max = val;
            }

            if (val < min) {
                min = val;
            }
        }
        System.out.println("Min: " + min + " Max: " + max);
    }

}