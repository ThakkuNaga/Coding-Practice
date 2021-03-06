package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

    // Given the root of a binary tree, check whether it is a mirror of itself 
    // (i.e., symmetric around its center).

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 2, 3, 4, 4, 3 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        System.out.println(isSymmetricRec(tree.root));
        System.out.println(isSymmetricItr(tree.root));
        System.out.println(isSymmetric(tree.root));
    }

    public static boolean isSymmetricRec(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null)
            return true;
        if (T1 == null || T2 == null)
            return false;
        return (T1.val == T2.val) &&
                isMirror(T1.left, T2.right) &&
                isMirror(T1.right, T2.left);
    }

    public static boolean isSymmetricItr(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

}