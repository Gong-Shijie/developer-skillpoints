package com.company;

public class LC189 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3},1);
    }
    public static void rotate(int[] nums, int k) {

        k = k %nums.length;
        int[] numResult =new int[nums.length];
        for(int j = 0;j<nums.length;j++){
            numResult[j] =nums[(j+nums.length-k)%nums.length];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = numResult[i];
        }
    }

}
