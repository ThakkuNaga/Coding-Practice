package com.array.medium;

public class AlmostIncreasingSequence {

    public static void main(String... args) throws Exception {
        int[] a = // { 1, 1, 2, 3, 4, 4 };
                { 3, 6, 5, 8, 10, 20, 15 };
        // { 1, 3, 2 };
        System.out.println(almostIncreasingSequence(a));
    }

    static boolean almostIncreasingSequence(int[] arr) {
        int failed = 0;
        boolean removed;
        for (int i = 0; i < arr.length - 1; i++) {
            int cur = i, next = i + 1;
            if (arr[cur] >= arr[next]) {
                failed++;
                if (cur > 0 && next < arr.length - 1) {
                    // Problem is not on head neither tail
                    // So check if removing one of 2 problematic numbers solves the issue
                    removed = false;
                    if (arr[cur - 1] < arr[next])
                        removed = true;
                    if (arr[cur] < arr[next + 1])
                        removed = true;
                    if (removed == false)
                        return false;
                }

            }
            if (failed > 1)
                return false;
        }
        return true;
    }

    static boolean almostIncreasingSequence2(int[] a) {
        int removed = 0;
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] < a[i + 1]) {
                i++;
                continue;
            } else {
                removed++;
                if (i > 0 && i + 2 < a.length
                        && a[i + 1] <= a[i - 1]
                        && a[i + 2] <= a[i]) {
                    removed++;
                } else {
                    i++;
                }
                if (removed > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean almostIncreasingSequence3(int[] arr) {
        int removed = 0;

        for (int i = 0; i < arr.length - 2 && removed <= 2; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];

            if (a >= b) {
                removed++;
                arr[i] = b - 1;
            }

            if (b >= c) {
                removed++;

                if (a == c) {
                    arr[i + 2] = b + 1;
                } else {
                    arr[i + 1] = a;
                }
            }
        }

        return removed <= 1;
    }

}