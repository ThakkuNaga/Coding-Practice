package com.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SameTree {

    public static void main(String[] args) {

        BinaryTree tree1 = new BinaryTree();
        tree1.root = BinaryTree.createBinaryTree(new int[] { 1, 2, 3 }, tree1.root, 0);
        BinaryTree.print2DTree(tree1.root);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = BinaryTree.createBinaryTree(new int[] { 1, 2, 5 }, tree2.root, 0);
        BinaryTree.print2DTree(tree2.root);

        System.out.println(preOrderTraversal(tree1.root));
        System.out.println(preOrderTraversal(tree2.root));

        System.out.println(preOrderTraversal(tree1.root).equals(preOrderTraversal(tree2.root)));

        System.out.println(isSameTreeRecursive(tree1.root,tree2.root));

    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);

            if (root.left != null) {
                helper(root.left, res);
            } else {
                res.add(null);
            }

            if (root.right != null) {
                helper(root.right, res);
            } else {
                res.add(null);
            }
        }
    }

    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeRecursive(p.right, q.right) &&
        isSameTreeRecursive(p.left, q.left);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null)
            return true;
        // one of p and q is null
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (!check(p, q))
            return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q))
                return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left))
                    return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right))
                    return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

}