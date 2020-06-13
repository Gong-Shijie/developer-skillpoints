package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class LC121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
    //动态规划 状态转移注意每个dp的意义和长度限制
    public static int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1){
            return 0;
        }
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if (min > prices[i])
                min = prices[i];
        }

        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}
