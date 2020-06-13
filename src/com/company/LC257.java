package com.company;

import java.util.ArrayList;
import java.util.List;

//二叉树所有路径和
//标准dfs模板
//判断叶子节点只需要在root==null后加条件即可
public class LC257 {
    public List<String> binaryTreePaths(LC100.TreeNode root) {
        List<String> list = new ArrayList<>();
        String temp = "";
        dfs(root,temp,list);
        return list;
    }
    public static void dfs(LC100.TreeNode root,String temp,List<String> lsit){
        if(root==null){
            return ;
        }
        temp = temp +root.val+"->";
        if(root.left==null&&root.right==null){
            lsit.add(temp.substring(0,temp.length()-2));
            temp = "";
            return;
        }

        dfs(root.left,temp,lsit);
        dfs(root.right,temp,lsit);}
}
