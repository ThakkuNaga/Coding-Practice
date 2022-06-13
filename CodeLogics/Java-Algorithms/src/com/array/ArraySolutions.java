package com.array;

class ArraySolutions {

    public static void main(String[] args) {
        int[] arr = { 5, 7, 2, 8, 9, 3 };
        secondSmallest(arr);

        // int A[] = { 3, 9, 7, 8, 12, 6, 15, 5, 4, 10 };
        // rotateLeft(A);

        // int nums[] = { 3, 9, 7, 8, 12, 6, 0, 0, 0, 0 };
        // int x = 20, index = 2;
        // insertElement(nums);

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
