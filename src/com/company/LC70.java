package com.company;

public class LC70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    //动态规划找到n项和之前的项的关系，划归为之前解决的问题
    public static int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[1]=1;
        dp[2]= 2;
        for (int i=3;i<n+1;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }


        return dp[n];

    }









}
