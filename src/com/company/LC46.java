package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC46 {
    //指定长度搜索，目的是维护一个长度，如果需要改变长度就需要两次gernerate
//    回溯设置一个vis数组来辅助判断是否访问过某个元素
    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        for (List list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<  Integer>> lists = new ArrayList<>();
        Stack<Integer> myStack = new Stack<>();
        int[] vis = new int[nums.length];
        gernerate(vis,nums, 0, myStack, lists);
        return lists;
    }

    private static void gernerate(int[] vis, int[] nums, int i, Stack<Integer> myStack, List<List<Integer>> lists) {
        if (i >nums.length - 1) {
                lists.add(new ArrayList<>(myStack));

                return;
        }

        for (int j = 0; j <vis.length ; j++) {
            //如果有元素没有搜索过就执行搜索，搜索结束后回溯一个元素，重新搜索
            if(vis[j]!=1){
                myStack.push(nums[j]);
                vis[j]=1;
                gernerate(vis, nums, i + 1, myStack, lists);
                myStack.pop();
                vis[j] =0;
            }
        }

    }
}
