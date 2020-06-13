package com.company;

public class LC112 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        t2.right = t3;
        t1.left = t3;

        System.out.println(hasPathSum(t1, 1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            if (sum == 0)
                return true;
            return false;
        }

        return dfs(0, sum, root);

    }

    private static boolean dfs(int add, int sum, TreeNode root) {

        if (root.left == null && root.right == null) {
            add = add+root.val;
            if (add == sum) {
                return true;
            }
            return false;
        }
        add = add + root.val;
        if (root.left != null && root.right != null)
            return dfs(add, sum, root.left) || dfs(add, sum, root.right);

        if (root.left != null && root.right == null)
            return dfs(add, sum, root.left) ;

        if (root.left == null && root.right != null)
            return dfs(add, sum, root.right) ;
        return false;
    }
}


