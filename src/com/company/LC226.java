package com.company;

import com.sun.source.tree.Tree;


import java.util.LinkedList;
import java.util.Queue;


//二叉树的翻转  注意写bfs和dfs遍历的时候 尽量不要写具体判断其是否是叶子节点
//只需要看它是否是空就行了，不是空肯定有左和右当是左和右为null 不处理就可以了
public class LC226 {
    public LC100.TreeNode invertTree(LC100.TreeNode root) {
        Queue<LC100.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LC100.TreeNode temp = queue.poll();
            if (temp != null) {
                swap(temp);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return root;
    }

    private void swap(LC100.TreeNode root) {
        LC100.TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
