package com.array.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

class FindKthLargest {

    public static void main(String[] args) {

        int arr1[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int arr2[] = { 3, 2, 1, 5, 6, 4 };

        //System.out.println(findKthLargest(arr1, 4));
        System.out.println(findKthLargest2(arr2, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    public static int findKthLargest2(int[] nums, int k) {

        System.out.println(Arrays.toString(nums));
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
           System.out.println("Priority queue: " +pq);
            if (pq.size() > k) {
                pq.poll();
            }
           System.out.println("Priority queue: " +pq);
        }       

        // final PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        // pq2.offer(1);
        // pq2.offer(10);
        // pq2.offer(2);
        // pq2.offer(4);
        // pq2.offer(11);
        // pq2.offer(20);

        // System.out.println("Priority queue: " +pq2);
        // pq2.remove(4);        
        // System.out.println("Priority queue: " +pq2);

        return pq.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}