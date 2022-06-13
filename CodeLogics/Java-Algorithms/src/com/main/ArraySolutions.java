package com.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ArraySolutions {
    public static void main(String[] args) {

        String s = "dog";
        countOfChars(s);

        int[] nums = { 1, 2, 3, 4 };
        System.out.println(containsDuplicate(nums));

        int arr[] = { 2, 7, 11, 15 }, target = 26;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {

            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                res[0] = map.get(comp);
                res[1] = i;
            }
            map.put(arr[i], i);
        }
        System.out.println(map);

        return res;
    }

    private static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    private static void countOfChars(String s) {
        int nonACount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'A') {
                ++nonACount;
            }
        }
        // Get the count of a's in the string
        int aCount = s.length() - nonACount;
        System.out.println(
                (nonACount * 2 + 2) - aCount);
    }

}