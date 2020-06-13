package com.company;

import jdk.dynalink.linker.LinkerServices;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LC225{

}
class MyStack {
    Deque<Integer> mqueue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.mqueue = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        mqueue.push(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return mqueue.size()!=0?mqueue.peekLast():0;
    }

    /** Get the top element. */
    public int top() {
        return mqueue.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mqueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */