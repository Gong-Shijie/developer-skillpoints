package com.company;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> result = new ArrayList<>();
       int row = matrix.length;
       int clum= matrix[0].length;
       int n = Math.min(row,clum);
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < clum - i - 1; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i; j < row - i - 1; j++) {
                result.add(matrix[j][row - i - 1]);
            }
            for (int j = row - i - 1; j >= i; j--) {
                result.add(matrix[row - i - 1][j]);
            }
            for (int j = clum - i ; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }
}
