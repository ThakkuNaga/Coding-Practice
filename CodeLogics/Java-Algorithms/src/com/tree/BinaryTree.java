package com.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    // Root of Binary Tree
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    /*
     * Given a binary tree, print its TreeNodes according to the "bottom-up"
     * postorder traversal.
     */
    void printPostorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;

        // first recur on left subtree
        printPostorder(TreeNode.left);

        // then recur on right subtree
        printPostorder(TreeNode.right);

        // now deal with the TreeNode
        System.out.print(TreeNode.val + " ");
    }

    /* Given a binary tree, print its TreeNodes in inorder */
    void printInorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;

        /* first recur on left child */
        printInorder(TreeNode.left);

        /* then print the data of TreeNode */
        System.out.print(TreeNode.val + " ");

        /* now recur on right child */
        printInorder(TreeNode.right);
    }

    /* Given a binary tree, print its TreeNodes in preorder */
    void printPreorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;

        /* first print data of TreeNode */
        System.out.print(TreeNode.val + " ");

        /* then recur on left sutree */
        printPreorder(TreeNode.left);

        /* now recur on right subtree */
        printPreorder(TreeNode.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    static void print2DTree(TreeNode root) {
        // Pass initial space count as 0
        printTree2D(root, 0);
    }

    static void printTree2D(TreeNode root, int space) {
        int COUNT = 4;
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        printTree2D(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        printTree2D(root.left, space);
    }

    public static TreeNode createBinaryTree(int[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = createBinaryTree(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = createBinaryTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Driver method
    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree();
        // tree.root = new TreeNode(1);
        // tree.root.left = new TreeNode(2);
        // tree.root.right = new TreeNode(3);
        // tree.root.right.left = new TreeNode(4);
        // tree.root.right.right = new TreeNode(5);
        // tree.root.left.left = new TreeNode(4);
        // tree.root.left.right = new TreeNode(5);

        BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        tree.root = createBinaryTree(arr, tree.root, 0);

        print2DTree(tree.root);
        
        // System.out.println("Preorder traversal of binary tree is ");
        // tree.printPreorder();

        // System.out.println("\nInorder traversal of binary tree is ");
        // tree.printInorder();

        // System.out.println("\nPostorder traversal of binary tree is ");
        // tree.printPostorder();
    }
}
