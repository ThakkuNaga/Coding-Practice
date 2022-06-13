package com.array;

import java.util.*;
import com.utils.Utils;

public class SingleNumber {

    // 136. Single Number
    // Every element appears twice except for one. Find that single one.

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 }; // 2,2,1
        Utils.prtLn(findUnique(nums));
        Utils.prtLn(findUnique2(nums));
        Utils.prtLn(findUnique3(nums));
    }

    public static int findUnique(int[] nums) {
        Utils.prtArr(nums);
        int ans = 0;

        for (int num : nums) {
            // System.out.print(ans + "^" + num + " ");
            // System.out.print(Utils.getBin(ans) + "^" + Utils.getBin(num));
            ans = ans ^ num;
            // System.out.println(" = " + ans + "(" + Utils.getBin(ans) + ")");
        }
        return ans;
    }

    public static int findUnique2(int[] nums) {
        System.out.println();
        Utils.prtArr(nums);
        int sumOfSet = 0, sumOfNums = 0;

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        System.out.println("set " + sumOfSet + " arr " + sumOfNums);
        return 2 * sumOfSet - sumOfNums;
    }

    public static int findUnique3(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        System.out.println("map " + hashmap);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1)
                return k;
        return -1;
    }

}