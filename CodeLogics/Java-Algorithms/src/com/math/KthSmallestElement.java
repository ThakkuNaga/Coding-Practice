package com.math;

class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        int first = arr[0], second = first, third = first;
        for (int val : arr) {

            if (val > first) {
                third = second;
                second = first;
                first = val;
            } else if (val > second) {
                third = second;
                second = val;
            } else if (val > third) {
                third = val;
            }
        }
        // System.out.println("First: " + first + "\nSecond: " + second + "\nThird: " +
        // third);
        System.out.printf("%s %s %s", first, second, third);
    }

}