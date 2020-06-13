package com.company;

public class LC283 {
    //将非0元素提前到数组中
//    利用多个指针来做 先把非零元素提前然后在将后面的元素置零
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int ele:nums){
            System.out.println(ele);
        }
    }
    public static  void moveZeroes(int[] nums) {
        int zeros= 0;
        for (int i = 0,j=0; i < nums.length; i++) {
            if(nums[i]==0){
                zeros++;
            }else {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = nums.length-zeros; i <nums.length ; i++) {
        nums[i] = 0;
        }
    }
}
