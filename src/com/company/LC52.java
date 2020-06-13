package com.company;

import java.util.ArrayList;

public class LC52 {

    public static int solveNQueens(int n) {
        int[] col = new int[n];
        int[] x1 = new int[2*n+2]; //对角线约束
        int[] x2 = new int[2*n+2];//对角线约束
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0, x1, x2, col, n, result);
        return result.size();
    }

    private static void dfs(int x, int[] x1, int[] x2, int[] col, int n, ArrayList<Integer> result) {
        if (x >= n) {
            System.out.println("搜索结束得到结果！");
            result.add(new Integer(1));
            return;
        }
        //按照列搜索所有情况
        for (int i = 0; i <n ; i++) {
            if((col[i]!=1)&&(x1[x-i+n]!=1)&&(x2[i+x]!=1)){
                col[i] = 1;
                x1[x-i+n] = 1;
                x2[x+i] = 1;
                System.out.println("进入"+x+"层进行搜索");
                dfs(x+1,x1,x2,col,n,result);
                //回溯释放访问，会重新在循环中list[]的值会被覆盖不用重置
                System.out.println("回溯到第"+x+"层进行搜索");
                col[i] = 0;
                x1[x-i+n] = 0;
                x2[x+i] = 0;

            }
            System.out.println("所有列都没有合适的位置");
        }
    }



}
