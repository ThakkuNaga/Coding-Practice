package com.main;

class Binary_Tree_Solution {
    /*
     * A complete binary tree is a binary tree that each level except possibiliy the
     * last level,
     * is completed filled. Suppose you are giving a binary tree represented as an
     * array.
     * 
     * For example, [3, 6, 2, 9, -1, 10] retpresents the following binary tree,
     * where -1 indicates it is a NULL node.
     * 
     * 3
     * / \
     * 6 2
     * / /
     * 9 10
     * 
     * 1
     * / \
     * 10 5
     * / \ /
     * 1 0 6
     * 
     * 
     */

    public static void main(String[] args) {
        int[] arr = { 3, 6, 2, 9, -1, 10 };
        // { 1, 10, 5, 1, 0, 6 };
        System.out.println(solution(arr));
    }

    public static String solution(int[] arr) {

        if (arr == null || arr.length <= 1)
            return "";
        int leftSum = 0;
        int rightSum = 0;

        int left = 1;
        int right = 2;

        // we need two loops here
        // one for left and one for right
        // we keep track of the left and right sums separately

        leftSum = getTreeSum(arr, left);
        rightSum = getTreeSum(arr, right);

        System.out.println("leftSum:" + leftSum + "  RightSum:" + rightSum);

        if (leftSum > rightSum)
            return "Left";
        else if (leftSum < rightSum)
            return "Right";
        return "";

    }

    public static int getTreeSum(int arr[], int i) {
        if (i > arr.length - 1 || arr[i] == -1)
            return 0;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int sum = 0;
        if (i < arr.length) {
            sum = arr[i] + getTreeSum(arr, leftChild) + getTreeSum(arr, rightChild);
        }
        return sum;
    }
}
