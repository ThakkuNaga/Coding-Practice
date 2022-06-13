package com.math;

import java.util.Arrays;

class FindMedian {

    public static void main(String[] args) {

        // List<Integer> arr = Arrays.asList(5, 4, 3, 1, 2);
        // Collections.sort(arr);
        int[] arr = { 1, 3, 4, 2, 6, 5, 8, 7 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        int mid = len / 2;
        System.out.println("Mid index:" + mid);

        double median;
        if (len % 2 == 0)
            median = ((double) arr[mid] + (double) arr[mid - 1]) / 2;
        else
            median = (double) arr[mid];

        System.out.println("Median is: " + median);

    }

}