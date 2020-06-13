package com.company;

public class LC200 {

    public int numIslands(char[][] grid) {
        int[] x =new int[]{0,0,1,-1};
        int[] y =new int[]{1,-1,0,0};
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    dfs(grid,i,j,x,y);
                    result++;
                }
            }
        }
        
        
        
        return result;
    }

    private void dfs(char[][] grid, int i, int j, int[] x, int[] y) {
        if (grid[i][j]=='2'||grid[i][j]=='0'||i>(grid[0].length-1)||j>(grid.length-1)||i<0||j<0){
            return;
        }
        grid[i][j] ='2';
        for (int k = 0; k < x.length; k++) {
            dfs(grid,i+x[k],j+y[k],x,y);
        }
    }
}
