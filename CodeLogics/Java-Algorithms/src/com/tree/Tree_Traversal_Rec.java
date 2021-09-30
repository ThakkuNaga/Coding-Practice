package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree_Traversal_Rec {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 5, 3, 4, 6, 7 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        System.out.println(preOrderRecursive(tree.root));
        System.out.println(inOrderRecursive(tree.root));
        System.out.println(postOrderRecursive(tree.root));
    }

    public static List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper1(root, res);
        return res;
    }

    public static void helper1(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null)  { helper1(root.left, res);}
            if (root.right != null) { helper1(root.right, res);}
        }
    }

    public static List < Integer > inOrderRecursive(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper2(root, res);
        return res;
    }

    public static void helper2(TreeNode root, List < Integer > res) {
        if (root != null) {            
            if (root.left != null)  { helper2(root.left, res);}
            res.add(root.val);
            if (root.right != null) { helper2(root.right, res);}
        }
    }

    public static List < Integer > postOrderRecursive(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper3(root, res);
        return res;
    }

    public static void helper3(TreeNode root, List < Integer > res) {
        if (root != null) {            
            if (root.left != null)  { helper3(root.left, res);}
            if (root.right != null) { helper3(root.right, res);}
            res.add(root.val);
        }
    }

    

}