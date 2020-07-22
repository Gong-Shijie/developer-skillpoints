package com.company;

public class LC633 {
    public boolean judgeSquareSum(int c) {
        boolean result = false;
        int l = 0, r = (int)Math.sqrt(c);
        while(l<=r){
           int sum =  l*l + r*r;
            if(c ==sum){
                return true;
            }
            if(c<sum){
                r--;
            }
            if(c>sum){
                l++;
            }
        }
        return result;
    }
}
