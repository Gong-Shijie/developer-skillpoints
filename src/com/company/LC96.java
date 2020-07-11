package com.company;
// 计算所有的 二叉搜索树的个数
// 化归为数学问题  动态规划写 方程
// 动态规划 ： 1.每一个节点怎么求（具体方法）  2. for 循环求出所有的节点
//  以 n 为 根的个数 为 f1 f2 f3 ... f1 = G2G0 f2=G1G1 f3=G2G0
public class LC96 {
    public int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
