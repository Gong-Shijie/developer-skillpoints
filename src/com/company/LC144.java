package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
    // 二叉树前序 遍历
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
//        dfs(result, root);
        stackTraverse(result, root);
        return result;
    }

    private void stackTraverse(List<Integer> result, TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right!=null)
                stack.add(cur.right);
            if(cur.left!=null)
                stack.add(cur.left);
        }
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null)
            dfs(result, root.left);
        if (root.right != null)
            dfs(result, root.right);
    }
}
