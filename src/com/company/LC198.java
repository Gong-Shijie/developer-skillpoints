package com.company;

public class LC198 {
    public static void main(String[] args) {
        int [] ints = {1,2,3,1};
        System.out.println(rob(ints));
    }

    //思考只思考现在i和i之前，思考i会影响之前的哪些项总之寻找i
    public static  int rob(int[] nums) {

        int[] dp = new int[nums.length+2];
        if(nums.length==0){
            return 0;
        }
        dp[0] = nums[0];
        if(nums.length<2){
            return dp[nums.length-1];
        }
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        return dp[nums.length-1];
    }
}
