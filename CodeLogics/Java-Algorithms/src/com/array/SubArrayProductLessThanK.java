package com.array;

class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 6 };
        int k = 6;
        subArrayProductLessThanK(arr, k);
    }

    public static void subArrayProductLessThanK(int[] arr, int k) {
        
        int cnt = 0;
        int pro = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            pro *= arr[right];   
            while (pro >= k) {
                pro /= arr[left];
                left++;
            }

            cnt += right - left + 1;
        }

        System.out.println(cnt);
    }

}