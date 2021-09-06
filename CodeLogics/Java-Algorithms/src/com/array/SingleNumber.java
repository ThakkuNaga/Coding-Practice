package com.array;

import java.util.*;
import com.utils.Utils;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        //Utils.prt(findUnique(nums));
        Utils.prt(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {
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

}