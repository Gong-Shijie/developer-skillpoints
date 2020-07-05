package com.company;

import java.util.*;

// 栈 return 后 还是顺序的 只有手动逆序
// LinkedList api 之 addFirst();addLast() 头插法
// 其实是 Deque 中的 LinkedList是 Deque的实现类 peekFirst peekLast
// LinkedList 可真是个强大的东西
public class LC107 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Deque<List<Integer>> result = new LinkedList<>();
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            while (!nodeQueue.isEmpty()) {
                List<Integer> lineNode = new ArrayList<>();
                int size = nodeQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodeQueue.poll();
                    if (node != null) {
                        nodeQueue.add(node.left);
                        nodeQueue.add(node.right);
                        lineNode.add(node.val);
                    }
                }
                if(lineNode.size()!=0)
                    result.addFirst(lineNode);
            }
            return (List<List<Integer>>) result;
        }
    }
}