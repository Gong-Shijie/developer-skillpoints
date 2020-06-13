package com.company;

public class LC55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
    public static  boolean canJump(int[] nums) {
        int nextMax[]  = new int[nums.length];
        int maxJump = 0;
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            nextMax[i] = i+nums[i];
        }
        maxJump = nextMax[0];
        while(ptr<nums.length-1){

            for (int i= ptr; i <=nextMax[ptr]; i++) {
                if(i>=nums.length-1)
                    return true;
                if(maxJump>=nums.length-1)
                    return true;
                if(nextMax[i]>=maxJump){
                    if(nextMax[i]>nums.length-1)
                        return true;
                    maxJump = nextMax[i];
                    ptr = i;
                }

            }

            maxJump = nextMax[ptr];
            if(maxJump <=ptr)
                return false;
        }
        return  true;
    }
}
