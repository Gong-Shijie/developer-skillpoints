package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temp = new int[n];
        int[] visit = new int[n];
        List<int[]> allResult = new ArrayList<>();
        dfs(0, visit, allResult, n, temp);
        int[] vis = new int[n];
        List<int[]> result = new ArrayList<>();
        String template = "";
        for (int i = 0; i < n; i++) {
            template = template +(i+1);
        }
        for (int i = 0; i < allResult.size(); i++) {
            dfsresult(i, result, allResult);
        }
        for (int i = 0; i < result.get(0).length; i++) {
            System.out.print(result.get(0)[i]+" ");
            
        }

    }

    private static void dfsresult(int x, List<int[]> result, List<int[]> allResult) {

    }

    private static void dfs(int x, int[] vis, List<int[]> allResult, int n, int[] temp) {

        if (x >= n) {
            allResult.add(temp);
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;
                temp[x] = i + 1;
                dfs(x + 1, vis, allResult, n, temp);
                vis[i] = 0;
            }
        }

    }

}
