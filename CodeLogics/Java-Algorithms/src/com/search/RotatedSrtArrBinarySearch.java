package com.search;

import java.util.Arrays;

import com.utils.Utils;

/* Java program to search an element
in a sorted and pivoted array*/

class RotatedSrtArrBinarySearch {

	// main function
	public static void main(String args[]) {
		//int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int arr[] = { 9, 12, 15, 17, 25, 28, 32, 37, 3, 5, 7, 8 };
                  //  0  1   2   3   4   5   6   7   8  9  10 11   
        int n = arr.length;
        int key = 17;
        //System.out.println(search(arr, 0, n - 1, key));
        Utils.prtArr(arr);        
        System.out.println(findElement(arr,n,key));
	}
	private static int findElement(int[] arr,int n, int key) {
        int rst = -1;

        int pivot = findPivot(0, n - 1, arr);
        System.out.println("pivot:"+pivot);
        
        if(key > arr[pivot] && key < arr[n-1]){
            rst = Arrays.binarySearch(arr, pivot, n-1, key);
        }else{
            rst = Arrays.binarySearch(arr, 0, pivot-1, key);
        }
        
        return rst;
    }

    private static int findPivot(int s, int e, int[] arr) { 
        int pivot=-1;
        int m = s + (e-s)/2;

        if(arr[m] > arr[m+1]){
            pivot = m+1;
        }else{
            if(arr[s] > arr[m]){
                pivot = findPivot(s, m-1, arr);
            }else{
                pivot = findPivot(m+1, e, arr);
            }
        }

        return pivot;
    }

    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
 
        int mid = l + (h - l) / 2; 
        if (arr[mid] == key)
            return mid;
 
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
 
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
 
        return search(arr, l, mid - 1, key);
    }

}
