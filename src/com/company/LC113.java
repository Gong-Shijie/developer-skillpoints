package com.company;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC113 {
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


        List<List<Integer>> re = pathSum(treeNode5,22);
        for(List list:re){
            System.out.println(list);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static  List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(path, result, sum, root);
        return result;
    }

    private static void dfs(Stack<Integer> path, List<List<Integer>> result, int sum, TreeNode root) {
        if (root == null) { // 递归需要结束
            return;
        }

        //执行访问
        sum = sum - root.val;
        path.add(root.val);
        if(sum<0){
            path.pop();
            return;
        }
        //二叉树类型的题，如果是到叶节点结束的话需要加这个
        if (root.left == null && root.right == null) { //叶子节点 也需要结束
            if (sum == 0)  //这里是题目加的限制，在dfs得出路径的条件上加的限制
                result.add(new ArrayList<>(path));
            path.pop(); //  在叶子节点不管有没有搜索到值都要 将搜索结果回退
            return;
        }
        //执行深度搜索  搜索每一种可能，这里只有两种情况
//        可以在这里进行减枝

            dfs(path, result, sum, root.left);

            dfs(path, result, sum, root.right);

        //向下执行搜索结   束，现在舍弃该节点，sum是不需要更改的因为基本数据类型是按值传递
        // 但是像ArraList Stack这些对象则是按照引用传递  需要回退
        path.pop();
    }
}

