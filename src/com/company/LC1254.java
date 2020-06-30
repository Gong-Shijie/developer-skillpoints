package com.company;
// 递归 走出递归的 关键就 在于 递归头的判断然后 return 可以减枝
// 思考 边界问题
public class LC1254 {
    public static void main(String[] args) {
        int [][]grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));

    }
    public static  int closedIsland(int[][] grid) {
        int count = 0 ;
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if(grid[i][j]==0&&dfs(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean dfs(int[][] grid, int i, int j) {
        if((i==0||i==grid.length-1||j==0||j==grid[0].length-1)&&grid[i][j]==0){
            return false;
        }

        if(grid[i][j]==0){
            grid[i][j] = 2;
        }else{
            return true;
        }

        boolean left = dfs(grid,i+1,j);


        boolean right =  dfs(grid,i,j-1);


        boolean up  = dfs(grid,i-1,j);


        boolean down =  dfs(grid,i,j+1);

        return left&&right&&up&&down;

    }
}
