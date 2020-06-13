package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class LC90 {
    public static void main(String[] args) {
        List<List<Integer>> lists = subsets(new int[]{1, 2, 2});
        for (List list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getsub(0, numStack, nums, result);
        result.add(new ArrayList<>());
        return result;
    }

    private static void getsub(int i, Stack<Integer> numStack, int[] nums, List<List<Integer>> result) {
        if (i > nums.length - 1) {
            return;
        }

        numStack.push(nums[i]);
        List list = new ArrayList<>(numStack);
        if(!result.contains(list))
        result.add(list);
        getsub(i + 1, numStack, nums, result);
        numStack.pop();
        getsub(i + 1, numStack, nums, result);

    }
}
