package com.company;

import java.util.Stack;

class MinStack
{//维护最小值的栈  通过让栈顶部始终保持最小值来实现，每次push一个当前值和最小值
    Stack mStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.mStack = new Stack();

    }

    public void push(int x) {
        if(mStack.size()==0){
           mStack.push(x);
           mStack.push(x);
        }else {
            mStack.push(x);
            mStack.push(Math.min((Integer) mStack.peek(),x));

        }

    }

    public void pop() {
        mStack.pop();
        mStack.pop();
    }

    public int top() {
        return (int) mStack.get(mStack.size()-2);
    }

    public int getMin() {
        return (int) mStack.peek();
    }
}
