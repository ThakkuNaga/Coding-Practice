package com.array;

import java.util.*;
import com.utils.Utils;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 2 };
        int[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6 };
        Utils.prtLn(findUnique(nums2));
        Utils.prtLn(singleNumber_HashMap(nums));
    }

    public static int findUnique(int[] nums) {
        Utils.prtArr(nums);
        int ans = 0;

        for (int num : nums) {
            System.out.print(ans + "^" + num + " ");
            System.out.print(Utils.getBin(ans) + "^" + Utils.getBin(num));
            ans = ans ^ num;
            System.out.println(" = " + ans + "(" + Utils.getBin(ans) + ")");
        }
        return ans;
    }

    public static int singleNumber_HashMap(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1)
                return k;
        return -1;
    }

    public static int singleNumber(int[] nums) {
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
        return 2 * sumOfSet - sumOfNums;
    }

}