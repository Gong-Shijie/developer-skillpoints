package com.company;

// 求 最小的 路径 和
//  暴力递归 对 树一样 的结构。 代码模板  当前结果 = Math.min( 递归每一种情况 )
// 暴力  grid[i][j] = grid[][] + Math.min(dfs(grid,i+1,j),dfs(grid,i , j+ 1))
// 动态规划  dp[i][j] = grid[][] + Math.min(dp[i][j+1],dp[i+1][j])
public class LC64 {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }



    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        for (int i = dp.length - 1; i >=0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[grid.length-1][grid[0].length-1];
                } else if (i == grid.length - 1 && j == grid[0].length - 2) {
                    dp[i][j] = grid[grid.length - 1][grid[0].length - 2]+grid[grid.length-1][grid[0].length-1];

                } else if (i == grid.length - 2 && j == grid[0].length - 1) {
                    dp[i][j] = grid[grid.length - 2][grid[0].length - 1]+grid[grid.length-1][grid[0].length-1];

                }else if (i  == dp.length-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }else  if(j == dp[0].length -1 ){
                    dp[i][j] = grid[i][j] + dp[i+1][j];

                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);

                }
            }
        }


        return dp[0][0];

    }

}


