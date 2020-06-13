package com.company;

public class LC26 {
    public int removeDuplicates(int[] nums) {
        //  数组的问题留意双指针思路 双指针  可以一起跑可以倒序跑  可以速度一样也可以速度不一样
        if(nums.length==0||nums.length==1)
            return nums.length;
        int i = 0;
        int j= 1;
        while(j!=nums.length){
            if(nums[j]==nums[i]){
                j++;
            }else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i-1;
    }
}
