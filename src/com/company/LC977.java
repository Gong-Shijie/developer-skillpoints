package com.company;

import java.util.Arrays;
//求数组的平方后的数组 按序排列
//双指针做  涉及到正负排序都可以使用.
public class LC977 {
    public static void main(String[] args) {

    }
    public int[] sortedSquares1(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {

            result[i] = A[i]*A[i];
        }
        Arrays.sort(result);
        return result;

    }
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        int i = 0,j = length-1,r = length-1;
        while(i<=j){
            if(Math.abs(A[i])>Math.abs(A[j])){
                result[r] = A[i] * A[i];
                i++;
                r++;
            }else {
                result[r] = A[j] *A[j];
                j--;
                r++;
            }

        }
        return result;
    }
}
