package com.company;

import java.util.Arrays;

// 螺旋顺时针遍历矩阵填数字
// 注意考虑边界 for 循环 的 i = 0  i<size 深刻理解一下 始终保持左开右闭
public class LC59 {
    public static void main(String[] args) {
        for (int i = 0; i < 0; i++) {
            System.out.println((generateMatrix(3)));
        }

    }

    public static int[][] generateMatrix(int n) {
        int count = 0;
        int[][] result = new int[n][n];
        if (n % 2 != 0) {
            result[n / 2][n / 2] = n * n;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                result[i][j] = ++count;
            }
            for (int j = i; j < n - i - 1; j++) {
                result[j][n - i - 1] = ++count;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[n - i - 1][j] = ++count;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[j][i] = ++count;
            }
        }
        return result;
    }
}
