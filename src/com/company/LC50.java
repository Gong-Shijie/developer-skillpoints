package com.company;

// 求 幂
// 快速幂， 递归求  偶次 求 pow1/2 * pow1/2 奇数 求 pow1/2 * pow1/2 * x

public class LC50 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, -3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n>=0?quickPow(x,n):1.0/quickPow(x,n);
    }
    private static double quickPow(double x, int n) {
        if(n ==0){
            return 1.0;
        }
        double res = quickPow(x,n/2);
        return n%2==0?res*res : res*res*x;
    }
}
