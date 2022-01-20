package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BT_LevelOrder {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 5, 3, 4, 6, 7 };
        tree.root = BinaryTree.createBinaryTree(arr, tree.root, 0);
        BinaryTree.print2DTree(tree.root);

        levelOrder(tree.root, true); 
    }

    public static void levelOrder(TreeNode root, boolean byLvl) {
        if (root == null)
            return;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.remove();

                System.out.print(x.val + " ");

                if (x.left != null) {
                    queue.add(x.left);
                }
                if (x.right != null) {
                    queue.add(x.right);
                }
            }
            // new level
            if (byLvl)
                System.out.println();
        }

    }

}