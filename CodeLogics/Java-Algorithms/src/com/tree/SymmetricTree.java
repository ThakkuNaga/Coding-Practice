package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 2, 3, 4, 4, 3 };        
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        System.out.println(isSymmetricRecursive(tree.root));
        //System.out.println(isSymmetricIterative(tree.root));
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public static boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}