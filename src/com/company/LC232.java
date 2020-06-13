package com.company;

import java.util.Stack;

public class LC232 {

}
class MyQueue {
    Stack<Integer> mstack  ;
    Stack<Integer> tempStack  ;


    /** Initialize your data structure here. */
    public MyQueue() {
        this.mstack = new Stack<>();
        this.tempStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        while(!mstack.isEmpty()){
            tempStack.push(mstack.pop());
        }
        mstack.push(x);
        while(!tempStack.isEmpty()){
            mstack.push(tempStack.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return mstack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return mstack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mstack.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */