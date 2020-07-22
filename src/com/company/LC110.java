package com.company;
// 计算最大高度的同时 进行 高度差的判断
// 最大高度求解模板  和高度相关 都可以在其中增加 逻辑
public class LC110 {
    private boolean result= true;
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        maxHeight(root);
        return result;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int lHeight = maxHeight(root.left);
        int rHeight = maxHeight(root.right);
        if (Math.abs(lHeight - rHeight) > 1) {
            result = false;
            return -1;
        }
        return Math.max(lHeight, rHeight) + 1;

    }
}
