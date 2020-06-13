package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC236 {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
       TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_ = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_ = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_;
        treeNode4_.left = treeNode5_;
        treeNode4_.right = treeNode1;
        lowestCommonAncestor(treeNode5,treeNode13,treeNode11);
    }
    public static class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        dfs(result,stack,p,q,root);
        if(result.size()==2){
            for (int i = 0; i <result.get(0).size() ; i++) {
                if(result.get(0).get(i)==result.get(1).get(i)){

                }
                return result.get(0).get(i-1);
            }
        }
        if(result.size()==1){
            return result.get(0).get(result.size()-2);
        }
        return null;
    }

    private static void dfs(List<List<TreeNode>> result, Stack<TreeNode> stack, TreeNode p, TreeNode q, TreeNode root) {
   if(root ==null)
       return;
   stack.push(root);
   if(root ==p||root ==q){
       result.add(new ArrayList<>(stack));
       stack.pop();
       return;
   }

   dfs(result, stack, p, q, root.left);
   dfs(result, stack, p, q, root.right);
   stack.pop();
    }
}
