package com.array;

import java.util.Arrays;
import java.util.HashMap;

import com.utils.Utils;

public class Array_Intersection_2 {

    public static void main(String[] args) {
         int[] nums1 = { 4, 9, 5 };
         int[] nums2 = { 9, 4, 9, 8, 4 };

        // int[] nums1 = { 1, 2, 2, 1 };
        // int[] nums2 = { 2, 2 };

        int[] nums = intersect(nums1, nums2);
        Utils.prtArr(nums);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        //System.out.println(m);

        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}