package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if(root ==null)
            return null;
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode flag = root;
        while(!queue.isEmpty()){
            if(queue.peekFirst().left!=null){
                queue.add(queue.peekFirst().left);
            }
            if(queue.peekFirst().right!=null){
                queue.add(queue.peekFirst().right);
            }

            if(queue.peekFirst()==flag){
                result.add(queue.peekFirst().val);
                flag = queue.peekLast();
            }
            queue.pollFirst();
        }
        return result;
    }
}
