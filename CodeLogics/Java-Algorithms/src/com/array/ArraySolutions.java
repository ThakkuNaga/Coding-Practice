package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.utils.Utils;

class ArraySolutions {

    // RoatateArray
    // removeDuplicates
    // containsDuplicate
    // findUnique
    // InterSect
    // plusOne

    public static void main(String[] args) {

        int k = 9;
        int[] nums = { 2, 7, 11, 15 };
        // int[] nums1 = { 4, 9, 5 };
        // int[] nums2 = { 9, 4, 9, 8, 4 };

        Utils.prtArr(nums);
        // Utils.prtArr(nums1);
        // Utils.prtArr(nums2);

        // rotate(nums, k);
        // removeDuplicates(nums);
        // System.out.println(containsDuplicate(nums));
        // System.out.println(findUnique(nums));
        // Utils.prtArr(intersect(nums1, nums2));
        // Utils.prtArr(plusOne(nums));
        // moveZeroes(nums);

        Utils.prtArr(twoSum(nums, k));
    }

   


    public static void rotate(int[] nums, int k) {
        k %= nums.length; // makes sure that k is less than the length of the array.
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static int removeDuplicates(int[] numss) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int i = 0;
        int k = 1; // Max dups
        for (int n : nums)
            if (i < k || n > nums[i - k])
                nums[i++] = n;
        return i;

        // int i = nums.length > 0 ? 1 : 0;
        // for (int n : nums) {
        // if (n > nums[i - 1]) {
        // nums[i++] = n;
        // }
        // }
        // return i;

        // int i = 0;
        // for (int j = 1; j < nums.length; j++) {
        // if (nums[j] == nums[i]) {
        // continue;
        // }
        // nums[++i] = nums[j];
        // }

        // return i + 1;
    }

    public static boolean containsDuplicate(int[] nums) {

        final HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;

        // Arrays.sort(nums);
        // for(int ind = 1; ind < nums.length; ind++) {
        // if(nums[ind] == nums[ind - 1]) {
        // return true;
        // }
        // }
        // return false;
    }

    // 0 ^ N = N
    // N ^ N = 0

    public static int findUnique(int[] nums) {
        int[] numss = { 4, 1, 2, 1, 2 };
        Utils.prtArr(numss);
        int ans = 0;
        // int len = nums.length;
        for (int num : numss) {
            // ans = ans ^ num;
            System.out.println(ans + "^" + num + " = " + (ans ^= num));
        }

        return ans;

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }

        Utils.prt(map);

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        Utils.prt(map);
        Utils.prt(result);

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int delta = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            delta = target - nums[i];
            if (map.containsKey(delta)) {
                result[0] = map.get(delta);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }

        }
        return result;
    }

}