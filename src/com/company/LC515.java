package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 找树的一行中的最大值
// 广度搜索 遍历每一层的方法  while + for 代码模版

public class LC515 {
    private class TreeNode{
        TreeNode left;
        TreeNode right ;
        int val ;
        TreeNode(int _val){this.val = _val;}

    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        int  max= Integer.MIN_VALUE ;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i <queueSize; i++) {
                TreeNode treeNode = queue.poll();
                max = Math.max(max,treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }

            list.add(max);
            max = Integer.MIN_VALUE;
        }
        return list;
    }
}
