package com.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BT_PreOrder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 5, 3, 4, 6, 7 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        // System.out.println(preOrderRecursive(tree.root));
        // System.out.println(preorderIterative(tree.root));
        // System.out.println(preorderTraversal(tree.root));
        System.out.println(preorderTraversal1(tree.root));
    }

    public static List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // instance of Stack is thread safe (lock/synchronize inside),
        // so Dequeue should be faster.
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null)  stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
        return result;
    }

    public static List<Integer> preorderIterative(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();

        // Start from root TreeNode (set curr
        // node to root node)
        TreeNode curr = node;

        // Run till stack is not empty or
        // current is not NULL
        while (curr != null || !st.isEmpty()) {

            // Print left children while exist
            // and keep pushing right into the
            // stack.
            while (curr != null) {
                list.add(curr.val);

                if (curr.right != null)
                    st.push(curr.right);

                curr = curr.left;
            }

            // We reach when curr is NULL, so We
            // take out a right child from stack
            if (!st.isEmpty()) {
                curr = st.pop();
            }
        }
        return list;
    }

}