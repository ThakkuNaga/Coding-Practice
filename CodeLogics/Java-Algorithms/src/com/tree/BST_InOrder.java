package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST_InOrder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 4, 5 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        System.out.println(inorderRecursive(tree.root));
        System.out.println(inorderIterative(tree.root));
    }

    public static List < Integer > inorderRecursive(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}