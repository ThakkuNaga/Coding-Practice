package com.array;

import java.util.HashMap;
import java.util.Map;

class ArraySolutions {

    public static void main(String[] args) {
        int[] arr = { 5, 7, 2, 8, 9, 3 };
        //secondSmallest(arr);

        // int A[] = { 3, 9, 7, 8, 12, 6, 15, 5, 4, 10 };
        // rotateLeft(A);

        // int nums[] = { 3, 9, 7, 8, 12, 6, 0, 0, 0, 0 };
        // int x = 20, index = 2;
        // insertElement(nums);

        int[] target = { 1, 2, 3, 4 };
        int[] arr1 = { 2, 1, 3, 4 };
        //System.out.println(canBeEqual(target, arr1));
        System.out.println(canBeEqual2(target, arr1));

        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        //System.out.println(removeDuplicates(arr2));

    }

    // Method to remove duplicates from an array and return the new length
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            int j;
            for (j = 0; j < count; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == count) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }

    public static boolean canBeEqual2(int[] targetArray, int[] currentArray) {
       
        int[] elementCounts = new int[1001];
        int uniqueCount = 0;
        
        for (int i = 0; i < targetArray.length; i++) {
            if (elementCounts[targetArray[i]]++ == 0) uniqueCount++;
            if (elementCounts[currentArray[i]]-- == 1) uniqueCount--;
        }
        
        return uniqueCount == 0;
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        // Dictionary to maintain frequency count for arr
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        // Dictionary to maintain frequency count for target
        Map<Integer, Integer> targetFreq = new HashMap<>();
        for (int num : target) {
            targetFreq.put(num, targetFreq.getOrDefault(num, 0) + 1);
        }

        System.out.println("arrFreq: " + arrFreq);
        System.out.println("targetFreq: " + targetFreq);
        System.out.println("Distinct elements in arr: " + arrFreq.keySet().size());
        System.out.println("Distinct elements in target: " + targetFreq.keySet().size());

        System.out.println("Distinct elements in arr: " + arrFreq.keySet());
        System.out.println("Distinct elements in target: " + targetFreq.keySet());

        // Number of distinct elements of the 2 arrays are not equal
        if (arrFreq.keySet().size() != targetFreq.keySet().size()) {
            return false;
        }

        for (int num : arrFreq.keySet()) {
            // Frequency for num differs
            if (targetFreq.getOrDefault(num, 0) != arrFreq.get(num)) {
                return false;
            }
        }

        return true;
    }

    public static int secondSmallest(int[] arr) {

        int s1 = arr[0];
        int s2 = s1;

        int l1 = arr[0];
        int l2 = l1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < s1) {
                s2 = s1;
                s1 = arr[i];
            } else if (arr[i] < s2) {
                s2 = arr[i];
            }

            if (arr[i] > l1) {
                l2 = l1;
                l1 = arr[i];
            } else if (arr[i] > l2) {
                l2 = arr[i];
            }
        }

        System.out.println(
                "SmallestNum : " + s1 + "\n2nd SmallestNum: " + s2 + "\nLargestNum: " + l1 + "\n2nd LargestNum: " + l2);

        return s2;

    }

}
