package com.company;

public class LC905 {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            while (A[l] % 2 != 0) {
                l++;
            }
            while (A[r] % 2 == 0) {
                r++;
            }
            swap(A, l, r);
        }
        return A;
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
