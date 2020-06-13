package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class LC114 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        flatten(t1);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void flatten(TreeNode root) {
        TreeNode last = null;
        List<TreeNode> path = new ArrayList<>();
        dfs(path, root, last);
        for (int i = 0; i < path.size()-1; i++) {
            path.get(i).left = null;
            path.get(i).right = path.get(i + 1);
        }
        path.get(path.size()-1).left = null;
        path.get(path.size()-1).right = null;
    }

    public static void dfs(List<TreeNode> path, TreeNode root, TreeNode last) {
        if (root == null) {
            return;
        }
        path.add(root);
        dfs(path, root.left, last);
        dfs(path, root.right, last);

    }

}
