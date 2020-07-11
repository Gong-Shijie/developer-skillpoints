package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Stack stack = new Stack();
        dfs(result, stack, n, k, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, Stack stack, int n, int k, int i) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            stack.clear();
        }
        for (int j = i + 1; j <= n; j++) {
            stack.push(j);
            dfs(result, stack, n, k, j + 1);
            stack.pop();
        }
    }
}
