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
    TreeNode root;

    BinaryTree() {
        root = null;
    }
    
    void printPostorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;        

        printPostorder(TreeNode.left);      
        printPostorder(TreeNode.right);       
        System.out.print(TreeNode.val + " ");
    }
    
    void printInorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;
        
        printInorder(TreeNode.left);        
        System.out.print(TreeNode.val + " ");       
        printInorder(TreeNode.right);
    }

    void printPreorder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;
       
        System.out.print(TreeNode.val + " ");        
        printPreorder(TreeNode.left);        
        printPreorder(TreeNode.right);
    }
    
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
        printTree2D(root, 0);
    }

    static void printTree2D(TreeNode root, int space) {
        int COUNT = 4;      
        if (root == null)
            return;
       
        space += COUNT;       
        printTree2D(root.right, space);
       
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");
       
        printTree2D(root.left, space);
    }

    public static TreeNode createBinaryTree(int[] arr, TreeNode root, int i) {       
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
           
            root.left = createBinaryTree(arr, root.left, 2 * i + 1);          
            root.right = createBinaryTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }
   
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

    public static TreeNode create(int[] arr, TreeNode root, int i) {
        root = createBinaryTree(arr, root, 0);
        print2DTree(root);
        return root;
    }
}
