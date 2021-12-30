package com.array.medium;

import java.util.Arrays;

public class FindMedianSortedArrays {
    /*
     * 4. Median of Two Sorted Arrays
     * 
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * 
     * Ex 1:
     * nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Ex 2:
     * nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     */
    public static void main(String... args) throws Exception {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 4 };
        int[] x = { 1, 3, 8, 9, 15 };
        int[] y = { 7, 11, 18, 19, 21, 25 };
        int[] a = { 23, 26, 31, 35 };
        int[] b = { 3, 5, 7, 9, 11, 16 };
        int[] arr1 = { 2, 3, 5, 8 };
        int[] arr2 = { 10, 12, 14, 16, 18, 20 };
        //System.out.println(findMedianSortedArrays1(nums1,nums2));
        //System.out.println(findMedianSortedArrays1(x,y));
        //System.out.println(findMedianSortedArrays1(arr1, arr2));
        //System.out.println(findMedianSortedArrays3(arr1,arr2));
        System.out.println(findMedianSortedArrays(x,y));
           
    }

    public static double findMedianSortedArrays(int arr1[], int arr2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int x = arr1.length;
        int y = arr2.length;
        System.out.println(Arrays.toString(arr1)+"\n"+Arrays.toString(arr2)); 

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = low + ((high - low) / 2);
            int partitionY = (x + y + 1)/2 - partitionX;
            System.out.println(partitionX+" "+partitionY);

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

            System.out.println(maxLeftX+" "+minRightX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];

            System.out.println(maxLeftY+" "+minRightY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) /2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }


    public static double findMedianSortedArrays1(int[] a1, int[] a2) {

        int m = a1.length;
        int n = a2.length;
        int[] rst = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a1[i] < a2[j]) {
                rst[k] = a1[i];
                i++; k++;
            } else {
                rst[k] = a2[j];
                j++; k++;
            }
        }
        while (i < m)
            rst[k++] = a1[i++];

        while (j < n)
            rst[k++] = a2[j++];

        System.out.println(Arrays.toString(rst));
        int mid = (m + n) / 2;
        System.out.println("mid:" + mid);
        double median;

        if ((m + n) % 2 == 0)
            median = (double) (rst[mid] + rst[mid - 1]) / 2;
        else
            median = rst[mid];

        return median;
    }
    public static double findMedianSortedArrays2(int[] a1, int[] a2) {

        int totLen = a1.length + a2.length;
        int[] rst = new int[totLen];

        for (int i = 0, j = 0; i < rst.length; i++) {
            if (i < a1.length) {
                rst[i] = a1[i];
                continue;
            }
            if (i < rst.length) {
                rst[i] = a2[j++];
            }
        }
        System.out.println(Arrays.toString(rst));
        Arrays.sort(rst);
        int mid = rst.length / 2;
        double median;
        System.out.println(Arrays.toString(rst));
        System.out.println("mid:" + mid);

        if (totLen % 2 == 0)
            median = (double) (rst[mid] + rst[mid - 1]) / 2;
        else
            median = rst[mid];

        return median;
    }
    
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        // Deal with invalid corner case. 
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0.0;
        
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median
        System.out.println(l + " " + r);
        
        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number   
        // and right number that make up a median
        System.out.println(getKth(nums1, 0, nums2, 0, l));
        System.out.println(getKth(nums1, 0, nums2, 0, r));
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    private static double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2
        
        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        
        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
        
        // If k == 1, return the first number. Since nums1 and nums2 is sorted, 
        // the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
        
        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); //nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); //nums1 + nums2.right
        }
    }


}