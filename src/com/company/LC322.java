package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class LC322 {
    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        //动态规划  灵活转换状态
        int[] dp = new int[amount + 1];
        int[] temp = new int[coins.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] <= amount) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[amount] < 0 || dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}

