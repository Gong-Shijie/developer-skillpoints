package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//广度遍历 队列的方式，然后需要用到双向队列
//递归实现也可以
public class LC559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth2(Node root) {
        Deque<Node> queue = new LinkedList<>();
        int depth = 0;
        Node temp = root;
        queue.add(root);
        while(!queue.isEmpty()){
            Node poll  = queue.poll();
            if(poll!=null){
                if(poll==temp){
                    depth++;
                    for (int i = 0; i < poll.children.size(); i++) {
                        queue.add(poll.children.get(i));
                    }
                    temp = queue.peekLast();
                }else{
                    for (int i = 0; i < poll.children.size(); i++) {
                        queue.add(poll.children.get(i));
                    }
                }
            }
        }

        return depth;
    }
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(maxDepth(root.children.get(i)),depth);
        }
        return depth+1;
    }
}
