package com.company;

public class LC35 {
    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }
    public static int searchInsert(int[] nums, int target) {
        boolean targetGreater = nums[0] < target ?true:false;
        boolean state = targetGreater;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
            state=nums[i]<target?true:false;
            if(state != targetGreater){
                return i;
            }
        }
        return targetGreater == false ? 0 : nums.length;
    }
}
