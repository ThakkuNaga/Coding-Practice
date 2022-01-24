package com.array;

import com.utils.Utils;

public class SingleNumberIII {
    
    //260. Single Number III
    // Given an integer array nums, in which exactly two elements appear only once
    // and all the other elements appear exactly twice. 
    // Find the two elements that appear only once. 
    // You can return the answer in any order.

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 5, 2 };
        Utils.prtArr(singleNumber(nums));
        Utils.prtArr(singleNumberIII(nums));
    }

    public static int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static int[] singleNumberIII(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int aXORb = 0;
        for (int n : nums) {
            aXORb ^= n;
        }

        int rightSetBit = aXORb & -aXORb;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] { a, aXORb ^ a };
    }

    /*Two-Pass Solution | Bit Manipulation using XOR
    The idea is to use XOR to remove all numbers that appear exactly twice. Thus, in the first pass, we will XOR all nums in the input array. We will be left with XOR (aXORb) of two numbers that appear exactly once. (Let's call these numbers A and B.)

    In XOR, a bit is set in the result if both bits at the same locations are different.
    Now find the rightmost set bit in aXORb. This will give us the rightmost bit that is different in A & B.

    We can now go through all numbers in input array again (second pass) and XOR the numbers that have this bit set to 1. This will give us the first number A.
    To get the second number perform aXORb ^ A.

    Example

    Let us use this input: nums = [1,2,1,3,2,5]
    Since we will need the binary representation of each of these numbers, I have converted them here for simplicity [0x001, 0x010, 0x001, 0x011, 0x010, 0x101]

    Now perform XOR each of these numbers:
    aXORb = 1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5 = 0x110

    In this aXORb rightmost set bit can be found by aXORb & -aXORb which will give us:
    rightSetBit = 0x010;

    In the second pass, we try to XOR all numbers that have this bit set to 1. There are total three such numbers: [2, 2, 3]. XOR of these numbers should give us 3. This can be assigned to A. To get B we can perform XOR of A and aXORb. In this example, aXORb ^ A = 0x110 ^ 0x011 = 0x101 (which is 5 in decimal).

    Thus the output result is [3,5].

    Time Complexity: O(2 * N) = O(N) --> Each number in the input array is visited twice.

    Space Complexity: O(1) --> Uses constant auxiliary space.
    */

}