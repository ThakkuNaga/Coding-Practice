package com.array.medium;

import java.util.Arrays;

class MaxConsecutiveOnesIII {
    /*
     1004. Max Consecutive Ones III
     Given a binary array nums and an integer k, return the maximum number of
     consecutive 1's in the array if you can flip at most k 0's.
     
     nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     Output: 6
     [1,1,1,0,0,1,1,1,1,1,1]
     Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     
     nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     Output: 10
     [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
    */
    public static void main(String[] args) {
        int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(A, k));
        System.out.println(Arrays.toString(A));
    }

    public static int longestOnes(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }

    public static int longestOnes2(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0)
                K--;
            if (K < 0 && A[i++] == 0)
                K++;
        }
        return j - i;
    }
}