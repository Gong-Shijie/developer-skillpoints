package com.company;

public class LC167 {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,1,2,3,5,7},4));
    }
    public static  int[] twoSum(int[] numbers, int target) {
        int l = 0,r = numbers.length-1;
        while(l<r){

            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }
            if(numbers[l]+numbers[r]>target){
                r--;
            }

            if(numbers[l]+numbers[r]<target){
                l++;
            }
        }
        return null;
    }
}
