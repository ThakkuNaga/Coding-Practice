package com.tree;

import java.util.LinkedList;

class MaxDepth {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 2, 3, 4, 4, 3, 5 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);
        //System.out.println(maxDepthRecursive(tree.root));

        System.out.println(maxDepth(tree.root));
    }

    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepthRecursive(root.left);
            int right_height = maxDepthRecursive(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public static int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;
    
        stack.add(root);
        depths.add(1);
    
        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
          root = stack.pollLast();
          current_depth = depths.pollLast();
          if (root != null) {
            depth = Math.max(depth, current_depth);
            stack.add(root.left);
            stack.add(root.right);
            depths.add(current_depth + 1);
            depths.add(current_depth + 1);
          }
        }
        return depth;
      }
}