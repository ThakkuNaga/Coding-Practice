package com.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_3Sum {

    public static void main(String... args) throws Exception {
        int[] arr1 = { -1, 0, 1, 2, -1, -4 };
        int[] arr2 = { -8, -7, 5, 2 };
        int[] arr3 = {  0, 0, 0 };
        int[] arr4 = { -2, 0, 0, 2, 2};
        System.out.println(threeSum(arr1));
    }

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>(); 

        for (int i = 0; i < num.length-2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int st = i+1, end = num.length-1, sum = 0 - num[i];

                while (st < end) {
                    if (num[st] + num[end] == sum) {
                        res.add(Arrays.asList(num[i], num[st], num[end]));
                        while (st < end && num[st] == num[st+1]) st++;
                        while (st < end && num[end] == num[end-1]) end--;
                        st++; end--;
                    } else if (num[st] + num[end] < sum) {
                        st++;
                    }else{
                        end--;
                    } 
               }
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum2(int[] arr) {

        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            
            int start = i+1;
            int end = arr.length-1;
            int sum = 0-arr[i];

            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }

            while( start < end ){

                if(end < arr.length-1 && arr[end] == arr[end+1]){
                    end--; continue;
                }

                if(arr[start]+arr[end] == sum){
                    result.add(Arrays.asList(arr[i],arr[start],arr[end]));
                    start++; end--;
                }else if(arr[start]+arr[end] < sum){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
           Arrays.sort(nums);
           for (int i = 0; i + 2 < nums.length; i++) {
               if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                   continue;
               }
               int st = i + 1, end = nums.length - 1;  
               int sum = 0-nums[i];
               while (st < end) {
                   if (nums[st] + nums[end] == sum) {
                       res.add(Arrays.asList(nums[i], nums[st], nums[end]));
                       st++; end--;
                       while (st < end && nums[st] == nums[st - 1]) st++;  // skip same result
                       while (st < end && nums[end] == nums[end + 1]) end--;  // skip same result
                   } else if (nums[st] + nums[end] < sum) {
                       st++;
                   } else {
                       end--;
                   }
               }
           }
           return res;   
       }

}