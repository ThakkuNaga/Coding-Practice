package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BTree_Traversal_Rec {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 5, 3, 4, 6, 7 };
        tree.root = BinaryTree.create(arr, tree.root, 0);
                
        System.out.println(preOrder(tree.root, new ArrayList<>()));       
        System.out.println(inOrder(tree.root, new ArrayList<>()));        
        System.out.println(postOrder(tree.root, new ArrayList<>()));
    }

    public static List<Integer> preOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null)
                preOrder(root.left, res);
            if (root.right != null)
                preOrder(root.right, res);
        }
        return res;
    }

    public static List<Integer> inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                inOrder(root.left, res);
            res.add(root.val);
            if (root.right != null)
                inOrder(root.right, res);
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                postOrder(root.left, res);
            if (root.right != null)
                postOrder(root.right, res);
            res.add(root.val);
        }
        return res;
    }

    

}