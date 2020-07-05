package com.company;

public class LC303 {
    int[] sum;
    public LC303(int[] nums) {
        if(nums!=null&&nums.length>0){
            int length = nums.length;
            sum =new int[length];
            sum[0]=nums[0];
            for (int i = 1; i < length; i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i==0?sum[j]:sum[j]-sum[i-1];
    }
}
