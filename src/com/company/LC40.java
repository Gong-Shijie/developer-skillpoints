package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC40 {
    //剪枝   回溯时候根据条件减枝
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Stack<Integer> numStack = new Stack<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getsub(0, numStack, candidates, result,0,target);

        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{10, 1,2,7,6,1 ,5},8);
        for (List list : lists) {
            System.out.println(list);
        }
    }



    private static void getsub(int i, Stack<Integer> numStack, int[] nums, List<List<Integer>> result, int sum, int target) {
        if (i > nums.length - 1) {
            return;
        }
        sum = sum +nums[i];
        if(sum >target){
            return;
        }
        numStack.push(nums[i]);
        if(sum == target){
            List list = new ArrayList<>(numStack);
            if(!result.contains(list))
                result.add(list);
        }
        getsub(i + 1, numStack, nums, result,sum,target);
        numStack.pop();
        getsub(i + 1, numStack, nums, result,sum-nums[i],target);

    }
}
