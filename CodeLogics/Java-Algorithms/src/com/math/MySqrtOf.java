package com.math;

public class MySqrtOf {

    public static void main(String... args) throws Exception {
        int x = 81;
        System.out.println(sqrt_Newton(x));
        System.out.println(sqrt_BinarySearch(x));
    }

    public static int sqrt_Newton(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static int sqrt_BinarySearch(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;

    }

}