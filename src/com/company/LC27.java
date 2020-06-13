package com.company;
//移除指定元素然后将其他元素提前
//思路就是设置一个双指针一个指针不走除非得到了指定需要的元素
public class LC27 {
    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int result=0 ;
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] != val){
               nums[j] = nums[i]; j++;result++;
            }else {

            }
        }
        return result;
    }
}
