package com.company;

import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {//判断是否可以pop
                if(isPair(stack.peek(),s.charAt(i))){
                    stack.pop();
            }else {
                    stack.push(s.charAt(i));
                }
        }

    }
        return stack.isEmpty();

    }
    private static  boolean isPair(char l, char r) {
        return l=='('&&r==')'||l=='{'&&r=='}'||l=='['&&r==']';
    }
}
