package com.company;

import java.sql.ClientInfoStatus;
import java.util.*;


public class LC102 {
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
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        System.out.println(levelOrder(t1));
    }
    public static  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Boolean flag =false;

        if (root==null)
            return new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode temp = queue.peekLast();
            while(queue.peek()!= temp){
                if (flag){
                    if(queue.peek().left!=null)
                        queue.add(queue.peek().left);
                    if(queue.peek().right!=null)
                        queue.add(queue.peek().right);
                    list.add(queue.poll().val);
                }
                else {
                    if(queue.peek().left!=null)
                        queue.addLast(queue.peek().left);
                    if(queue.peek().right!=null)
                        queue.addLast(queue.peek().right);
                    list.add(queue.poll().val);
                }

            }
            list.add(queue.peek().val);
            lists.add(list);
           if(flag){

               if(queue.peek().left!=null)
                   queue.add(queue.peek().left);
               if(queue.peek().right!=null)
                   queue.add(queue.peek().right);
           }else {

               if(queue.peek().left!=null)
                   queue.add(queue.peek().left);
               if(queue.peek().right!=null)
                   queue.add(queue.peek().right);

           }queue.pollFirst();
flag = !flag;
        }
        return lists;


    }
}