package com.interviews;

import java.util.Arrays;

class HeightChecker {

    // 1051. Height Checker

    public static void main(String[] args) {
        int[] a1 = { 1, 1, 4, 2, 1, 3 }; // 3
        System.out.println(heightChecker(a1));

        int[] a2 = { 5, 1, 2, 3, 4 }; // 5
        System.out.println(heightChecker(a2));

        int[] a3 = { 1, 2, 3, 4, 5 }; // 0
        System.out.println(heightChecker(a3));
    }

    public static int heightChecker2(int[] heights) {
        // countSort
        int mismatchCount = 0;
        int currentHeight = 0;

        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[currentHeight] == 0) {
                currentHeight++;
            }

            if (currentHeight != heights[i]) {
                mismatchCount++;
            }
            heightToFreq[currentHeight]--;
        }

        return mismatchCount;

    }

    public int heightChecker1(int[] heights) {
        int[] copy = new int[heights.length];
        int minMoves = 0;

        for (int i = 0; i < heights.length; i++) {
            copy[i] = heights[i];
        }

        Arrays.sort(copy);

        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i])
                minMoves++;
        }

        return minMoves;
    }

    public static int heightChecker(int[] arr) {
        if (arr.length == 0) return 0;
        int rst = 0;
        
        int[] a = arr.clone();
        // System.out.println(Arrays.toString(a));

        // bubble sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    // rst++;
                    // System.out.println("i :"+i+" j:"+j+" Result--> "+rst);
                }
            }
        }

        // System.out.println(Arrays.toString(b));

        int p = 0;
        for (int k : arr) {
            if (a[p++] != k)
                rst++;
        }

        // System.out.println("Result--> "+rst);

        return rst;
    }
}