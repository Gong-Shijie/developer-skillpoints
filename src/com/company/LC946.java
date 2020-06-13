package com.company;

import java.util.Stack;

public class LC946 {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> mstack = new Stack<>();
        if (pushed.length == 0)
            return true;
        mstack.push(pushed[0]);
        int ptr = 0;
        int pushPtr = 0;
        while (pushPtr != pushed.length) {
            mstack.push(pushed[pushPtr]);
            while (mstack.peek() == popped[ptr]) {
                mstack.pop();
                ptr++;
            }
            pushPtr++;


        }
        return mstack.isEmpty();

    }

}
