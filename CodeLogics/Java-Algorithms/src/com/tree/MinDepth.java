package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    // The minimum depth is the number of nodes along the 
    // shortest path from the root node down to the nearest leaf node.

    public static void main(String... args) throws Exception {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 3, 9, 20, -1, -1, 15, 7 }; 
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);
        BinaryTree.print2DTree(tree.root);
        // System.out.println("minDepth :" + minDepth(tree.root));
        // System.out.println("minDepth2:" + minDepth2(tree.root));
        System.out.println("minDepth3:" + minDepth3(tree.root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int L = minDepth(root.left), R = minDepth(root.right), m = Math.min(L, R);
        return 1 + (m > 0 ? m : Math.max(L, R));
    }

    public static int minDepth3(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
