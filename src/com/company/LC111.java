package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class LC111 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;


        System.out.println(minDepth(t1));
    }

    public static int minDepth(TreeNode root) {
        ArrayList<Integer> depths  =  new ArrayList<>();
        if(root==null)
            return 0;
        dfs(depths,0,root);
        Collections.sort(depths);
        return depths.get(0);
    }

    private static  void dfs(ArrayList<Integer> maxDepth,int depth, TreeNode root) {
        if(root.left==null&&root.right==null){
            maxDepth.add(new Integer(depth)+1);
            return;
        }
        depth++;
        if(root.left!=null)
        dfs(maxDepth,depth,root.left);

        if(root.right!=null)
        dfs(maxDepth,depth,root.right);

    }

}
