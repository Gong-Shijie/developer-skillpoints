package com.company;

import java.util.ArrayList;
import java.util.List;

//dfs遍历搜索每一层的结果，对每一层都先进行拿情况的搜索，然后又回溯考虑不拿的情况重新进行该层的搜索
//回溯的理解注意虽然回溯但是x还是原来的层，只是换到了下一列进行搜索
public class LC51 {
    public static void main(String[] args) {
        List<List<String>> stringList = solveNQueens(4);
        for(List s :stringList){
            System.out.println(s);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] col = new int[n];
        int[] list = new int[n];
        int[] x1 = new int[2*n+2]; //对角线约束
        int[] x2 = new int[2*n+2];//对角线约束
        List<List<String>> result = new ArrayList<>();
        dfs(0, x1, x2, col, n, result, list);
        return result;
    }

    private static void dfs(int x, int[] x1, int[] x2, int[] col, int n, List<List<String>> result, int[] list) {
        if (x >= n) {
            System.out.println("搜索结束得到结果！");
            result.add(new ArrayList<>(transQ(list)));
            return;
        }
        //按照列搜索所有情况
        for (int i = 0; i <n ; i++) {
            if((col[i]!=1)&&(x1[x-i+n]!=1)&&(x2[i+x]!=1)){
                col[i] = 1;
                x1[x-i+n] = 1;
                x2[x+i] = 1;
                list[x] = i;
                System.out.println("进入"+x+"层进行搜索");
                ;
                dfs(x+1,x1,x2,col,n,result,list);
                //回溯释放访问，会重新在循环中list[]的值会被覆盖不用重置
                System.out.println("回溯到第"+x+"层进行搜索");
                col[i] = 0;
                x1[x-i+n] = 0;
                x2[x+i] = 0;

            }
            System.out.println("所有列都没有合适的位置");
        }
    }


    private static List<String> transQ(int[] list) {
        List<String> oneResult = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            String row = new String();
            for (int j = 0; j < list.length; j++) {
                if (list[i] == j) {
                    row = row + "Q";
                }else
                row = row + ".";
            }

            oneResult.add(row);
        }

        return oneResult;
    }
}
