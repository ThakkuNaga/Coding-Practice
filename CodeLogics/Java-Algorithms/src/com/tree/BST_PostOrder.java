package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST_PostOrder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 4, 5 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);

        System.out.println(postOrderRecursive(tree.root));
        //System.out.println(postOrderIterative(tree.root));
        //System.out.println(postOrderTraversal(tree.root));
    }

    public static List<Integer> postOrderRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }

            res.add(root.val);
        }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                list.add(0, root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        
        return list;
    }

    public static List<Integer> postOrderIterative(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> S = new Stack<TreeNode>();

        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();

            /*
             * go down the tree in search of a leaf an if so process it and pop stack
             * otherwise move down
             */
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }

                /*
                 * go up the tree from left node, if the child is right push it onto stack
                 * otherwise process parent and pop stack
                 */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }

                /*
                 * go up the tree from right node and after coming back from right node process
                 * parent and pop stack
                 */
            } else if (current.right == prev) {
                S.pop();
                list.add(current.val);
            }

            prev = current;
        }

        return list;
    }
}