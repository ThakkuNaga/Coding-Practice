package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] arr1 = { 4, 9, 5 }, arr2 = { 9, 4, 9, 8, 4 };
        int[] arr3 = intersectionOfArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    public static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        boolean[] num1p = new boolean[10];
        boolean[] num2p = new boolean[10];
        int count = 0;

        for (int num1v : nums1)
            num1p[num1v] = true;

        System.out.println(Arrays.toString(num1p));
        for (int num2v : nums2) {
            System.out.println(!num2p[num2v] +" "+ num1p[num2v]);
            if (!num2p[num2v] && num1p[num2v]) {
                num2p[num2v] = true;
                nums1[count] = num2v;
                count++;
            }
        }
        System.out.println(Arrays.toString(num2p));

        int[] result = new int[count];
        for (int i = 0; i < count; i++)
            result[i] = nums1[i];
        return result;
    }

    private static int[] intersectionOfArrays2(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int n : arr1)
            set.add(n);
        System.out.println(set);
        for (int n : arr2)
            if (set.contains(n)) {
                intersect.add(n);
            }
        System.out.println(intersect);

        return result;
    }

}
