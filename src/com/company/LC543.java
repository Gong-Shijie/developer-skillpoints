package com.company;

public class LC543 {
    int length= 0  ;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfsLength(root);
        return length;
    }

    private int dfsLength(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        int lHeight = dfsLength(root.left);
        int rHeight = dfsLength(root.right);
        length = Math.max(length,lHeight+rHeight);
        return Math.max(lHeight,rHeight)+1;
    }
}
