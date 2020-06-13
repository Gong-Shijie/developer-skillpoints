package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LC100 {
    //递归结束的条件是现在进入递归搜索的是空树比较方便
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(2);


        TreeNode t2 = new TreeNode(1);
        t2.right = t3;
        t1.left = t3;

        System.out.println(isSameTree(t2, t1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
                return true;
        }
        if(!((q!=null)&&(p!=null)))
            return false;
        if(p.val!=q.val)
            return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
