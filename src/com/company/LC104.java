package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class LC104 {
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
        t1.right = t3;
        t2.left = t4;
        System.out.println(maxDepth(t1));
    }

    public static int maxDepth(TreeNode root) {
        ArrayList<Integer> depths  =  new ArrayList<>();
        dfs(depths,0,root);
        Collections.sort(depths);
        return depths.get(depths.size()-1);
    }

    private static  void dfs(ArrayList<Integer> maxDepth,int depth, TreeNode root) {
        if(root==null){
            maxDepth.add(new Integer(depth));
            return;
        }
        depth++;
//        if(root.left!=null)
            dfs(maxDepth,depth,root.left);

//        if(root.right!=null)
            dfs(maxDepth,depth,root.right);

    }

}
