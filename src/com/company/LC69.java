package com.company;


//  二分法  寻找一个位于  区间内的数  满足  m*m= x
//  为防止溢出  m*m = x 改写成  m = x / m
public class LC69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static  int mySqrt(int x) {
        if(x == 1 ||x == 0 )
            return x;
        int left=0,right=x;
        int m = (right + left) /2;
        System.out.println(m);
        while(right - left>1){
            m  =  (right + left) /2;
            if(x/m<m){
                right  = m   ;
            }else {
                if(x/m == m)
                    return m ;
                left = m;
            }
        }
        return left;

    }
}
