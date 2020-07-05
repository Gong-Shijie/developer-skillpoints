package com.company;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
    private static class TreeNode {
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList();
        return dfs(1, n);
    }

    private static List<TreeNode> dfs(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = dfs(left, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, right);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    result.add(node);
                    node.left = leftTree;
                    node.right = rightTree;
                }
            }
        }
        return result;
    }

}
