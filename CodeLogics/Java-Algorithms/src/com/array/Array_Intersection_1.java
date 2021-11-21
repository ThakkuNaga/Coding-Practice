package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.utils.Utils;

public class Array_Intersection_1 {

  public static void main(String[] args) {
    int[] nums1 = { 4, 9, 5 };
    int[] nums2 = { 9, 4, 9, 8, 4 };
    int[] nums = intersection(nums1, nums2);
    Utils.prtArr(nums);
  }

  public static int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersect = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
        set.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
        if (set.contains(nums2[i])) {
            intersect.add(nums2[i]);
        }
    }
    int[] result = new int[intersect.size()];
    int i = 0;
    for (int num : intersect) {
        result[i++] = num;
    }
    return result;
}

  public static int[] intersection1(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] result = new int[set1.size()];
    int i = 0;
    for (int num : set1) 
      result[i++] = num;
    return result;
  }


  public static int[] intersection2(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1)
      set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2)
      set2.add(n);

    if (set1.size() < set2.size())
      return set_intersection(set1, set2);
    else
      return set_intersection(set2, set1);
  }

  public static int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
    int[] output = new int[set1.size()];
    int idx = 0;
    for (Integer s : set1)
      if (set2.contains(s))
        output[idx++] = s;

    return Arrays.copyOf(output, idx);
  }
}