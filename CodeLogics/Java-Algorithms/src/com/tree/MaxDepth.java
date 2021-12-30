package com.tree;

import java.util.LinkedList;
import java.util.Queue;

class MaxDepth { 

  // A binary tree's maximum depth is the number of nodes 
  // along the longest path from the root node down to the farthest leaf node.

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 2, 3, 4, 4, 3, 5 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);

        BinaryTree.print2DTree(tree.root);
        //System.out.println(maxDepthRecursive(tree.root));

        System.out.println("maxDepth  :"+maxDepth(tree.root));
        System.out.println("maxDepth2 :"+maxDepth2(tree.root));
        new MinDepth();
        System.out.println("minDepth3 :"+MinDepth.minDepth3(tree.root));
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

      public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        
        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
        }
        return depth;
    }
}