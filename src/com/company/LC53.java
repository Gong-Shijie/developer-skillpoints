package com.company;

public class LC53 {

    public static void main(String[] args) {
        int[] test = {8,-19,5,-4,20};
        System.out.println(maxSubArray(test));
    }


    public static  int maxSubArray(int[] nums) {
        //思路是 找到以某个元素结尾的元素为 dp
        int [] dp = new int[nums.length];
        int maxValue;
        if(nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        dp[0] =maxValue =  nums[0];

        for(int i = 0;i<nums.length;i++)
        {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            if(dp[i]>maxValue){
                maxValue = dp[i];
            }
        }
          return maxValue;
    }
















}
