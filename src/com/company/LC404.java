package com.company;

import jdk.dynalink.linker.LinkerServices;

import java.util.LinkedList;
import java.util.Queue;

//求左子树的节点的val值的和
public class LC404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp!=null){
                if(temp.left!=null){
                    result = result +temp.left.val;
                }
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }


        return result;
    }
}
